#include <stdio.h>

int main() {
    int nota1;
    int nota2;
    int nota3;
    int peso1;
    int peso2;
    int peso3;
    printf("Digite a primeira nota e seu respectivo peso: \n");
    scanf("%d %d", &nota1, &peso1);
    printf("\nDigite a segunda nota e seu respectivo peso: \n");
    scanf("%d %d", &nota2, &peso2);
    printf("\nDigite a terceira nota e seu respectivo peso: \n");
    scanf("%d %d", &nota3, &peso3);

    int notasXPesos;
    int somaPesos;
    double media;
    notasXPesos = nota1 * peso1 + nota2 * peso2 + nota3 * peso3;
    somaPesos = peso1 + peso2 + peso3;
    media = (float) notasXPesos/(float) somaPesos;
    printf("A média é %f", media);
}