#include <stdio.h>

int main()
{
    int extra;
    int falta;
    double H;
    int premio;

    printf("Digite o número de horas extra: ");
    scanf("%d", &extra);
    if (extra < 0)
    {
        printf("Erro: o valor de horas extra não pode ser negativo\n");
        return 0;
    }

    printf("Digite o número de horas faltas: ");
    scanf("%d", &falta);
    if (falta < 0)
    {
        printf("Erro: o valor de horas faltas não pode ser negativo\n");
        return 0;
    }

    H = 60 * ((float) extra - (2 * (float) falta / 3));
    if (H >= 2400)
    {
        premio = 500;
    }
    else if (H >= 1800 && H < 2400)
    {
        premio = 400;
    }
    else if (H >= 1200 && H < 1800)
    {
        premio = 300;
    }
    else if (H >= 600 && H < 1200)
    {
        premio = 200;
    }
    else
    {
        premio = 100;
    }

    printf("Feliz Natal! Você recebeu R$%d,00 como premiação\n", premio);
    return 0;
}