#include <stdio.h>

int main()
{
    int salario;
    printf("Digite o salário para checar se recebeu um aumento: ");
    scanf("%d", &salario);
    if (salario < 500)
    {
        printf("Seu salário foi reajustado para R$%lf\n", salario * 1.3);
    }
    else
    {
        printf("Como seu salário é maior que R$500, ele nao será reajustado.\n");
    }
}