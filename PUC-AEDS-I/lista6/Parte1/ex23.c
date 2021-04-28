#include <stdio.h>

int formaTriangulo(int a, int b, int c)
{
  if (a > b + c || b > a + c || c > a + b)
  {
    return 0; // false
  }
  else
  {
    return 1; // true
  }
}

int tipoTriangulo(int a, int b, int c)
{
  if (formaTriangulo(a, b, c))
  {
    if (a == b && b == c)
    {
      return 1;
    }
    else if (a == b || b == c)
    {
      return 2;
    }
    else
    {
      return 3;
    }
  }
  return 0;
}

int main()
{
  int a, b, c;
  printf("Digite três valores: ");
  scanf("%d %d %d", &a, &b, &c);
  while (a <= 0 || b <= 0 || c <= 0)
  {
    printf("Erro: os valores precisam ser maiores que zero. Redigite-os: ");
    scanf("%d %d %d", &a, &b, &c);
  }
  if (formaTriangulo(a, b, c))
  {
    printf("Esses valores formam um triângulo.\n");
  }
  else
  {
    printf("Esses valores não formam um triângulo.\n");
  }

  if (tipoTriangulo(a, b, c) == 1)
  {
    printf("O triângulo é equilátero.\n");
  }
  else if (tipoTriangulo(a, b, c) == 2)
  {
    printf("O triângulo é isósceles.\n");
  }
  else if (tipoTriangulo(a, b, c) == 3)
  {
    printf("O triângulo é escaleno.");
  }
}