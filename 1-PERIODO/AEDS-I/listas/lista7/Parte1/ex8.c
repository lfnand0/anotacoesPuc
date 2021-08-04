#include <stdio.h>

int F(int n) {
  if (n == 1) {
    return 1;
  } else if (n == 2) {
    return 2;
  } else if (n % 2 != 0) {
    return 2 * F(n - 1) + 3 * F(n - 2);
  } else {
    return 0;
  }
}

int main() {
  int n;
  printf("Digite um valor: ");
  scanf("%d", &n);
  printf("O resultado da sequência F tendo o valor de n = %d é %d.\n", n, F(n));
}
