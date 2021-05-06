#include <stdio.h>

int main()
{
  int v[7];
  for (int i = 0; i < 7; i++)
  {
    printf("Digite o %dº elemento do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  printf("\nNÚMEROS DIVISÍVEIS POR 2: \n");
  for (int i = 0; i < 7; i++)
  {
    if (v[i] % 2 == 0)
    {
      printf("%d, ", v[i]);
    }
  }

  printf("\nNÚMEROS DIVISÍVEIS POR 3: \n");
  for (int i = 0; i < 7; i++)
  {
    if (v[i] % 3 == 0)
    {
      printf("%d, ", v[i]);
    }
  }

  printf("\nNÚMEROS DIVISÍVEIS POR 2 E POR 3: \n");
  for (int i = 0; i < 7; i++)
  {
    if (v[i] % 6 == 0)
    {
      printf("%d, ", v[i]);
    }
  }
}