#include <stdio.h>

int main()
{
  int i, num, numeroDePrimos = 0;
  for (i = 0; i < 10; i++)
  {
    printf("Digite um número: ");
    scanf("%d", &num);
    // checando se é primo
    int j, divisores = 0;
    for (j = 1; j <= num; j++)
    {
      if (num % j == 0)
      {
        divisores++;
      }
    }
    if (divisores == 2)
    {
      numeroDePrimos++;
    }
  }
  printf("\nO número de primos é %d.\n", numeroDePrimos);
}