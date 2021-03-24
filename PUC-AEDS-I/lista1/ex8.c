#include <stdio.h>

int main() {
    int base;
    int altura;

    printf("Digite a base e altura do triângulo: \n");
    scanf("%d %d", &base, &altura);

    double area;
    area = (base * altura)/2.0;
    printf("A área é %lf", area);
}