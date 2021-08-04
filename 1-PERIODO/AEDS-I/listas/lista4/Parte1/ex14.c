#include <stdio.h>

int main(){
    int alunos, total = 0, i;
    float media;
    printf("Digite o número de alunos: ");
    scanf("%d", &alunos);
    while (alunos < 0) {
        printf("Digite um valor igual ou maior que 0: ");
        scanf("%d", &alunos);
    }

    for (i = 1; i <= alunos; i++) {
        int nota;
        printf("Digite a nota do %dº aluno: ", i);
        scanf("%d", &nota);
        total += nota;
    }
    if (alunos > 0) {
        media = (float) total / (float) alunos;
        printf("Média das notas = %.2f\n", media);
    }
}
