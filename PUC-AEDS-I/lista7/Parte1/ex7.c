#include <stdio.h>
float sequencia(float n) {
  if (n < 2) {
    return 0;
  } else {
    return (1 / n) + sequencia(n - 1);
  }
}

int main() {
  float n;
  printf("Digite o valor de n: ");
  scanf("%f", &n);
  printf("O valor da sequência é %f.\n", sequencia(n));
}
