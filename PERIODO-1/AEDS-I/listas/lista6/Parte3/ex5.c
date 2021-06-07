#include <stdio.h>

void somaDigitos(int x, int *soma)
{
  *soma = 0;
  int digito, i = 0;
  while (x >= 1)
  {
    i++;
    digito = x - ((x / 10) * 10);
    // Como a variável é do tipo int, ao dividirmos por 10 ela não terá casa decimal.
    // Ao multiplicar por 10 depois da divisão, teremos o mesmo número sem a última
    // casa decimal, e podemos tirar a diferenca entre os dois para sabermos o dígito.
    *soma += digito;
    x /= 10;
  }
}

void produtoDigitos(int x, int *produto)
{
  *produto = 1; 
  int digito, i = 0;
  while (x >= 1)
  {
    i++;
    digito = x - ((x / 10) * 10);
    // Mesma lógica da soma
    *produto *= digito;
    x /= 10;
  }
}

int main()
{
  int x, soma, produto;
  printf("Digite um número inteiro: ");
  scanf("%d", &x);
  somaDigitos(x, &soma);
  produtoDigitos(x, &produto);
  printf("A soma dos dígitos do número %d é %d.\n", x, soma);
  printf("O produto dos dígitos do número %d é %d.\n", x, produto);
}