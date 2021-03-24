#include <stdio.h>
#include <math.h>

int main()
{
    double num1;
    double num2;
    char letra;
    printf("Digite dois números: ");
    scanf("%lf %lf", &num1, &num2);

    printf(" \nAgora escolha uma das seguintes operações digitando a letra que a foi atribuída:\na) O primeiro número elevado ao segundo número\nb) Raiz quadrada de cada um dos números\nc) Raiz cúbica de cada um dos números\n");
    scanf("%s", &letra);

    if (letra == 97)
    { // a = 97 em ASCII
        if (num1 == 0 && num2 == 0)
        {
            printf("Valor indeterminado.\n");
            return 0;
        }
        else
        {
            double power = pow(num1, num2);
            printf("%d elevado a %d é %d\n", (int)num1, (int)num2, (int)power);
            return 0;
        }
    }
    else if (letra == 98)
    {
        if (num1 < 0 || num2 < 0)
        {
            printf("Erro: escolha números válidos (maiores ou iguais a 0)\n");
            return 0;
        }
        else
        {
            double sqrt1 = sqrt(num1);
            double sqrt2 = sqrt(num2);
            printf("A raíz quadrada de %d e %d são, respectivamente, %lf e %lf.\n", (int)num1, (int)num2, sqrt1, sqrt2);
            return 0;
        }
    }
    else if (letra == 99)
    {
        double cbrt1 = cbrt(num1);
        double cbrt2 = cbrt(num2);
        printf("A raíz cúbica de %d e %d são, respectivamente, %lf e %lf.\n", (int)num1, (int)num2, cbrt1, cbrt2);
        return 0;
    }
    else
    {
        printf("Erro: escolha uma opção válida (a, b ou c)\n");
        return 0;
    }
}