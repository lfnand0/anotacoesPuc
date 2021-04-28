#include <stdio.h>
#include <math.h>

int termoPG(int p1, int r, int n)
{
  for (int i = 1; i < n; i++)
  {
    p1 *= r;
  }
  return p1;
}

int somaPG(int p1, int r, int n)
{
  int soma = p1 * ((pow((double)r, (double)n) - 1) / (r - 1));
  return soma;
}

int main()
{
  int primeiroTermo, razao, n;
  printf("Digite o primeiro termo: ");
  scanf("%d", &primeiroTermo);
  printf("Digite a razão: ");
  scanf("%d", &razao);
  printf("Digite o valor de n: ");
  scanf("%d", &n);

  printf("O %dº termo da progressão geométrica é %d.\n", n, termoPG(primeiroTermo, razao, n));
  printf("A soma dos %d primeiros termos da progressão geométrica é %d.\n", n, somaPG(primeiroTermo, razao, n));
}