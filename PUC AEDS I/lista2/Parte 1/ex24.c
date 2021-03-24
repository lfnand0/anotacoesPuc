#include <stdio.h>

int main() {
    int preco;
    int categoria;
    char situacao;
    double percentual;
    double imposto;
    printf("Digite o preço: ");
    scanf("%d", &preco);
    printf("Digite a categoria: ");
    scanf("%d", &categoria);
    if (categoria <= 0 || categoria > 3) {
        printf("Erro: escolha uma categoria de 1 a 3\n");
        return 0;
    }
    printf("Digite a situação: ");
    scanf("%s", &situacao);
    if (situacao != 82 && situacao != 78) {
        printf("Erro: escolha uma situacao R ou N\n");
        return 0;
    }
    if (preco <= 25) {
        if (categoria == 1) {
            printf("Percentual de aumento: 5%%\n");
            percentual = 1.05;
        } else if (categoria == 2) {
            printf("Percentual de aumento: 8%%\n");
            percentual = 1.08;
        } else {
            printf("Percentual de aumento: 10%%\n");
            percentual = 1.10;
        }
    } else {
        if (categoria == 1) {
            printf("Percentual de aumento: 12%%\n");
            percentual = 1.12;
        } else if (categoria == 2) {
            printf("Percentual de aumento: 15%%\n");
            percentual = 1.15;
        } else {
            printf("Percentual de aumento: 18%%\n");
            percentual = 1.18;
        }
    }
    
}