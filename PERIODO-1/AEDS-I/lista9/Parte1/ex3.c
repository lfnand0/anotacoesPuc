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

void removendoChar(char v[])
{
  int length = strlen(v), posicao = 0;
  char vOriginal[strlen(v)];
  strcpy(vOriginal, v);
  for (int i = 0; i < length; i++)
  {
    v[i] = 0;
    if (vOriginal[i] != ' ')
    {
      v[posicao] = vOriginal[i];
      posicao++;
    }
  }
}

// void removendoChar(char v[]) {
//   int length = strlen(v) + 1;
//   for (int i = 0; i < length; i++) {
//     if (v[i] == ' ') {
//       for (int j = i; j < length - 1; j++) {
//         v[j] = v[j + 1];
//       }
//       length--;
//       i--;
//     }
//   }
// }

int main()
{
  char v[256];
  inputString(v);
  removendoChar(v);
  printf("Output: ");
  imprimirString(v);
}