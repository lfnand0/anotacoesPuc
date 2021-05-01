#include <stdio.h>

int mdcEuclides(int a, int b) {
  if (b < 1) {
    return a;
  } else {
    return mdcEuclides(b, a % b);
  }
}

int main() {
  int a, b;
  printf("Digite dois valores: ");
  scanf("%d %d", &a, &b);
  printf("O MDC de %d e %d é %d.\n", a, b, mdcEuclides(a, b));
}
