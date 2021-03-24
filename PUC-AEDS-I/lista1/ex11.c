#include <stdio.h>

int main() {
    float quilos;
    float gato1; //em gramas
    float gato2; //em gramas
    printf("Digite o peso do saco, em quilos, de ração: \n");
    scanf("%f", &quilos);
    printf("Digite a quantidade de ração, em gramas, que cada gato receberá: \n");
    scanf("%f %f", &gato1, &gato2);
    float restante;
    //após 5 dias, o gasto total será (gato1 + gato2)*5
    //o restante será (quilos * 1000) - (gato1 + gato2)*5 gramas
    restante = quilos * 1000 - (gato1 + gato2) * 5;
    printf("Após 5 dias, restarão no saco %f gramas de ração.", restante);
}