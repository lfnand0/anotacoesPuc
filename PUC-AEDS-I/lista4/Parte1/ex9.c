#include <stdio.h>

int main(){
    int n;
    printf("Digite um valor para n: ");
    scanf("%d", &n);
    while (n <= 0) {
        printf("Erro: digite um valor positivo: ");
        scanf("%d", &n);
    }
    int i = 1;
    while (i <= n) {
        printf("%d\n", i);
        i++;
    }
}
