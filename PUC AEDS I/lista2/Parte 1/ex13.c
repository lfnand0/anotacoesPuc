#include <stdio.h>

int main()
{
    double preco;
    double novopreco;
    printf("Digite o preço do produto: ");
    scanf("%lf", &preco);
    if (preco <= 50)
    {
        novopreco = preco * 1.05;
    }
    else if (preco > 50 && preco <= 100)
    {
        novopreco = preco * 1.10;
    }
    else
    {
        novopreco = preco * 1.15;
    }
    if (novopreco <= 80)
    {
        printf("Novo preço = R$%lf (CLASSIFICAÇÃO: Barato)\n", novopreco);
        return 0;
    }
    else if (novopreco > 80 && novopreco <= 120)
    {
        printf("Novo preço = R$%lf (CLASSIFICAÇÃO: Normal)\n", novopreco);
        return 0;
    }
    else if (novopreco > 120 && novopreco <= 200)
    {
        printf("Novo preço = R$%lf (CLASSIFICAÇÃO: Caro)\n", novopreco);
        return 0;
    }
    else
    {
        printf("Novo preço = R$%lf (CLASSIFICAÇÃO: Muito Caro)\n", novopreco);
        return 0;
    }
}