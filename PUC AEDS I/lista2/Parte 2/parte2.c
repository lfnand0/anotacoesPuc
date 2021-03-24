#include <stdio.h>

int main()
{
    int codigo, notaExercicios, aval1, aval2, aval3, totalNotas;
    float totalAulas, totalFaltas, frequencia;
    printf("Digite o código da disciplina: ");
    scanf("%d", &codigo);
    printf("Digite o total de aulas no semestre: ");
    scanf("%f", &totalAulas);
    printf("Digite o total de faltas no semestre: ");
    scanf("%f", &totalFaltas);
    if (totalFaltas > totalAulas)
    {
        printf("Erro: o número de faltas não pode ser maior que o de aulas.");
        return 0;
    }
    printf("Digite a nota total de exercícios e trabalhos: ");
    scanf("%d", &notaExercicios);
    if (notaExercicios < 0 || notaExercicios > 25)
    {
        printf("Erro: a nota de exercícios e trabalhos deve ser de 0 a 25. Digite-a novamente: ");
        scanf("%d", &notaExercicios);
        if (notaExercicios < 0 || notaExercicios > 25)
        {
            return 0;
        }
    }
    printf("Digite a nota da avaliação 1: ");
    scanf("%d", &aval1);
    if (aval1 < 0 || aval1 > 25)
    {
        printf("Erro: a nota da avaliação 1 deve ser de 0 a 25. Digite-a novamente: ");
        scanf("%d", &aval1);
        if (aval1 < 0 || aval1 > 25)
        {
            return 0;
        }
    }
    printf("Digite a nota da avaliação 2: ");
    scanf("%d", &aval2);
    if (aval2 < 0 || aval2 > 25)
    {
        printf("Erro: a nota da avaliação 2 deve ser de 0 a 25. Digite-a novamente: ");
        scanf("%d", &aval2);
        if (aval2 < 0 || aval2 > 25)
        {
            return 0;
        }
    }
    printf("Digite a nota da avaliação 3: ");
    scanf("%d", &aval3);
    if (aval3 < 0 || aval3 > 25)
    {
        printf("Erro: a nota da avaliação 1 deve ser de 0 a 25. Digite-a novamente: ");
        scanf("%d", &aval3);
        if (aval3 < 0 || aval3 > 25)
        {
            return 0;
        }
    }
    frequencia = (totalAulas - totalFaltas) / totalAulas;
    if (frequencia < 0.75)
    {
        printf("O aluno foi REPROVADO na disciplina de código %d\n", codigo);
        return 0;
    }
    else
    {
        totalNotas = notaExercicios + aval1 + aval2 + aval3;
        int menor = aval1; //reavaliacao não substitui nota de exercicios
        if (menor > aval2)
        {
            menor = aval2;
        }
        if (menor > aval3)
        {
            menor = aval3;
        }
        if (totalNotas < 60)
        {
            int reavaliacao;
            printf("Digite a nota da reavaliação: ");
            scanf("%d", &reavaliacao);
            totalNotas = totalNotas - menor + reavaliacao;
            if (totalNotas < 60)
            {
                printf("O aluno foi REPROVADO na disciplina de código %d\n", codigo);
                return 0;
            }
        }
        printf("O aluno foi APROVADO na disciplina de código %d\n", codigo);
        return 0;
    }
}