#include <stdio.h>

int main()
{
  int m[3][5];
  for (int i = 0; i < 3; i++)
  {
    for (int j = 0; j < 5; j++)
    {
      printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1,
             j + 1);
      scanf("%d", &m[i][j]);
    }
    printf("\n");
  }

  int quantidade = 0;
  for (int i = 0; i < 3; i++)
  {
    for (int j = 0; j < 5; j++)
    {
      if (m[i][j] >= 15 && m[i][j] <= 20)
      {
        quantidade++;
      }
    }
  }
  printf("Existem %d elementos entre 15 e 20 na matriz.\n", quantidade);
}
