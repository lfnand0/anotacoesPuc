#include <stdio.h>

int main() {
    int deposito;
    double juros;
    printf("Digite o valor depositado e a taxa de juros: \n");
    scanf("%d %lf", &deposito, &juros);

    double total;
    total = deposito * ((100 + juros)/100.0);
    printf("O valor final será de R$%lf", total);
}