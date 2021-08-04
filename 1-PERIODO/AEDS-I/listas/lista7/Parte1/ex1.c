#include <stdio.h>

int potencia(int x, int y) {
  if (y == 0) {
    return 1;
  } else {
    return x * potencia(x, y - 1);
  }
}

int main() {
  int a, b;
  printf("Digite o valor da base e da potência: ");
  scanf("%d %d", &a, &b);
  while (b < 0) {
    printf("Erro: a potência precisa ser positiva. Redigite-a: ");
    scanf("%d", &b);
  }
  printf("%d\n", potencia(a, b));
}
