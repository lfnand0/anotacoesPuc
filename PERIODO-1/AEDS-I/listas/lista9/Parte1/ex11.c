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

int contadorUmaPalavra(char v[], char palavra[])
{
  // retorna quantas vezes uma palavra aparece na string -> usada na funcao contadorPalavras
  int contador = 0, length = strlen(v), lengthPalavra = strlen(palavra);
  for (int i = 0; i < length; i++)
  {
    int ocorre = 0; // após o loop a seguir, esse valor será igual à lengthPalavra caso a palavra apareça na string
    for (int j = 0; j < lengthPalavra; j++)
    {
      if (v[j + i] == palavra[j])
      {
        ocorre++;
      }
    }
    if (ocorre == lengthPalavra && (v[i + lengthPalavra] == ' ' || v[i + lengthPalavra] == '\0' || v[i + lengthPalavra] == '\n') && (i == 0 || v[i - 1] == ' '))
    {
      // o caractere antes da palavra precisa ser um espaço ou a palavra começa na posição inicial;
      // o caractere depois precisa ser ou um espaço, ou um \n, ou um \0;
      contador++;
    }
  }
  return contador;
}

void contadorPalavras(char v[])
{
  char vMod[256], palavra[256];
  // copiando o conteúdo de v para vMod, para que possamos modificá-lo sem modificar a string original
  strcpy(vMod, v);

  removerEspacosDuplos(vMod);
  removerEspacoFinal(vMod);
  removerEspacoInicio(vMod);

  int length = strlen(vMod), posicaoPalavra = 0;
  for (int i = 0; i <= length; i++)
  {
    // printf("DEBUG: palavra = %s, vMod = %s\n", palavra, vMod);
    if (vMod[i] != ' ' && vMod[i] != '\n' && vMod[i] != '\0')
    {
      palavra[posicaoPalavra] = vMod[i];
      palavra[posicaoPalavra + 1] = '\0';
      posicaoPalavra++;
    }
    else
    {
      printf("Ocorrências da palavra '%s' = %d.\n", palavra, contadorUmaPalavra(vMod, palavra));
      for (int j = 0; j < 256; j++)
      {
        palavra[j] = 0;
      }
      posicaoPalavra = 0;
    }
  }
}

int main()
{
  char v[256];
  inputString(v);
  contadorPalavras(v);
}