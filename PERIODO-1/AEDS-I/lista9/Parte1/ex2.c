#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void imprimirString(char v[]) {
  printf("%s\n", v);
}

void substituirChar(char v[]) {
  int length = strlen(v);
  for (int i = 0; i < length - 2; i++) {
    if (v[i] == ' ') {
      v[i] = '\n';
    }
  }
}

int main() {
  char v[256];
  inputString(v);
  substituirChar(v);
  printf("Output: \n");
  imprimirString(v);  
}