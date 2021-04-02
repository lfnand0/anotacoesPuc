#include <stdio.h>

/************************************************
Dado um número L > 0 entrado pelo usuário, faça
um programa que imprima os L primeiros elementos
da série de Fibonacci
************************************************/

int main() {
  int L;
  printf("Digite o valor de L: ");
  scanf("%d", &L);
  if (L <= 0) {
    printf("Erro: L precisa ser maior que 0.\n");
    return 0;
  }
    int F0 = 1;
    int F = 1;
    int anterior;
    printf("%d", F0);
    int i;
    while (i < L - 1) { // se L for 1, o loop não será executado
      anterior = F;
      F = F + anterior;
      printf(", %d", anterior);
      i++;
  }
  printf("\n");
}