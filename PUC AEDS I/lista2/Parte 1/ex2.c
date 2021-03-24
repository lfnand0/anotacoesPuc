#include <stdio.h>

int main() {
    int nota1;
    int nota2;
    float media;
    printf("Digite as duas notas: ");
    scanf("%d %d", &nota1, &nota2);
    media = (nota1 + nota2)/2;
    printf("A média é: %f\n", media);
    if (media >= 0 && media < 3) {
        printf("Reprovado");
    } else if (media >= 3 && media < 7) {
        printf("Exame");
    } else if (media >= 7 && media <= 10) {
        printf("Aprovado");
    } else {
        printf("Valor Inválido");
    }
}