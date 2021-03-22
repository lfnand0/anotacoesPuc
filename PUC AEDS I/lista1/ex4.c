#include <stdio.h>

int main() {
    int a;
    int b;
    int c;
    int d;
    printf("Digite 4 números: \n");
    scanf("%d %d %d %d", &a, &b, &c, &d);

    int soma;
    soma = a + b + c + d;
    printf("A soma é %d", soma);
}