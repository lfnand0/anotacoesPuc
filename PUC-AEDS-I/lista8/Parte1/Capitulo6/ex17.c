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

  int vFinal[20];
  for (int i = 0; i < 20; i++)
  {
    if (i < 10)
    {
      vFinal[i] = v1[i];
    }
    else
    {
      vFinal[i] = v2[i - 10];
    }
  }

  for (int i = 0; i < 19; i++)
  {
    for (int j = 0; j < 19 - i; j++)
    {
      if (vFinal[j] < vFinal[j + 1])
      {
        int temp = vFinal[j];
        vFinal[j] = vFinal[j + 1];
        vFinal[j + 1] = temp;
      }
    }
  }

  printf("Vetor Resultante: \n");
  for (int i = 0; i < 20; i++)
  {
    printf("%d, ", vFinal[i]);
  }
  printf("\n");
}
