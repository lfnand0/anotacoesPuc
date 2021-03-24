#include <stdio.h>

int main()
{
    int nota1;
    int nota2;
    int nota3;
    int nota4;
    printf("Digite as quatro notas: ");
    scanf("%d %d %d %d", &nota1, &nota2, &nota3, &nota4);
    printf("Média: %lf\n", (nota1 + nota2 + nota3 + nota4) / 4.0);
    if (nota1 >= 7)
    {
        printf("O aluno de nota %d foi aprovado\n", nota1);
    }
    else
    {
        printf("O aluno de nota %d foi reprovado\n", nota1);
    }
    if (nota2 >= 7)
    {
        printf("O aluno de nota %d foi aprovado\n", nota2);
    }
    else
    {
        printf("O aluno de nota %d foi reprovado\n", nota2);
    }
    if (nota3 >= 7)
    {
        printf("O aluno de nota %d foi aprovado\n", nota3);
    }
    else
    {
        printf("O aluno de nota %d foi reprovado\n", nota3);
    }
    if (nota4 >= 7)
    {
        printf("O aluno de nota %d foi aprovado\n", nota4);
        return 0;
    }
    else
    {
        printf("O aluno de nota %d foi reprovado\n", nota4);
        return 0;
    }
}