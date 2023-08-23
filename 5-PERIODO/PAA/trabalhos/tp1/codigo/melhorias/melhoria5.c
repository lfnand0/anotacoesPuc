#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#define PI 3.141592

unsigned char ReadElement(FILE *p)
{
  unsigned char element;
  if (1 != fread(&element, 1, 1, p))
  {
    printf("Corrupt data file.\n");
    exit(-1);
  }
  else
    return (element);
}

void DetSinCos(unsigned char element, float *sin_element, float *cos_element)
{
  *sin_element = sin(2.0 * PI * element / 360.0);
  *cos_element = cos(2.0 * PI * element / 360.0);
}

float DetOutput(unsigned char element, float *C)
{
  double rad = 2.0 * PI * element / 360.0;
  float res, sin_element = sin(rad);
  if ((element & 1) == 0) // MELHORIA 1 E 4
  {
    float cos_element = cos(rad);
    res = pow((float)(2.0 * sin_element + exp(cos_element)), 2);
  }
  else
  {
    res = exp(sin_element) * C[element];
  }

  return res;
}

float DetOutputLargeMatrix(unsigned char element, float *C, float *sin_cos_array)
{
  // MELHORIA 4  vvvvv
  float res = ((element & 1) == 0) ? pow((float)(2.0 * sin_cos_array[element] + exp(sin_cos_array[element + 256])), 2) : exp(sin_cos_array[element]) * C[element];

  return res;
}

int main(int argc, char **argv)
{
  FILE *data_file;
  int rows, cols, i, j, large_matrix = 0;
  unsigned char element, *M;
  float out_even, out_odd, *Q, C[256], sin_cos_array[256 * 2];

  /***** Comecar a medir o tempo aqui *****/
  clock_t start_time = clock();

  if (argc < 4)
  {
    printf("Sintaxe: %s file_name rows cols\n", argv[0]);
    exit(-1);
  }
  if (NULL == (data_file = fopen(argv[1], "rb")))
  {
    printf("File not found.\n");
    exit(-1);
  }
  rows = atoi(argv[2]);
  cols = atoi(argv[3]);

  if (!(M = (unsigned char *)malloc((long)rows * cols)))
  {
    printf("Not enough memory to read file.\n");
    exit(-1);
  }

  // A chance de existirem dois elementos iguais em um conjunto de 59
  // números aleatórios de 0 a 255 é maior que 99%
  // "Birthday Problem"

  // MELHORIA 3
  if (rows * cols > 59)
  {
    large_matrix = 1;
    for (int i = 0; i < 256; i++)
    {
      double rad = 2.0 * PI * i / 360.0;
      sin_cos_array[i] = sin(rad);
      sin_cos_array[i + 256] = cos(rad);
    }
  }

  for (i = 0; i < 256; i++)
    C[i] = 0.0;

  for (j = 0; j < rows; j++)
  {
    for (i = 0; i < cols; i++)
    {
      *(M + j * cols + i) = element = ReadElement(data_file); // MELHORIA 2
      C[element]++;
    }
  }

  fclose(data_file);

  if (!(Q = (float *)malloc((long)rows * cols * sizeof(float))))
  {
    printf("Not enough memory for output matrix.\n");
    exit(-1);
  }

  for (i = 1; i < 256; i += 2) // MELHORIA 5
    C[i] = (C[i] > 0) ? log(C[i]) : 0.0;

  for (i = 0; i < cols; i++)
    for (j = 0; j < rows; j++)
    {
      element = *(M + j * cols + i);
      // *(Q + j * cols + i) = DetOutput(element, C); // MELHORIA 1
      *(Q + j * cols + i) = large_matrix ? DetOutputLargeMatrix(element, C, sin_cos_array) : DetOutput(element, C);
    }

  /**** Medir o tempo at� aqui *****/
  double cpu_time = (double)(clock() - start_time);
  double exec_time = cpu_time * 1000 / CLOCKS_PER_SEC;

  /**** Sa�da apenas para verifica��o, n�o deve ser medida ****/

  for (i = 0; i < cols; i++)
    for (j = 0; j < rows; j++)
      printf("%f ", *(Q + j * cols + i));

  printf("\n------\nEXECUTION TIME: %lfms\n", exec_time);
}
