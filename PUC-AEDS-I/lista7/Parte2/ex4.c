#include <stdio.h>

int palindromo(char v[], int n, int atual) {
  if (atual == n - 1 || atual - (n - 1) == 1) {
    return 1;
  } else if (v[atual] != v[n - 1]) {
    return 0;
  } else {
    return palindromo(v, n - 1, atual + 1);
  }
}

int main() {
  int n;
  printf("Digite o tamanho da palavra que você irá digitar: ");
  scanf("%d", &n);
  char palavra[n];
  printf("Digite a palavra: ");
  scanf("%s", palavra);
  if (palindromo(palavra, n, 0) == 1) {
    printf("A palavra é um palíndromo.\n");
  } else {
    printf("A palavra NÃO é um palíndromo.\n");
  }
}
