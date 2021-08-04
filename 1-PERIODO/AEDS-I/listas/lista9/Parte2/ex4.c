#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void palindromo(char v[])
{
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length / 2; i++)
  {
    if (v[i] == v[length - i - 1])
    {
      contador++;
    }
  }
  if (contador == length / 2)
  {
    printf("A palavra '%s' é um palíndromo\n", v);
  }
  else
  {
    printf("A palavra '%s' não é um palíndromo\n", v);
  }
}

int main()
{
  char v[256];
  inputString(v);
  palindromo(v);
}