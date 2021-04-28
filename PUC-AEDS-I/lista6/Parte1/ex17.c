#include <stdio.h>

int mdc(int a, int b)
{
  int mdc = 0;
  if (a > b)
  {
    // com esse if, o 'a' passa a ser obrigatóriamente menor ou igual a 'b' (necessário para o loop)
    int temp = a;
    a = b;
    b = temp;
  }
  for (int i = 1; i <= a; i++)
  {
    if (a % i == 0 && b % i == 0)
    {
      mdc = i;
    }
  }
  return mdc;
}

int main()
{
  int x, y;
  printf("Digite dois valores: ");
  scanf("%d %d", &x, &y);

  printf("O MDC de %d e %d é %d.\n", x, y, mdc(x, y));
}