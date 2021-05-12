#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void imprimirString(char v[]) {
  for (int i = 0; i < strlen(v) - 1; i++) {
    printf("%c", v[i]);
  }
}

void removendoChar(char v[]) {
  int length = strlen(v) + 1;
  for (int i = 0; i < length; i++) {
    if (v[i] == ' ') {
      for (int j = i; j < length - 1; j++) {
        v[j] = v[j + 1];
      }
      length--;
      i--;
    }
  }
}

int main() {
  char v[256];
  inputString(v);
  removendoChar(v);
  printf("Output: ");
  imprimirString(v);
}