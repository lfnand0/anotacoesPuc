#include <stdio.h>

int f(int a, int b)
{
  if (b == 0)
    return a;
  else
    return f(b, a % b);
}

int main() {
  int a = 30, b = 21;
  printf("%d\n", f(a, b));
}