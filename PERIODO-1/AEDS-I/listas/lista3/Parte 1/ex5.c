#include <stdio.h>

int main()
{
  int i = 1, j;
  while (i < 11)
  {
    printf("----------TABUADA DO %d----------\n", i);
    j = 1;
    while (j < 11)
    {
      printf("%d x %d = %d\n", i, j, i * j);
      j++;
    }
    i++;
  }
}