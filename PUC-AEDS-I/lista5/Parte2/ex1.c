#include <stdio.h>

void soma(int n) {
    int soma = 0, i = 1;
    while (i <= n) {
        soma += i;
        i++;
    }
    printf("A soma dos números entre 1 e %d é %d.\n", n, soma);
}

int main() {
    int n;
    printf("Digite o valor de n: ");
    scanf("%d", &n);
    soma(n);
}