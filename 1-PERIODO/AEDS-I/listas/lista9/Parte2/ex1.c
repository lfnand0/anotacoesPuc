#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void contarPalavras(char v[])
{
  // o número de palavras, depois de passar pela filtragem, é o número de espaços + 1
  int length = strlen(v), palavras = 1;
  for (int i = 0; i < length; i++)
  {
    if (v[i] == ' ')
      palavras++;
  }
  printf("O número de palavras na frase '%s' é %d\n", v, palavras);
}

int main()
{
  char v[256];
  inputString(v);
  contarPalavras(v);
}