#include <stdio.h>

int main() {
    int salario;
    double reajuste;

    printf("Digite o salário base: \n");
    scanf("%d", &salario);

    reajuste = salario * 0.98;
    printf("O salário que será recebido é de R$%f", reajuste);
}