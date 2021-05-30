#include <stdio.h>
#include <string.h>
/*
  ESPAÇO = 32;
  A -> Z = 65 -> 90
  a -> z = 97 -> 122
  0 -> 9 = 48 -> 57
*/

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void contadorLetras(char v[])
{
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length - 1; i++)
  {
    // A - Z -> 65 - 90; a - z -> 97 - 122
    if ((v[i] >= 65 && v[i] <= 90) || (v[i] >= 97 && v[i] <= 122))
    {
      contador++;
    }
  }
  printf("Número de letras: %d.\n", contador);
}

void contadorNumeros(char v[])
{
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length - 1; i++)
  {
    if (v[i] >= 48 && v[i] <= 57)
    {
      contador++;
    }
  }
  printf("Número de números: %d.\n", contador);
}

void contadorEspacos(char v[])
{
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length - 1; i++)
  {
    // A - Z -> 65 - 90; a - z -> 97 - 122
    if (v[i] == 32)
    {
      contador++;
    }
  }
  printf("Número de espaços: %d.\n", contador);
}

int main()
{
  char v[256];
  inputString(v);
  contadorLetras(v);
  contadorNumeros(v);
  contadorEspacos(v);
}