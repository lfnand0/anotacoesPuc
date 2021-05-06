#include <stdio.h>

int main()
{
  int A[10];

  for (int i = 0; i < 10; i++)
  {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%d", &A[i]);
  }

  int B[10], contador = 0;

  for (int i = 0; i < 10; i++)
  {
    B[i] = 0; // limpando vetor
    if (A[i] > 0)
    {
      B[contador] = A[i];
      contador++;
    }
  }

  printf("\nVetor resultante: \n");
  for (int i = 0; i < 10; i++)
  {
    printf("%d, ", B[i]);
  }
  printf("\n");
}
