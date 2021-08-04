#include <stdio.h>

int fibonacci(int n) {
  if (n == 1 || n == 2) {
    return 1;
  }
  return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
  int n;
  printf("Digite o valor de n: ");
  scanf("%d", &n);
  while (n <= 0) {
    printf("Erro: o valor precisa ser positivo. Redigite-o: ");
    scanf("%d", &n);
  }
  printf("O %dº valor da sequência de Fibonacci é %d.\n", n, fibonacci(n));
}
