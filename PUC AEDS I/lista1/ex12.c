#include <stdio.h>

int main() {
    float numero;
    printf("Digite um número real: \n");
    scanf("%f", &numero);
    printf("A parte inteira desse número é %d", (int)numero);
}