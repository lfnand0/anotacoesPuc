#include <stdio.h>

int main()
{
  int A[5], B[5];

  for (int i = 0; i < 5; i++)
  {
    printf("Digite o %dº valor do vetor A: ", i + 1);
    scanf("%d", &A[i]);
  }
  for (int i = 0; i < 5; i++)
  {
    printf("Digite o %dº valor do vetor B: ", i + 1);
    scanf("%d", &B[i]);
  }

  int vResultante[5];
  for (int i = 0; i < 5; i++)
  {
    vResultante[i] += A[i] - B[4 - i];
  }

  printf("\nResultado de todas as subtrações realizadas: \n");
  for (int i = 0; i < 5; i++)
  {
    printf("%d, ", vResultante[i]);
  }
  printf("\n");
}
