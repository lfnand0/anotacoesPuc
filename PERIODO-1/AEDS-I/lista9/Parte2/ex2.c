#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void inverterString(char v[]) {
  int length = strlen(v);
  for (int i = 0; i < length / 2; i++) {
    char temp = v[i];
    v[i] = v[length - i - 1];
    v[length - i - 1] = temp;
  }
}

void imprimirString(char v[]) {
  for (int i = 0; i < strlen(v); i++) {
    printf("%c", v[i]);
  }
  printf("\n");
}

int main() {
  char v[256];
  inputString(v);
  inverterString(v);
  imprimirString(v);
}