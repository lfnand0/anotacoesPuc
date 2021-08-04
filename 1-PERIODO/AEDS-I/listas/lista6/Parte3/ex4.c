#include <stdio.h>
#include <math.h>

void termoPG(int p1, int r, int n, int *termoN)
{
  for (int i = 1; i < n; i++)
  {
    p1 *= r;
  }
  *termoN = p1;
}

void somaPG(int p1, int r, int n, int *soma)
{
  *soma = p1 * ((pow((double)r, (double)n) - 1) / (r - 1));
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
  termoPG(primeiroTermo, razao, n, &termoN);
  somaPG(primeiroTermo, razao, n, &soma);
  printf("O %dº termo da progressão geométrica é %d.\n", n, termoN);
  printf("A soma dos %d primeiros termos da progressão geométrica é %d.\n", n, soma);
}