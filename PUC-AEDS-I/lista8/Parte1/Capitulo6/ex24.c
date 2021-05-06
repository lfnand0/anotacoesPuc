#include <stdio.h>

int main()
{
  int v[15];
  for (int i = 0; i < 15; i++)
  {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  int vResultante[15], contador = 0;
  // a variável contador serve para posicionar os valores no vetor resultante
  for (int i = 0; i < 15; i++)
  {
    vResultante[i] = 0; // limpando vetor
    int divisores = 0;
    if (v[i] % 2 != 0)
    {
      for (int j = v[i] - 2; j > 0; j -= 2)
      {
        if (v[i] % j == 0)
        {
          divisores++;
        }
      }
    }
    if (divisores == 1 || v[i] == 2)
    {
      vResultante[contador] = v[i];
      contador++;
    }
  }

  printf("Vetores resultantes: \n");
  for (int i = 0; i < 15; i++)
  {
    printf("%d, ", vResultante[i]);
  }
  printf("\n");
}
