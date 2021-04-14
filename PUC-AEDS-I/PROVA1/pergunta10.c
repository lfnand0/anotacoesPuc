#include <stdio.h>

int main() {
    float massa, massaInicial;
    int tempo, tempoHoras, tempoMinutos;
    tempo = tempoHoras = tempoMinutos = 0;
    printf("Digite a massa: ");
    scanf("%f", &massa);
    while (massa <= 0) {
        printf("Erro: valor inválido. Digite a massa novamente: ");
        scanf("%f", &massa);
    }
    massaInicial = massa;
    while (massa >= 0.5) {
        massa /= 2;
        tempo += 50;
    }
    
    // CÁLCULO DE TEMPO
    while (tempo >= 60) {
        tempoMinutos++;
        tempo -= 60;
    }
    while (tempoMinutos >= 60) {
        tempoHoras++;
        tempoMinutos -= 60;
    }
    
    // FIM
    printf("A massa inicial, de %f gramas, demorou %d horas, %d minutos e %d segundos para se tornar menor que 0.5 gramas.\n", massaInicial, tempoHoras, tempoMinutos, tempo);
}