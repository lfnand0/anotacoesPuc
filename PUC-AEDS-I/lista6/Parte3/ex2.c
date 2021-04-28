#include <stdio.h>

void termoPA(int p1, int r, int n, int *termoN)
{
  *termoN = p1 + (n - 1) * r;
}

void somaPA(int p1, int r, int n, int *soma)
{
  int pN;
  termoPA(p1, r, n, &pN);
  *soma = (n * (p1 + pN)) / 2;
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


  int termoN, soma;
  termoPA(primeiroTermo, razao, n, &termoN);
  somaPA(primeiroTermo, razao, n, &soma);
  printf("O %dº termo da progressão aritmética é %d.\n", n, termoN);
  printf("A soma dos %dº primeiros termos da progressão aritmética é %d.\n", n, soma);
}