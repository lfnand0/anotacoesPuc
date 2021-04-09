#include <stdio.h>

int main(){
    int i, quantTurmas = 0;
    char turma;
    for (i = 1; i <= 14; i++) {
        int alunos, presentes, ausentes;
        float porcentagemAusentes;
        presentes = ausentes = 0;
        printf("\n+++++++++++++++++++ %dº TURMA +++++++++++++++++++\n", i);
        printf("Digite a letra da turma: ");
        scanf(" %c", &turma);
        printf("Digite a quantidade de alunos na turma %c: ", turma);
        scanf("%d", &alunos);
        int i;
        for (i = 1; i <= alunos; i++) {
            int matricula;
            char presenca;
            printf("----------ALUNO %d DA TURMA %c----------\n", i, turma);
            printf("Digite o número de matrícula do aluno: ");
            scanf("%d", &matricula);
            printf("Digite 'A' se o aluno estiver ausente e 'P' se ele estiver presente: ");
            scanf(" %c", &presenca);
            while (presenca != 65 && presenca != 80) {
                // A = 65, P = 80 em ascii
                printf("Erro: valor inválido para presença. Favor redigitá-lo: ");
                scanf(" %c", &presenca);
            }
            if (presenca == 65) {
                ausentes++;
            } else if (presenca == 80) {
                presentes++;
            }
            printf("--------------------------------------\n\n");
        }
        if (alunos != 0) {    
            porcentagemAusentes = (float) ausentes / (float) alunos;
            if (porcentagemAusentes > 0.05) {
                quantTurmas++;
            }
            printf("PORCENTAGEM DE AUSÊNCIA DA TURMA %c: %.2f%%\n", turma, porcentagemAusentes*100);
        } 
        printf("++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }
    printf("\n==========Finalização==========\n");
    printf("Quantidade de turmas com porcentagem de ausência maior que 5%%: %d", quantTurmas);
    printf("\n===============================\n");
}
