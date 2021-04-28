#include <stdio.h>

float power(float x, float z)
{
  float total = x;
  if (z > 0)
  {
    for (int i = 1; i < z; i++)
    {
      total *= x;
    }
  }
  else if (z == 0)
  {
    total = 1;
  }
  else
  {
    total = 1;
    for (int i = 0; i > z; i--)
    {
      total /= x;
    }
  }
  return total;
}

int main()
{
  float x, z;
  printf("Digite o valor de n e de z: ");
  scanf("%f %f", &x, &z);
  printf("%.1f elevado a %.1f é %.4f.\n", x, z, power(x, z));
}