#include <stdio.h>

int main(){
    int maior, menor, num, n, i;
    maior = -2147483646; //-2^31 - 2 --> menor int possível
    menor = 2147483647; //2^31 - 1 --> maior int possível
    printf("Digite quantas vezes o programa irá se repetir: ");
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        printf("Digite um número: ");
        scanf("%d", &num);
        if (num > maior) {
            maior = num;
        }
        if (num < menor) {
            menor = num;
        }
    }
    printf("\nMAIOR = %d\nMENOR = %d\n", maior, menor);
}
