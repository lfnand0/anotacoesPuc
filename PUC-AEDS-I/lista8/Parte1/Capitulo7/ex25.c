#include <stdio.h>

int main() {
	int precoProdutos[10], estoqueProdutos[5][10];

	for (int i = 0; i < 10; i++) {
		printf("Digite o preço do produto %d: ", i + 1);
		scanf("%d", &precoProdutos[i]);
	}
	printf("\n");

	for (int i = 0; i < 5; i++)	{
		for (int j = 0; j < 10; j++)	{
			printf("Digite o estoque do produto %d no armazém %d: ", j + 1, i + 1);
			scanf("%d", &estoqueProdutos[i][j]);
		}
		printf("\n");
	}	
	printf("\n");

	// quantidade de produtos estocados em cada um dos armazéns
	for (int i = 0; i < 5; i++) {
		int soma = 0;
		for (int j = 0; j < 10; j++) {
			soma += estoqueProdutos[i][j];
		}
		printf("Quantidade de produtos estocados no %dº armazém: %d\n", i+1, soma);
	}
	printf("\n");

	// quantidade de cada um dos produtos estocados, em todos os armazéns juntos
	int soma = 0;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 10; j++) {
			soma += estoqueProdutos[i][j];
		}
	}
	printf("Quantidade de produtos estocados em todos os armazéns: %d\n\n", soma);
	
	// o preço do produto que possui maior estoque em um único armazém
	for (int i = 0; i < 5; i++) {
		int maior = estoqueProdutos[i][0], maiorIndice = 0;
		for (int j = 1; j < 10; j++) {
			if (estoqueProdutos[i][j] > maior) {
				maior = estoqueProdutos[i][j];
				maiorIndice = j;
			}		
		}
		printf("Preço do produto que possui o maior estoque no armazém %d: %d\n", i+1, precoProdutos[maiorIndice]);
	}
	printf("\n");

	// o menor estoque armazenado
	int menorEstoque = estoqueProdutos[0][0], menorLinha, menorColuna;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 10; j++) {
			if (estoqueProdutos[i][j] < menorEstoque) {
				menorEstoque = estoqueProdutos[i][j];
				menorLinha = i;
				menorColuna = j;
			}
		}
	}
	printf("O menor estoque (produto %d no armazém %d) é de %d\n\n", menorColuna, menorLinha, menorEstoque);
	// o custo de cada armazém
	for (int i = 0; i < 5; i++) {
		int custo = 0;
		for (int j = 0; j < 10; j++) {
			custo += precoProdutos[j] * estoqueProdutos[i][j];
		}
		printf("Custo do armazém %d: %d\n", i+1, custo);
	}
}
