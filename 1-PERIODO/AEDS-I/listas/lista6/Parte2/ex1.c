#include <stdio.h>

void termoPA(int x, int r, int n, int *termoN)
{
    *termoN = x + (n - 1) * r;
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
    termoPA(primeiroTermo, razao, n, &termoN);
    printf("O %dº termo da progressão aritmética é %d.\n", n, termoN);
}