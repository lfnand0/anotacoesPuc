#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int B(int p, int q, int v[]) {
  int k, r1, r2;

  if (q - p > 1) {
    k = (p + q)/2;
    r1 = B(p, k, v);
    r2 = B(k+1, q, v);
    if (v[r1] >= v[r2]) {
      return r1;
    } else {
      return r2;
    }
  } else {
    if (v[p] >= v[q]) {
      return p;
    } else {
      return q;
    }
  }
}

int main() {
  int v[] = {1, 2, 3, 4, 7, 10, 7, 8, 9};

  printf("%d\n", B(0, 8, v));
}