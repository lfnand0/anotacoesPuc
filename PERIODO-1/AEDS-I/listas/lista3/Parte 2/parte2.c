#include <stdio.h>

/************************************************
Dado um número L > 0 entrado pelo usuário, faça
um programa que imprima os L primeiros elementos
da série de Fibonacci
************************************************/

int main()
{
  int L;
  printf("Digite o valor de L: ");
  scanf("%d", &L);
  if (L <= 0)
  {
    printf("Erro: L precisa ser maior que 0.\n");
    return 0;
  }
  int F = 1, anterior = 0, temp;
  printf("%d", F);
  int i = 0;
  while (i < L - 1)
  { // se L for 1, o loop não será executado
    temp = anterior;
    anterior = F;
    F = F + temp;
    printf(", %d", F);
    i++;
  }
  printf("\n");
}