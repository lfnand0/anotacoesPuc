#include <stdio.h>

int main() {
    int salario;
    double reajuste;

    printf("Digite o salário a ser reajustado: \n");
    scanf("%d", &salario);

    reajuste = salario * 1.1;
    printf("O valor após o reajuste é de R$%f", reajuste);
}