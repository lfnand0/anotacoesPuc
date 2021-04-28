#include <stdio.h>

int termoPA(int p1, int r, int n)
{
  int termoN = p1 + (n - 1) * r;
  return termoN;
}

int somaPA(int p1, int r, int n)
{
  int pN = termoPA(p1, r, n);
  int soma = (n * (p1 + pN)) / 2;
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

  printf("O %dº termo da progressão aritmética é %d.\n", n, termoPA(primeiroTermo, razao, n));
  printf("A soma dos %dº primeiros termos da progressão aritmética é %d.\n", n, somaPA(primeiroTermo, razao, n));
}