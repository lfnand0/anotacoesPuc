#include <stdio.h>

int main() {
    int num1;
    int num2;
    printf("Digite dois números: ");
    scanf("%d %d", &num1, &num2);
    printf(" \nAgora escolha uma das seguintes operações digitando o número que o foi atribuído:\n1. Média entre os números digitados\n2. Diferença do maior pelo menor\n3. Produto entre os números digitados\n4. Divisão do primeiro pelo segundo\n");
    int operacao;
    scanf("%d", &operacao);
    if (operacao == 1) {
        printf("A média de %d e %d é %lf\n", num1, num2, (float) (num1+num2)/2.0);
        return 0;
    } else if (operacao == 2) {
        if (num1 > num2) {
            printf("A diferença entre %d e %d é de %d\n", num1, num2, num1 - num2);
            return 0;
        } else {
            printf("A diferença entre %d e %d é de %d\n", num2, num1, num2 - num1);
            return 0;
        }
    } else if (operacao == 3) {
        printf("%d vezes %d é %d\n", num1, num2, num1*num2);
        return 0;
    } else if (operacao == 4) {
        printf("%d dividido por %d é %lf\n", num1, num2, (float) num1/(float) num2);
        return 0;
    } else {
        printf("Digite um valor de 1 a 4.");
        return 0;
    }
}