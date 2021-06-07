#include <stdio.h>

int main(){
    int codigo = 1, contLucroA, contLucroB, contLucroC;
    float compra, venda;
    contLucroA = contLucroB = contLucroC = 0;
    printf("Para finalizar o programa, digite 0 no valor de código.\n");
    while (codigo != 0) {
        printf("\nDigite o código do produto: ");
        scanf("%d", &codigo);
        if (codigo != 0) {
            printf("Digite o valor de compra: ");
            scanf("%f", &compra);
            printf("Digite o valor de venda: ");
            scanf("%f", &venda);
            if (venda < 1.1 * compra) {
                contLucroA++;
            } else if (venda >= 1.1 * compra && venda <= 1.2 * compra) {
                contLucroB++;
            } else if (venda > 1.2 * compra) {
                contLucroC++;
            }
        }
    }
    printf("Nº de produtos com margem de lucro < 10%%: %d\n", contLucroA);
    printf("Nº de produtos com margem de lucro >= 10%% e <= 20%%: %d\n", contLucroB);
    printf("Nº de produtos com margem de lucro > 20%%: %d\n", contLucroC);
}
