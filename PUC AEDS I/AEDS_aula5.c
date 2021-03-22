#include <stdio.h>

int main() {
    printf("Hello World\n");

    // input de dados

    int a;
    int b;

    printf("Digite dois números inteiros\n");
    scanf("%d %d", &a, &b); //%d: o comando irá esperar um valor numérico; &a: a variável a receberá esse valor
    
    // processamento de dados

    double media;
    media = (a + b)/2.0;

    // output de dados

    // A média de 9 e 2 é 5.50
    printf("A média de %d e %d é %f\n", a, b, media); // %f = float

    return 0;
}