#include <stdio.h>

void sinal(int n) {
    if (n < 0) {
        printf("n é negativo.\n");
    } else if (n == 0) {
        printf("n é igual a 0.\n");
    } else if (n > 0) {
        printf("n é positivo.\n");
    }
}

int main() {
    int n;
    printf("Digite o valor de n: ");
    scanf("%d", &n);
    sinal(n);
}