#include <stdio.h>

int main()
{
    int preco;
    int categoria;
    char situacao;
    double percentual;
    double imposto;

    printf("Digite o preço: ");
    scanf("%d", &preco);
    if (preco <= 0)
    {
        printf("Erro: digite um número maior que 0\n");
        return 0;
    }
    printf("Digite a categoria e a situação: ");
    scanf("%d %c", &categoria, &situacao);

    if (categoria <= 0 || categoria > 3)
    {
        printf("Erro: escolha uma categoria de 1 a 3\n");
        return 0;
    }

    if (situacao != 82 && situacao != 78) //R e N em ASCII são 82 e 78
    {
        printf("Erro: escolha uma situacao R ou N\n");
        return 0;
    }
    if (preco <= 25)
    {
        if (categoria == 1)
        {
            printf("\nPercentual de aumento: 5%%\n");
            percentual = 0.05;
        }
        else if (categoria == 2)
        {
            printf("\nPercentual de aumento: 8%%\n");
            percentual = 0.08;
        }
        else
        {
            printf("\nPercentual de aumento: 10%%\n");
            percentual = 0.10;
        }
    }
    else
    {
        if (categoria == 1)
        {
            printf("\nPercentual de aumento: 12%%\n");
            percentual = 0.12;
        }
        else if (categoria == 2)
        {
            printf("\nPercentual de aumento: 15%%\n");
            percentual = 0.15;
        }
        else
        {
            printf("\nPercentual de aumento: 18%%\n");
            percentual = 0.18;
        }
    }
    if (categoria == 2 || situacao == 82)
    {
        printf("Imposto: 5%%\n");
        imposto = 0.05;
    }
    else
    {
        printf("Imposto: 8%%\n");
        imposto = 0.08;
    }
    double novoPreco = preco + preco * percentual - preco * imposto;
    printf("Novo preço: R$%lf", novoPreco);
    if (novoPreco <= 50)
    {
        printf(" (CLASSIFICAÇÃO: Barato)\n");
        return 0;
    }
    else if (novoPreco > 50 && novoPreco < 120)
    {
        printf(" (CLASSIFICAÇÃO: Normal)\n");
        return 0;
    }
    else
    {
        printf(" (CLASSIFICAÇÃO: Caro)\n");
        return 0;
    }
}