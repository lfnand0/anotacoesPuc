#include <stdio.h>

int main() {
  int m[4][6];
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 6; j++) {
      printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
      scanf("%d", &m[i][j]);
    }
    printf("\n");
  }

  int n[6][4];
  for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 4; j++) {
      printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
      scanf("%d", &n[i][j]);
    }
    printf("\n");
  }

  int vResultante[4];
  for (int i = 0; i < 4; i++) {
    int soma = 0;
    for (int j; j < 6; j++) {
      soma += m[i][j] + n[j][i];
    }
    vResultante[i] = soma;
    printf("%d, ", vResultante[i]);
  }
}
