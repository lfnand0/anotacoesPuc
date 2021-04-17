#include <stdio.h>

float peso_ideal(float alt, int sexo) {
    float peso_ideal;
    while (sexo != 1 && sexo != 2) {
        printf("Erro: digite 1 ou 2 para o sexo: ");
        scanf("%d", &sexo);
    }
    while (alt <= 0) {
       printf("Erro: a altura não pode ser negativa. Redigite-a: ");
        scanf("%f", &alt); 
    }
    if (sexo == 1) {
        peso_ideal = 62.1 * alt - 44.7;
    } else {
        peso_ideal = 72.7 * alt - 58;
    }
    return peso_ideal;
}

int main() {
    float alt;
    int sexo;
    printf("Digite o sexo da pessoa (1 - Feminino; 2 - Masculino): ");
    scanf("%d", &sexo);
    printf("Digite a altura da pessoa : ");
    scanf("%f", &alt);
    printf("O peso ideal é: %f\n", peso_ideal(alt, sexo));
}