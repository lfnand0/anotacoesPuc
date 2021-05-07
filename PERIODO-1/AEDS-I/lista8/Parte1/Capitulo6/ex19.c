#include <stdio.h>

int main()
{
  int v1[10], v2[10];

  for (int i = 0; i < 10; i++)
  {
    printf("Digite o %dº valor do primeiro vetor: ", i + 1);
    scanf("%d", &v1[i]);
  }
  for (int i = 0; i < 10; i++)
  {
    printf("Digite o %dº valor do segundo vetor: ", i + 1);
    scanf("%d", &v2[i]);
  }

  int vResultante[10];
  for (int i = 0; i < 10; i++)
  {
    vResultante[i] = v1[i] * v2[i];
  }

  printf("Vetor resultante: \n");
  for (int i = 0; i < 10; i++)
  {
    printf("%d, ", vResultante[i]);
  }
  printf("\n");
}
