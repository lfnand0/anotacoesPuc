#include <stdio.h>

void primosAcimaDe100()
{
  int n = 100;
  for (int i = 0; i < 3; i++)
  {
    for (int j = 2; j < n; j++)
    {
      if (n % j == 0)
      {
        n++;
      }
    }
    printf("%d ", n);
    n++;
  }
}

int main()
{
  primosAcimaDe100();
}