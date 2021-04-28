#include <stdio.h>

void termoPG(int p1, int r, int n, int *termoN)
{
  for (int i = 1; i < n; i++)
  {
    p1 *= r;
  }
  *termoN = p1;
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

  int termoN;
  termoPG(primeiroTermo, razao, n, &termoN);
  printf("O %dº termo da progressão geométrica é %d.\n", n, termoN);
}