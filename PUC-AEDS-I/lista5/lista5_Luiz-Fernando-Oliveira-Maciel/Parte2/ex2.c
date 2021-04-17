#include <stdio.h>

void converter(int horas, int minutos, int segundos) {
    int tempoFinal;
    tempoFinal = (horas * 3600) + (minutos * 60) + segundos;
    printf("%dh, %dmin e %ds correspondem a %d segundos.\n", horas, minutos, segundos, tempoFinal);
}

int main() {
    int horas, minutos, segundos;
    printf("Digite o valor em horas: ");
    scanf("%d", &horas);
    printf("Digite o valor em minutos: ");
    scanf("%d", &minutos);
    printf("Digite o valor em segundos: ");
    scanf("%d", &segundos);
    converter(horas, minutos, segundos); 
}