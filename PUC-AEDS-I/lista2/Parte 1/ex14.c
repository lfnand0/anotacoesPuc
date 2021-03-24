#include <stdio.h>

int main()
{
    int salario;
    printf("Digite o salário: ");
    scanf("%d", &salario);
    if (salario <= 300)
    {
        printf("O novo salário será de R$%lf\n", salario * 1.50);
        return 0;
    }
    else if (salario > 300 && salario <= 500)
    {
        printf("O novo salário será de R$%lf\n", salario * 1.40);
        return 0;
    }
    else if (salario > 500 && salario <= 700)
    {
        printf("O novo salário será de R$%lf\n", salario * 1.30);
        return 0;
    }
    else if (salario > 700 && salario <= 800)
    {
        printf("O novo salário será de R$%lf\n", salario * 1.20);
        return 0;
    }
    else if (salario > 800 && salario <= 1000)
    {
        printf("O novo salário será de R$%lf\n", salario * 1.10);
        return 0;
    }
    else
    {
        printf("O novo salário será de R$%lf\n", salario * 1.05);
        return 0;
    }
    printf("Erro: valor inválido");
    return 1;
}