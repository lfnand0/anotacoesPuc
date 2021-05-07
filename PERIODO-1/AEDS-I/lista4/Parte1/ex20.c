#include <stdio.h>

int main(){
    char calculo = 'S';
    while (calculo == 83) { // S = 83 e N = 78
        float num1, num2;
        printf("Digite o primeiro valor: ");
        scanf("%f", &num1);
        printf("Digite o segundo valor: ");
        scanf("%f", &num2);
        while (num2 == 0) {
            printf("Erro: O segundo valor não pode ser igual a 0. Redigite-o: ");
            scanf("%f", &num2);
        }
        printf("%.1f / %.1f = %.3f\n", num1, num2, num1/num2);
        printf("\nVOCE DESEJA OUTRO CÁLCULO (S/N)? ");
        scanf(" %c", &calculo);
        while (calculo != 83 && calculo != 78) {
            printf("Erro: valor inválido. Digite 'S' ou 'N' como resposta: ");
            scanf(" %c", &calculo);
        }
    }
}
