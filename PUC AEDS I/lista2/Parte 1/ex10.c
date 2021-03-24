#include <stdio.h>

int main()
{
    int custo;
    printf("Digite o custo de fábrica: ");
    scanf("%d", &custo);
    if (custo <= 12000)
    {
        printf("O preço ao consumidor será de R$%lf\n", custo * 1.05);
        return 0;
    }
    else if (custo > 12000 && custo <= 25000)
    {
        printf("O preço ao consumidor será de R$%lf\n", custo * 1.25);
        return 0;
    }
    else
    {
        printf("O preço ao consumidor será de R$%lf\n", custo * 1.35);
        return 0;
    }
}