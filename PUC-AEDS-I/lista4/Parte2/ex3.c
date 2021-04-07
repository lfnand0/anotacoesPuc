#include <stdio.h>
#include <math.h>

int main() {
  double i;
  double total = 0;
  for (i = 0; i < 15; i++) {
    double n = (pow(2, i))/(pow(15 - i, 2));
    total += n;
  }
  printf("S = %f\n", total);
}