#include <stdio.h>

int main() {
  int n, func1 = 0, func2;
  printf("Digite um valor para n: ");
  scanf("%d", &n);
  if (n < 1) {
    printf("Erro: valor inválido.\n");
    return 0;
  }

  int i;
  for (i = 1; i <= n; i++) {
    func1 += i*i;
  }
  func2 = (n*(n+1)*(2*n+1))/6;

  printf("Calculando com a fórmula 1²+2²+...+n² = %d\n", func1);
  printf("Calculando com a fórmula (n(n+1)(2n+1))/6 = %d\n", func2);
}