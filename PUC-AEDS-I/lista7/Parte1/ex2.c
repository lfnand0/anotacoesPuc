#include <stdio.h>

int fatorial(int n) {
  if (n <= 1) {
    return 1;
  }
  return n * fatorial(n - 1);
}

int main() {
  int x;
  printf("Digite o valor de x: ");
  scanf("%d", &x);
  while (x < 0) {
    printf("Erro: Digite um valor maior ou igual a 0: ");
    scanf("%d", &x);
  }
  printf("O fatorial de %d é %d.\n", x, fatorial(x));
}
