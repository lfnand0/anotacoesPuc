#include <stdio.h>
#include <string.h>

void inputDuasStrings(char v1[], char v2[])
{
  printf("String 1: ");
  fgets(v1, 256, stdin);
  printf("String 2: ");
  fgets(v2, 256, stdin);
}

void permutacao(char v1[], char v2[])
{
  int length1 = strlen(v1) - 1;
  int length2 = strlen(v2) - 1;
  v1[length1] = v2[length2] = '\0'; // o penúltimo caractere da string é um '\n' por causa do fgets -> essa linha remove ele para não causar problemas na formatação do output
  int verdadeiro = 0;               // se nem todos os caracteres forem iguais, esse valor será 1
  if (length1 != length2)
  {
    verdadeiro = 1;
  }
  else
  {
    for (int i = 0; i < length1; i++)
    {
      int contador1 = 0, contador2 = 0; // a quantidade de vezes que a letra aparece na string 1 e 2;
      for (int j = 0; j < length1; j++)
      {
        if (v1[i] == v1[j])
          contador1++;
        if (v1[i] == v2[j])
          contador2++;
      }
      if (contador1 != contador2)
        verdadeiro = 1;
    }
  }

  if (verdadeiro == 0)
  {
    printf("'%s' é uma permutação de '%s'.\n", v1, v2);
  }
  else
  {
    printf("'%s' não é uma permutação de '%s'.\n", v1, v2);
  }
}

int main()
{
  char v1[256], v2[256];
  inputDuasStrings(v1, v2);
  permutacao(v1, v2);
}