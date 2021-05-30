#include <stdio.h>
#include <string.h>

void inputString(char v[], char sub[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
  printf("Subcadeia: ");
  fgets(sub, 256, stdin);
  while (strlen(sub) > strlen(v))
  {
    printf("Erro! Tamanho incorreto. Digite outra subcadeia: ");
    fgets(sub, 256, stdin);
  }

  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
  sub[strlen(sub) - 1] = '\0';
  sub[strlen(sub)] = 0;
}

void buscaSubcadeia(char v[], char sub[])
{
  int length = strlen(v), subLength = strlen(sub);
  int quantSub = 0;
  for (int i = 0; i < length; i++)
  {
    int comparacoes = 0;
    if (v[i] == sub[0])
    {
      int posSub = 0;
      for (int j = i; j < subLength + i; j++)
      {
        if (v[j] == sub[posSub])
        {
          posSub++;
          comparacoes++;
          // printf("j = %d, COMPARACOES: %d\n", j, comparacoes);
        }
      }
      if (comparacoes == subLength)
      {
        quantSub++;
      }
    }
  }
  printf("A subcadeia '%s' aparece %d vez(es) na cadeia.\n", sub, quantSub);
}

int main()
{
  char v[256], sub[256];
  inputString(v, sub);
  buscaSubcadeia(v, sub);
}