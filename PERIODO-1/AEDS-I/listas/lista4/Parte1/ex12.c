#include <stdio.h>

int main(){
    int i, num, contador = 0;
    for(i = 1; i <= 10; i++) {
        printf("Digite o %dº valor: ", i);
        scanf("%d", &num);
        if (num < 0) {
            contador++;
        }
    }
    printf("Quantidade de valores negativos = %d\n", contador);
}
