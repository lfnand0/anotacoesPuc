#include <stdio.h>

int Fatorial(double num) {
  double temp = 1;
  if (num == 0) {
    temp = 1;
    return temp;
  }
  while (num > 1) {
    temp = temp * num;
    num -= 1;
  }
  return temp;
}

int main() {
  int i;
  float total = 0;
  for (i = 0; i < 20; i++) {
    double fatorial = Fatorial(i);
    int m = 100 - i;
    double n = (double) m/fatorial;
    total += n;
  }
  printf("S = %f\n", total);
}