#include <stdio.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
}

void imprimirString(char v[])
{
  for (int i = 0; i < strlen(v); i++)
  {
    printf("%c", v[i]);
  }
  printf("\n");
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

void criptografarString(char v[])
{
  removerEspacosDuplos(v);
  removerEspacoFinal(v);
  removerEspacoInicio(v);
  int length = strlen(v), palavras = 1;
  for (int i = 0; i < length - 1; i++)
  {
    if (v[i] == ' ')
    {
      palavras++;
    }
  }

  char vMod[palavras][256];

  int j = 0, k = 0;
  for (int i = 0; i < 256; i++)
  {
    if (v[i] == ' ')
    {
      vMod[j][k] = '\0';
      j++;
      k = 0;
    }
    else
    {
      vMod[j][k] = v[i];
      k++;
    }
  }

  char vTemp[256];
  strcpy(vTemp, vMod[0]);
  strcpy(vMod[0], vMod[palavras - 1]);
  strcpy(vMod[palavras - 1], vTemp);

  char vResultante[256];
  int posResultante = 0;
  for (int i = 0; i < palavras; i++)
  {
    int length = strlen(vMod[i]);
    for (int j = 0; j < length; j++)
    {
      vResultante[posResultante++] = vMod[i][j];
      vResultante[posResultante] = '\0';

      if (j + 1 == length)
      {
        vResultante[posResultante++] = ' ';
        vResultante[posResultante] = '\0';
      }
    }
  }

  strcpy(v, vResultante);
}

int main()
{
  char v[256];
  inputString(v);
  criptografarString(v);
  imprimirString(v);
}