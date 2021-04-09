#include <stdio.h>

int main(){
    int contAlcool, contGasolina, contDiesel, i = 1, n = 0;
    contAlcool = contGasolina = contDiesel = 0;
    printf("---------LISTA DE CÓDIGOS----------\n");
    printf("Digite os seguintes valores para escolher o tipo de combustível utilizado: \n");
    printf("1. Álcool\n2. Gasolina\n3. Diesel\n4. Fim\n");
    while (i != 0) {
        n++;
        int codigo;
        printf("Insira o código utilizado pelo %dº cliente: ", n);
        scanf("%d", &codigo);
        while (codigo < 1 || codigo > 4) {
            printf("\nErro: código inválido. Digite um dos seguintes valores: \n");
            printf("1. Álcool\n2. Gasolina\n3. Diesel\n4. Fim\n");
            scanf("%d", &codigo);
        }
        if (codigo == 1) {
            contAlcool++;
        } else if (codigo == 2) {
            contGasolina++;
        } else if (codigo == 3) {
            contDiesel++;
        } else {
            i = 0;
        }
    }
    printf("\nMUITO OBRIGADO\n------------------------------------\n");
    printf("Quantidade de clientes que abasteceram com álcool: %d\n", contAlcool);
    printf("Quantidade de clientes que abasteceram com gasolina: %d\n", contGasolina);
    printf("Quantidade de clientes que abasteceram com diesel: %d\n", contDiesel);
}
