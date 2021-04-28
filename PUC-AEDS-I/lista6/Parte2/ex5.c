#include <stdio.h>

int somaDigitos(int x)
{
  int soma = 0, digito, i = 0;
  while (x >= 1)
  {
    i++;
    digito = x - ((x / 10) * 10);
    // Como a variável é do tipo int, ao dividirmos por 10 ela não terá casa decimal.
    // Ao multiplicar por 10 depois da divisão, teremos o mesmo número sem a última
    // casa decimal, e podemos tirar a diferenca entre os dois para sabermos o dígito.
    soma += digito;
    x /= 10;
  }
  return soma;
}

int produtoDigitos(int x)
{
  int produto = 1, digito, i = 0;
  while (x >= 1)
  {
    i++;
    digito = x - ((x / 10) * 10);
    // Mesma lógica da soma
    produto *= digito;
    x /= 10;
  }
  return produto;
}

int main()
{
  int x;
  printf("Digite um número inteiro: ");
  scanf("%d", &x);
  printf("A soma dos dígitos do número %d é %d.\n", x, somaDigitos(x));
  printf("O produto dos dígitos do número %d é %d.\n", x, produtoDigitos(x));
}