#include <stdio.h>

int main () {
    int a;
    int b;
    int c;

    printf("Digite três números: \n");
    scanf("%d %d %d", &a, &b, &c);

    double soma = a + b + c;
    double media = soma/3.0;
    
    printf("A soma de %d, %d e %d é %f. A média entre eles é %f", a, b, c, soma, media);
    return 0;
}