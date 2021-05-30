#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void stringContemCaractere(char v[], char caractere)
{
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length; i++)
  {
    if (v[i] == caractere)
      contador++;
  }
  if (contador == 0)
  {
    printf("O caractere '%c' não foi encontrado na string.\n", caractere);
  }
  else
  {
    printf("O caractere '%c' aparece %d vezes na string.\n", caractere, contador);
  }
}

int main()
{
  char v[256], caractere;
  inputString(v);
  printf("Digite o caractere que você deseja procurar na string: ");
  scanf(" %c", &caractere);
  stringContemCaractere(v, caractere);
}