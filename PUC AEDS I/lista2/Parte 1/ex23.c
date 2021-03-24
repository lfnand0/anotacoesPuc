#include <stdio.h>

int main()
{
    int codigo;
    int quantidade;
    printf("Digite o código do produto: ");
    scanf("%d", &codigo);
    if (codigo <= 0 || codigo > 40)
    {
        printf("Erro: o código deve ser de 1 a 40.\n");
        return 0;
    }
    printf("Digite a quantidade comprada: ");
    scanf("%d", &quantidade);
    if (quantidade < 0)
    {
        printf("Erro: quantidade negativa\n");
        return 0;
    }
    int unitario;
    if (codigo >= 1 && codigo <= 10)
    {
        printf("\nPreço unitário: R$10,00\n");
        unitario = 10;
    }
    else if (codigo >= 11 && codigo <= 20)
    {
        printf("\nPreço unitário: R$15,00\n");
        unitario = 15;
    }
    else if (codigo >= 21 && codigo <= 30)
    {
        printf("\nPreço unitário: R$20,00\n");
        unitario = 20;
    }
    else if (codigo >= 31 && codigo <= 40)
    {
        printf("\nPreço unitário: R$30,00\n");
        unitario = 30;
    }
    else
    {
        printf("Código inválido.\n");
        return 0;
    }
    int total = unitario * quantidade;
    double desconto;
    printf("Preço total (sem desconto): R$%d\n", total);
    if (total <= 250)
    {
        printf("Desconto: 5%%\n");
        desconto = 1.05;
    }
    else if (total > 250 && total <= 500)
    {
        printf("Desconto: 10%%\n");
        desconto = 1.10;
    }
    else
    {
        printf("Desconto: 15%%\n");
        desconto = 1.15;
    }
    printf("Preço total após o desconto: R$%lf\n", total * desconto);
    return 0;
}