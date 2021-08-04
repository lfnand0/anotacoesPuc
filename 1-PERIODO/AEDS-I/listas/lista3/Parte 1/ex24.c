#include <stdio.h>

int main()
{
  int max, min, num;
  printf("Para parar o programa, digite 0 a qualquer momento.\n");

  // evitando conflitos:
  max = -2147483647; //MENOR valor possível para um número de tipo int
  min = 2147483647;  //MAIOR valor possível para um número de tipo int
  while (1 == 1)
  {
    printf("Digite um valor: ");
    scanf("%d", &num);
    if (num == 0)
    {
      printf("\nMaior valor: %d\n", max);
      printf("Menor valor: %d\n", min);
      return 0;
    }
    if (num < 0)
    {
      printf("Erro: o valor não pode ser negativo.\n");
    }
    else
    {
      num > max ? max = num : 0;
      num < min ? min = num : 0;
    }
  }
}