#include <stdio.h>

int somaN(int n) {
  if (n == 1) {
    return 1;
  }
  return n + somaN(n - 1);
}

int main() {
  int n;
  printf("Digite o valor de n: ");
  scanf("%d", &n);
  printf("A soma dos números de 1 a %d é %d", n, somaN(n));
}
