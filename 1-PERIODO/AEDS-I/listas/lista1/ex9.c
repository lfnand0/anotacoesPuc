#include <stdio.h>
#include <math.h>

int main() {
    double raio;
    printf("Digite o raio: \n");
    scanf("%lf", &raio);

    double area;
    area = M_PI * (pow(raio, 2.0));
    printf("A área é %lf", area);
}