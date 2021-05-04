#include <stdio.h>

int main() {
  int total[10];
  float percentComissao[10];
  char nome[10][100];
  
  for (int i = 0; i < 10; i++) {
    printf("Digite o nome do %dº vendedor: ", i + 1);
    scanf("%s", nome[i]);
    printf("Digite o total de vendas do %dº vendedor: ", i + 1);
    scanf("%d", &total[i]);
    printf("Digite o percentual de comissão do %dº vendedor: ", i + 1);
    scanf("%f", &percentComissao[i]);
  }
  
  int somaTotal = 0, maiorValNome, menorValNome;
  float maiorValor, menorValor;
  maiorValor = menorValor = (float) total[0] * percentComissao[0] / 100.0; // valor temporário
  float valorFinal[10];
  for (int i = 0; i < 10; i++) {
    valorFinal[i] = (float) total[i] * percentComissao[i] / 100.0;
    somaTotal += total[i];
    if (valorFinal[i] < menorValor) {
      menorValor = valorFinal[i];
      menorValNome = i;
    }
    if (valorFinal[i] > maiorValor) {
      maiorValor = valorFinal[i];
      maiorValNome = i;
    }
    printf("\n----------%dº VENDEDOR----------\n", i + 1);
    printf("Nome: %s\n", nome[i]);
    printf("Valor a receber: R$%.2f\n", (float) total[i] * percentComissao[i] / 100.0);    
  }
  printf("\n-------------------------------\n\n");
  printf("O total de vendas de todos os vendedores foi R$%d.\n", somaTotal);
  printf("O maior valor a receber é de R$%.2f , do(a) vendedor(a) %s.\n", maiorValor, nome[maiorValNome]);
  printf("O menor valor a receber é de R$%.2f , do(a) vendedor(a) %s.\n", menorValor, nome[menorValNome]);

}