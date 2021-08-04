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

  char vResultante[256];
  int posResultante = 0;
  for (int i = 0; i < palavras - 1; i += 2)
  {
    int len1 = strlen(vMod[i]), len2 = strlen(vMod[i + 1]);
    int fim1 = 0, fim2 = len2 - 1;
    while (fim1 < len1 || fim2 >= 0)
    {
      if (fim1 < len1)
      {
        vResultante[posResultante] = vMod[i][fim1];
        vResultante[posResultante + 1] = '\0';
        posResultante++;
        fim1++;
      }
      if (fim2 >= 0)
      {
        vResultante[posResultante] = vMod[i + 1][fim2];
        vResultante[posResultante + 1] = '\0';
        posResultante++;
        fim2--;
      }
    }
    if (i + 1 < palavras - 1)
    {
      vResultante[posResultante] = ' ';
      vResultante[posResultante + 1] = '\0';
      posResultante++;
    }
    else
    {
      vResultante[posResultante] = '\0';
      posResultante++;
    }
  }

  if (palavras % 2 != 0)
  {
    int length = strlen(vMod[palavras - 1]);
    for (int i = length - 1; i >= 0; i--)
    {
      vResultante[posResultante] = vMod[palavras - 1][i];
      vResultante[posResultante + 1] = '\0';
      posResultante++;
    }
  }

  strcpy(v, vResultante);
}

int main()
{
  char v[256];
  inputString(v);
  criptografarString(v);
  printf("Frase criptografada: ");
  imprimirString(v);
}