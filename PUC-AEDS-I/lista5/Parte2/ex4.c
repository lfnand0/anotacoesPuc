#include <stdio.h>
#include <math.h>

void volume(double raio) {
    float volume = (4.0/3.0) * pow(raio, 3);
    printf("O volume da esfera de raio %f é %f.\n", raio, volume);
}

int main() {
    double raio;
    printf("Digite o valor do raio: ");
    scanf("%lf", &raio);
    volume(raio);
}