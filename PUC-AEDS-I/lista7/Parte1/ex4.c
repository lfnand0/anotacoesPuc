#include <stdio.h>

/*
int somaDigitos(int x)
{
  int soma = 0, digito, i = 0;
  while (x >= 1)
  {
    i++;
    digito = x - ((x / 10) * 10);
    soma += digito;
    x /= 10;
  }
  return soma;
}
*/
int somaDigitos(int x) {
  if (x < 0) {
    x *= -1;
  }
  if (x / 10 < 1) {
    return x;
  }
  return (x - ((x / 10) * 10)) + somaDigitos(x / 10);
}

int main() {
  int x;
  printf("Digite o valor de x: ");
  scanf("%d", &x);
  printf("A soma dos dígitos de %d é %d.\n", x, somaDigitos(x));
}
