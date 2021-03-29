#include <stdio.h>

// Tive dúvida se a questão pedia para ordenar TODOS os valores dados, ou orderná-los apenas dentro de seus respectivos grupos. Então resolvi dos dois jeitos.
// Essa é a resolução caso a questão tenha pedido para ordenar todos

// OBS: Utilizei arrays pra facilitar a resolução

int main() {
    int grupo[20];

    printf("Digite 4 valores para o grupo 1: ");
    scanf("%d %d %d %d", &grupo[0], &grupo[1], &grupo[2], &grupo[3]);
    printf("Digite 4 valores para o grupo 2: ");
    scanf("%d %d %d %d", &grupo[4], &grupo[5], &grupo[6], &grupo[7]);
    printf("Digite 4 valores para o grupo 3: ");
    scanf("%d %d %d %d", &grupo[8], &grupo[9], &grupo[10], &grupo[11]);
    printf("Digite 4 valores para o grupo 4: ");
    scanf("%d %d %d %d", &grupo[12], &grupo[13], &grupo[14], &grupo[15]);
    printf("Digite 4 valores para o grupo 5: ");
    scanf("%d %d %d %d", &grupo[16], &grupo[17], &grupo[18], &grupo[19]);
    
    int i = 0, j, temporario;
    printf("ORDEM ORIGINAL: \n");
    while (i < 20) {
        printf("%d ", grupo[i]);
        i++;
    }
    
    i = 0;
    while (i < 20) {
        j = 0;
        while (j < 19 - i) {
            if (grupo[j] > grupo[j+1]) {    // ORDENAÇÃO POR ORDEM CRESCENTE
                temporario = grupo[j];      // Caso o antecessor seja maior que o sucessor, 
                grupo[j] = grupo[j+1];      // trocar ele pelo seu sucessor
                grupo[j+1] = temporario;
            }
            j++;
        }
        i++;
    }
    i = 0;
    printf("\nLISTA EM ORDEM CRESCENTE: \n");
    while (i < 20) {
        printf("%d ", grupo[i]);
        i++;
    }
    i = 0;
    printf("\nLISTA EM ORDEM DECRESCENTE: \n");
    while (i < 10) {
        temporario = grupo[i];
        grupo[i] = grupo[19 - i];
        grupo[19 - i] = temporario;
        i++;
    }
    i = 0;
    while (i < 20) {
        printf("%d ", grupo[i]);
        i++;
    }
    printf("\n");
    return 0;
}