#include <stdio.h>
#include <string.h>

int main() {
  char var[256];
  char sobrenome[] = "Simpson";
  char nome[] = "Homer";
  int idade = 30;
  sprintf(var, "%s %s tem %d anos", sobrenome, nome, idade);
  printf("Resultado: %s\n", var);

  return 0;
}