#include <stdio.h>

int armazenado(int v[], int n, int x, int comparacoes) {
  if (n == 0) {
    comparacoes++;
    printf("O número de comparações feitas foi %d.\n", comparacoes);
    return 0;
  } else if (v[n - 1] == x) {
    comparacoes++;
    printf("O número de comparações feitas foi %d.\n", comparacoes);
    return 1;
  } else {
    return armazenado(v, n - 1, x, comparacoes + 1);
  }
}

int main() {
  int n, x;
  printf("Digite o tamanho do array: ");
  scanf("%d", &n);
  while (n <= 0) {
    printf("Erro: Digite um valor positivo para o tamanho do vetor: ");
    scanf("%d", &n);
  }
  int A[n];
  for (int i = 0; i < n; i++) {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%d", &A[i]);
  }
  printf("Digite o valor que você deseja checar se está ou não armazenado no "
         "vetor: ");
  scanf("%d", &x);
  if (armazenado(A, n, x, 0) == 1) {
    printf("O elemento %d foi encontrado dentro do vetor.\n", x);
  } else {
    printf("O elemento %d não foi encontrado dentro do vetor.\n", x);
  }
}
