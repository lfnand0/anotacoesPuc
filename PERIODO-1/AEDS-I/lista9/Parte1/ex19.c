#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void imprimirString(char v[]) {
  for (int i = 0; i < strlen(v); i++) {
    printf("%c", v[i]);
  }
  printf("\n");
}

void criptografarString(char v[]) {
  int length = strlen(v);
  for (int i = 0; i < length; i++) {
    if (v[i] == 'a' || v[i] == 'A') {
      v[i] = '1';
    } else if (v[i] == 'e' || v[i] == 'E') {
      v[i] = '2';
    } else if (v[i] == 'i' || v[i] == 'I') {
      v[i] = '3';
    } else if (v[i] == 'o' || v[i] == 'O') {
      v[i] = '4';
    } else if (v[i] == 'u' || v[i] == 'U') {
      v[i] = '5';
    }
  }
}

int main() {
  char v[256];
  inputString(v);
  criptografarString(v);
  imprimirString(v);
}