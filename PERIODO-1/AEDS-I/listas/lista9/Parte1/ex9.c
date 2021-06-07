#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void posicaoCaractere(char v[], char caractere)
{
  int length = strlen(v), posicao = 0;
  for (int i = 0; i < length; i++)
  {
    if (v[i] == caractere && posicao == 0)
      posicao = i + 1;
  }
  if (posicao == 0)
  {
    printf("O caractere '%c' não foi encontrado na string.\n", caractere);
  }
  else
  {
    printf("O caractere '%c' aparece pela primeira vez na %dº posição.\n", caractere, posicao);
  }
}

int main()
{
  char v[256], caractere;
  inputString(v);
  printf("Digite o caractere que você deseja procurar na string: ");
  scanf(" %c", &caractere);
  posicaoCaractere(v, caractere);
}