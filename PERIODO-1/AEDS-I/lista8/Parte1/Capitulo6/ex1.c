#include <stdio.h>

int main()
{
  int v[6];
  for (int i = 0; i < 6; i++)
  {
    printf("Digite o %dº elemento do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  int contadorPares = 0;
  printf("\nNÚMEROS PARES: \n");
  for (int i = 0; i < 6; i++)
  {
    if (v[i] % 2 == 0)
    {
      printf("%d, ", v[i]);
      contadorPares++;
    }
  }
  printf("\nQuantidade de números pares: %d\n", contadorPares);

  int contadorImpares = 0;
  printf("\nNÚMEROS ÍMPARES: \n");
  for (int i = 0; i < 6; i++)
  {
    if (v[i] % 2 != 0)
    {
      printf("%d, ", v[i]);
      contadorImpares++;
    }
  }
  printf("\nQuantidade de números ímpares: %d\n", contadorImpares);
}