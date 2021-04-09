#include <stdio.h>

int main(){
    int contador, contadorFora, n, i;
    contador = contadorFora = 0;
    for (i = 1; i <= 10; i++) {
        printf("Digite o %dº valor: ", i);
        scanf("%d", &n);
        if (n >= 10 && n <= 20) {
            contador++;
        } else {
            contadorFora++;
        }
    }
    printf("Quantidade de valores dentro do período [10, 20] = %d\n", contador);
    printf("Quantidade de valores fora desse período = %d\n", contadorFora);
}
