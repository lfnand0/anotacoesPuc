#include <stdio.h>

void divide(int a, int b, int *d, int *r) {
  (*d) = a / b;
  (*r) = a % b;
}

int main() {
  int d = 0;
  int r = 0;
  printf("d = %d, r = %d\n", d, r);
  divide(5, 2, &d, &r);
  printf("d = %d, r = %d\n", d, r);
}
