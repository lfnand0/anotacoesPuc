#include <stdio.h>

int divisores(int n) {
    while (n <= 0) {
        printf("Erro: O valor precisa ser positivo. Redigite-o: ");
        scanf("%d", &n);
    }
    int i = 1, soma = 0;
    while (i <= n) {
        if (n % i == 0) {
            soma += i;
        }
       
        i++;
    }
    return soma;
}

int main() {
    int n;
    printf("Digite um valor: ");
    scanf("%d", &n);
    printf("A soma dos divisores de %d é %d.\n", n, divisores(n));
}