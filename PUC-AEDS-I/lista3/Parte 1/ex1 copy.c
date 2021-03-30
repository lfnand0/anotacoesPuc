#include <stdio.h>

// Tive dúvida se a questão pedia para ordenar TODOS os valores dados, ou orderná-los apenas dentro de seus respectivos grupos. Então resolvi dos dois jeitos.

// Essa é a resolução caso a questão tenha pedido para ordenar os valores apenas dentro de seus grupos.

// OBS: Utilizei arrays pra facilitar

int main() {
    int i = 0;
    while (i < 5) {
        int val[4];
        printf("Digite 4 valores para o %dº grupo: ", i + 1);
        scanf("%d %d %d %d", &val[0], &val[1], &val[2], &val[3]);

        printf("\n----------%dº GRUPO----------\n", i + 1);
        printf("ORDEM ORIGINAL: %d %d %d %d\n", val[0], val[1], val[2], val[3]);
        int j = 0, k, temporario;
        while (j < 3) { // ordenando por ordem crescente
            k = 0;
            while (k < 3 - j) {
                if (val[k] > val[k+1]) {
                    temporario = val[k];
                    val[k] = val[k+1];
                    val[k+1] = temporario;
                }
                k++;
            }
            j++;
        }
        printf("ORDEM CRESCENTE: %d %d %d %d\n", val[0], val[1], val[2], val[3]);

        int w = 0; // ordenando por ordem decrescente
        while (w < 2) {
            temporario = val[w];
            val[w] = val[3 - w];
            val[3 - w] = temporario;
            w++;
        }
        printf("ORDEM DECRESCENTE: %d %d %d %d\n", val[0], val[1], val[2], val[3]);
        printf("----------------------------\n\n");
        i++;
    }
}
/* 
PRIMEIRA RESOLUÇÃO (pouco optimizada):

int main() {
    int grupo1[4];
    int grupo2[4];
    int grupo3[4];
    int grupo4[4];
    int grupo5[4];
    
    printf("Digite 4 valores para o grupo 1: ");
    scanf("%d %d %d %d", &grupo1[0], &grupo1[1], &grupo1[2], &grupo1[3]);
    printf("Digite 4 valores para o grupo 2: ");
    scanf("%d %d %d %d", &grupo2[0], &grupo2[1], &grupo2[2], &grupo2[3]);
    printf("Digite 4 valores para o grupo 3: ");
    scanf("%d %d %d %d", &grupo3[0], &grupo3[1], &grupo3[2], &grupo3[3]);
    printf("Digite 4 valores para o grupo 4: ");
    scanf("%d %d %d %d", &grupo4[0], &grupo4[1], &grupo4[2], &grupo4[3]);
    printf("Digite 4 valores para o grupo 5: ");
    scanf("%d %d %d %d", &grupo5[0], &grupo5[1], &grupo5[2], &grupo5[3]);

    int k, i, j, temporario;
// -------------GRUPO 1-----------------------------
    k = 0;
    printf("GRUPO 1: \n");
    while (k < 4) {
        printf("%d ", grupo1[k]);
        k++;
    }
    
    i = 0;
    while (i < 4) {
        j = 0;
        while (j < 3 - i) {
            if (grupo1[j] > grupo1[j+1]) {
                temporario = grupo1[j];      
                grupo1[j] = grupo1[j+1];      
                grupo1[j+1] = temporario;
            }
            j++;
        }
        i++;
    }

    k = 0;
    printf("\nGRUPO 1 EM ORDEM CRESCENTE: \n");
    while (k < 4) {
        printf("%d ", grupo1[k]);
        k++;
    }

    k = 0;
    i = 0;
    printf("\nGRUPO 1 EM ORDEM DECRESCENTE: \n");
    while (i < 2) {
        temporario = grupo1[i];
        grupo1[i] = grupo1[3 - i];
        grupo1[3 - i] = temporario;
        i++;
    }
    while (k < 4) {
        printf("%d ", grupo1[k]);
        k++;
    }

// -------------GRUPO 2 -----------------------------
    k = 0;
    printf("\n\nGRUPO 2: \n");
    while (k < 4) {
        printf("%d ", grupo2[k]);
        k++;
    }
    
    i = 0;
    while (i < 4) {
        j = 0;
        while (j < 3 - i) {
            if (grupo2[j] > grupo2[j+1]) {
                temporario = grupo2[j];
                grupo2[j] = grupo2[j+1];
                grupo2[j+1] = temporario;
            }
            j++;
        }
        i++;
    }

    k = 0;
    printf("\nGRUPO 2 EM ORDEM CRESCENTE: \n");
    while (k < 4) {
        printf("%d ", grupo2[k]);
        k++;
    }

    k = 0;
    i = 0;
    printf("\nGRUPO 2 EM ORDEM DECRESCENTE: \n");
    while (i < 2) {
        temporario = grupo2[i];
        grupo2[i] = grupo2[3 - i];
        grupo2[3 - i] = temporario;
        i++;
    }
    while (k < 4) {
        printf("%d ", grupo2[k]);
        k++;
    }

// -------------GRUPO 3 -----------------------------
    k = 0;
    printf("\n\nGRUPO 3: \n");
    while (k < 4) {
        printf("%d ", grupo3[k]);
        k++;
    }
    
    i = 0;
    while (i < 4) {
        j = 0;
        while (j < 3 - i) {
            if (grupo3[j] > grupo3[j+1]) {
                temporario = grupo3[j];
                grupo3[j] = grupo3[j+1];
                grupo3[j+1] = temporario;
            }
            j++;
        }
        i++;
    }

    k = 0;
    printf("\nGRUPO 3 EM ORDEM CRESCENTE: \n");
    while (k < 4) {
        printf("%d ", grupo3[k]);
        k++;
    }

    k = 0;
    i = 0;
    printf("\nGRUPO 3 EM ORDEM DECRESCENTE: \n");
    while (i < 2) {
        temporario = grupo3[i];
        grupo3[i] = grupo3[3 - i];
        grupo3[3 - i] = temporario;
        i++;
    }
    while (k < 4) {
        printf("%d ", grupo3[k]);
        k++;
    }

// -------------GRUPO 4 -----------------------------
    k = 0;
    printf("\n\nGRUPO 4: \n");
    while (k < 4) {
        printf("%d ", grupo4[k]);
        k++;
    }
    
    i = 0;
    while (i < 4) {
        j = 0;
        while (j < 3 - i) {
            if (grupo4[j] > grupo4[j+1]) {
                temporario = grupo4[j];
                grupo4[j] = grupo4[j+1];
                grupo4[j+1] = temporario;
            }
            j++;
        }
        i++;
    }

    k = 0;
    printf("\nGRUPO 4 EM ORDEM CRESCENTE: \n");
    while (k < 4) {
        printf("%d ", grupo4[k]);
        k++;
    }

    k = 0;
    i = 0;
    printf("\nGRUPO 4 EM ORDEM DECRESCENTE: \n");
    while (i < 2) {
        temporario = grupo4[i];
        grupo4[i] = grupo4[3 - i];
        grupo4[3 - i] = temporario;
        i++;
    }
    while (k < 4) {
        printf("%d ", grupo4[k]);
        k++;
    }

// -------------GRUPO 5 -----------------------------
    k = 0;
    printf("\n\nGRUPO 5: \n");
    while (k < 4) {
        printf("%d ", grupo5[k]);
        k++;
    }
    
    i = 0;
    while (i < 4) {
        j = 0;
        while (j < 3 - i) {
            if (grupo5[j] > grupo5[j+1]) {
                temporario = grupo5[j];
                grupo5[j] = grupo5[j+1];
                grupo5[j+1] = temporario;
            }
            j++;
        }
        i++;
    }

    k = 0;
    printf("\nGRUPO 5 EM ORDEM CRESCENTE: \n");
    while (k < 4) {
        printf("%d ", grupo5[k]);
        k++;
    }

    k = 0;
    i = 0;
    printf("\nGRUPO 5 EM ORDEM DECRESCENTE: \n");
    while (i < 2) {
        temporario = grupo5[i];
        grupo5[i] = grupo5[3 - i];
        grupo5[3 - i] = temporario;
        i++;
    }
    while (k < 4) {
        printf("%d ", grupo5[k]);
        k++;
    }
    printf("\n");
    return 0;
}
 */

/* 
SEGUNDA RESOLUÇÃO:

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
} */