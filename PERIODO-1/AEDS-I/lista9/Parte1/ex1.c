#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void inverterString(char v[])
{
  int length = strlen(v) - 1;
  for (int i = 0; i < length / 2; i++)
  {
    char temp = v[i];
    v[i] = v[length - i - 1];
    v[length - i - 1] = temp;
  }
}

void criptografarString(char v[])
{
  int length = strlen(v) - 1;
  for (int i = 0; i < length; i++)
  {
    if (v[i] != 'a' && v[i] != 'A' && v[i] != 'e' && v[i] != 'E' && v[i] != 'i' && v[i] != 'I' && v[i] != 'o' && v[i] != 'O' && v[i] != 'u' && v[i] != 'U' && v[i] != ' ')
    {
      v[i] = '#';
    }
  }
}

void imprimirString(char v[])
{
  printf("%s\n", v);
}

int main()
{
  char v[256];
  inputString(v);
  inverterString(v);
  printf("Mensagem criptografada: ");
  criptografarString(v);
  imprimirString(v);
}