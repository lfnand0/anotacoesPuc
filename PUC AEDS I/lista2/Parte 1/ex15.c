#include <stdio.h>

int main()
{
    int salario;
    int tipo;
    printf("Digite o salário: ");
    scanf("%d", &salario);
    printf(" \nAgora escolha uma das seguintes operações digitando o número que a foi atribuída:\n1. Poupança (rendimento mensal de 3%%)\n2. Fundos de renda fixa (rendimento mensal de 4%%\n");
    scanf("%d", &tipo);
    if (tipo == 1)
    {
        printf("O montante após um mês será de R$%lf\n", salario * 1.03);
        return 0;
    }
    else if (tipo == 2)
    {
        printf("O montante após um mês será de R$%lf\n", salario * 1.04);
        return 0;
    }
    else
    {
        printf("Erro: valor inválido (escolha 1 ou 2)\n");
        return 0;
    }
    return 1;
}