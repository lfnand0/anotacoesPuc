#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void contadorLetras(char v[]) {
  int length = strlen(v), contador = 0;
  for (int i = 0; i < length - 1; i++) {
    // A - Z -> 65 - 90; a - z -> 97 - 122
    if ((v[i] >= 65 && v[i] <= 90) || (v[i] >= 97 && v[i] <= 122)) {
      contador++;
    }
  }
  printf("Número de letras: %d.\n", contador);
}

int main() {
  char v[256];
  inputString(v);
  contadorLetras(v);
}