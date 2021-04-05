#include <stdio.h>

int main() {
  int n, i;
  printf("Digite a quantidade de vezes que você quer que o código rode: ");
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    int num, fatorial = 1, temp;
    printf("Digite um número: ");
    scanf("%d", &num);
    temp = num;
    if (num < 0) {
      printf("Erro: o valor não pode ser negativo\n");
    } else if (num == 0) {
      printf("O fatorial de %d é %d\n", temp, fatorial);
    } else {
      while (num > 0) {
        fatorial = fatorial * num;
        num -= 1;
      }
      printf("O fatorial de %d é %d\n", temp, fatorial);
    }
  }
}




