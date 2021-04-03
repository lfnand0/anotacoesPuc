#include <stdio.h>

int main()
{
  int num, somaPar, somaPrimo, i;
  somaPar = somaPrimo = i = 0;
  while (i < 10)
  {
    printf("Digite um número: ");
    scanf("%d", &num);
    if (num % 2 == 0)
    {
      somaPar += num;
    }
    else
    {
      int divisores = 0, j = 1;
      while (j <= num)
      {
        if (num % j == 0)
        {
          divisores++;
        }
        j++;
      }
      if (divisores == 2)
      {
        somaPrimo += num;
      }
    }
    i++;
  }
  printf("A soma dos números pares é %d, e a dos números primos é %d.\n", somaPar, somaPrimo);
}