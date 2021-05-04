#include <stdio.h>

int main() {
  float v[15];
  for (int i = 0; i < 15; i++) {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%f", &v[i]);
  }

  float maior = v[0]; // valor temporário;
  for (int i = 1; i < 15; i++) {
    if (v[i] > maior) {
      maior = v[i];
    }
  }

  for (int i = 0; i < 15; i++) {
    v[i] /= maior;
    printf("%.3f, ", v[i]);
    // imprimindo dentro do próprio loop pra economizar linhas
  }
}
