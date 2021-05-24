#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void imprimirString(char v[]) {
  for (int i = 0; i < strlen(v); i++) {
    printf("%c", v[i]);
  }
  printf("\n");
}

void descriptografarString(char v[], char vogais[], int posicao[]) {
  int length = strlen(vogais) + strlen(v), posVogais = 0;
  for (int i = 0; i < 19; i++) {
  }
  for (int i = 0; i < length; i++) {
    if (i == posicao[posVogais]) {
      for (int j = length; j >= i; j--) {
        v[j + 1] = v[j];
      }
      v[i] = vogais[posVogais];
      posVogais++;
    }
  }
  printf("Fase descriptografada: '%s'\n", v);
}

void criptografarString(char v[]) {
  int length = strlen(v), posVogais = 0;
  int posicao[256];
  char vogais[256];

  for (int i = 0; i < length; i++) {
    if (v[i] == 'a' || v[i] == 'A' ||
        v[i] == 'e' || v[i] == 'E' ||
        v[i] == 'i' || v[i] == 'I' ||
        v[i] == 'o' || v[i] == 'O' ||
        v[i] == 'u' || v[i] == 'U') {
      posicao[posVogais] = i + posVogais;
      vogais[posVogais] = v[i];
      vogais[posVogais + 1] = '\0';
      posVogais++;
      for (int j = i; j <= length; j++) {
        v[j] = v[j + 1];
      }
      i--;
      length--;
    }
  }
  printf("Fase criptografada: '%s'\n", v);
  descriptografarString(v, vogais, posicao);
}

int main() {
  char v[256];
  inputString(v);
  criptografarString(v);
}