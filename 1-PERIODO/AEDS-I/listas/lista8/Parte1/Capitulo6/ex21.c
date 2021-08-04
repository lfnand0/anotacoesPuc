#include <stdio.h>

int main()
{
  int v[10];

  for (int i = 0; i < 10; i++)
  {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  int vResultante[10];
  for (int i = 0; i < 10; i++)
  {
    if (v[i] == 0)
    {
      vResultante[i] = 1;
    }
    else
    {
      vResultante[i] = v[i];
    }
  }

  printf("\nVetor resultante: \n");
  for (int i = 0; i < 10; i++)
  {
    printf("%d, ", vResultante[i]);
  }
  printf("\n");
}
