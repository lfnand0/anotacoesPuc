#include <stdio.h>

int main(){
  int i, n;
  printf("Digite o valor de n: ");
  scanf("%d", &n);
  while (n <= 0) {
    printf("Erro: O valor de n precisa ser positivo. Redigite-o: ");
    scanf("%d", &n);
  }
  for (i = 0; i < n; i++) {
    printf("PROGRAMACAO\n");
  }
}