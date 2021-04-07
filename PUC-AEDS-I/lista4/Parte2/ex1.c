#include <stdio.h>
#include <math.h>

int main() {
  int inicial, num, binario;
  double i;
  binario = i = 0;
  printf("Digite um valor que você queira converter para binário: ");
  scanf("%d", &num);
  inicial = num;
  if (num == 1) {
    binario = 1;
  } else {
  while (num != 1) {
      binario += (num % 2) * pow(10, i);
      i++;
      num /= 2;
    }
  }
  if (inicial != 1) {
    binario += pow(10, i);
  }
  printf("%d em binário é %d.\n", inicial, binario);
}