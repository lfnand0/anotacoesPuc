#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void contadorSequencia(char v[]) {
  int length = strlen(v);
  int maiorSequencia = 1, sequenciaAtual = 1;
  char maiorSequenciaChar = v[0], charAtual = v[0];
  for (int i = 1; i < length; i++) {
    if (charAtual == v[i]) {
      sequenciaAtual++;
      if (sequenciaAtual > maiorSequencia) {
        maiorSequencia = sequenciaAtual;
        maiorSequenciaChar = charAtual;
      }
    } else {
      charAtual = v[i];
      sequenciaAtual = 1;
    }
  }
  printf("Maior: '%c', tamanho: %d\n", maiorSequenciaChar, maiorSequencia);
}

int main() {
  char v[256];
  inputString(v);
  contadorSequencia(v);
}