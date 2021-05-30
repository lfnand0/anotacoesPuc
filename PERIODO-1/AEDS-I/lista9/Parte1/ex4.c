#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void removerEspacoInicio(char v[])
{
  int length = strlen(v), posicao = 0, inicio = 0;
  char vOriginal[strlen(v)];
  strcpy(vOriginal, v);
  for (int i = 0; i < length; i++)
  {
    v[i] = 0;
    if (vOriginal[i] != ' ' && inicio == 0)
    {
      inicio = 1;
    }
    if (inicio == 1)
    {
      v[posicao] = vOriginal[i];
      posicao++;
    }
  }
}

void removerEspacoFinal(char v[])
{
  int length = strlen(v), posicao = 0, fim = 0;
  char vOriginal[strlen(v)];
  strcpy(vOriginal, v);
  for (int i = 0; i < 256; i++)
  {
    v[i] = 0; // limpando o vetor
  }
  for (int i = length - 2; i >= 0; i--)
  {
    if (vOriginal[i] != ' ' && fim == 0)
    {
      fim = i;
    }
  }
  for (int i = 0; i <= fim; i++)
  {
    v[i] = vOriginal[i];
  }
  v[fim + 1] = '\0';
}

void removerEspacosDuplos(char v[])
{
  int length = strlen(v);
  for (int i = 0; i < length; i++)
  {
    if (v[i] == ' ' && v[i + 1] == ' ')
    {
      for (int j = i + 1; j < length - 1; j++)
      {
        v[j] = v[j + 1];
      }
      i--;
      v[length] = v[length - 1] = 0;
      length--;
    }
  }
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
  removerEspacoInicio(v);
  removerEspacoFinal(v);
  removerEspacosDuplos(v);
  contarPalavras(v);
}