#include <stdio.h>
#include <math.h>

int main() {
  int a, b, periodo, soma = 0;
  while (a != 0 || b != 0) {
    printf("Digite os valores de A e B: ");
    scanf("%d %d", &a, &b);
    if (a != 0 && b != 0) {
      if (a > b) {
        int temp = a;
        a = b;
        b = temp;
      }
      periodo = b - a - 1;
      for (int i = 1; i <= periodo; i++) {
        int num = pow(b - i, 3);
        if (num % 2 == 0) {
          soma += num;
        }
      } 
    }
  }
  printf("\nSoma do cubo dos valores pares: %d\n", soma);
}
