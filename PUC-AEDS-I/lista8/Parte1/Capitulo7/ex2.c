#include <stdio.h>

int main() {
  int m[2][4];
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 4; j++) {
      printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1,
             j + 1);
      scanf("%d", &m[i][j]);
    }
    printf("\n");
  }

  int quantidade;
  float mediaPares, quantPares;
  quantidade = mediaPares = quantPares = 0;
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 4; j++) {
      if (m[i][j] >= 12 && m[i][j] <= 20) {
        quantidade++;
      }
      if (m[i][j] % 2 == 0) {
        mediaPares += m[i][j];
        quantPares++;
      }
    }
  }
  mediaPares /= quantPares;
  printf("Existe(m) %d elemento(s) entre 12 e 20 na matriz.\n", quantidade);
  printf("A média dos elementos pares da matriz é %f.", mediaPares);
}
