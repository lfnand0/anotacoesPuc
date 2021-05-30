#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>

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

void removerEspacos(char v[])
{
  int length = strlen(v);
  for (int i = 0; i < length; i++)
  {
    if (v[i] == ' ' || v[i] == '\n')
    {
      for (int j = i; j < length; j++)
      {
        v[j] = v[j + 1];
      }
      length--;
      i--;
    }
  }
}

void criptografarString(char v[])
{
  // removerEspacos(v);
  int length = strlen(v);
  v[length - 1] = '\0'; // retirando o \n do fim da string
  v[length] = 0;
  length = strlen(v);

  char vMod[length * 2 + 1];
  vMod[0] = '\0';
  for (int i = 1; i < length * 2 + 1; i++)
  {
    vMod[i] = 0; // limpando o vetor
  }

  int posMod = 0;
  for (int i = 0; i < length; i++)
  {
    int charParaNumero = v[i];
    char numeroParaChar[32]; // os valores da ASCII vão de 0 a 127
    // printf("debug: charP = %d, numP = %s\n", charParaNumero, numeroParaChar);
    sprintf(numeroParaChar, "%d", charParaNumero);
    // printf("debug: charP = %d, numP = %s\n", charParaNumero, numeroParaChar);
    for (int j = 0; j < strlen(numeroParaChar); j++)
    {
      vMod[posMod++] = numeroParaChar[j];
      vMod[posMod] = '\0';
    }
    if (i + 1 < length)
      vMod[posMod++] = ' ';
    vMod[posMod] = '\0';
  }
  length = strlen(vMod);
  strncpy(v, vMod, length);
}

void descriptografarString(char v[])
{
  int length = strlen(v), letras = 1;
  for (int i = 0; i < length - 1; i++)
  {
    if (v[i] == ' ')
    {
      letras++;
    }
  }

  char vMod[letras][256];

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

  int posResultante = 0;
  for (int i = 0; i < letras; i++)
  {
    v[posResultante++] = atoi(vMod[i]);
    v[posResultante] = '\0';
  }
}

int main()
{
  // int someInt = 368;
  // char str[12];
  // sprintf(str, "%d", someInt);
  // printf("str = %s, someInt = %d\n", str, someInt);
  char v[256];
  inputString(v);
  printf("Frase criptografada: \n");
  criptografarString(v);
  imprimirString(v);
  printf("Frase descriptografada: \n");
  descriptografarString(v);
  imprimirString(v);
}