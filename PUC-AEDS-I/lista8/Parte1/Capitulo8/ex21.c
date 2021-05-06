#include <stdio.h>

int maiorAcimaDiagonal(int x[10][10]) {
	int maior = x[0][1];
	for (int i = 0; i < 9; i++) {
		// última linha não é contabilizada pois não existem números acima da diagonal principal nela
		for (int j = 1 + i; j < 10; j ++) {
			if (maior < x[i][j])
				maior = x[i][j];
		}
	}
	return maior;
}

int main() {
	int x[10][10];
	for (int i = 0; i < 10; i++)	{
		for (int j = 0; j < 10; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%d", &x[i][j]);
		}
		printf("\n");
	}

	printf("O maior valor acima da diagonal principal do vetor é %d.\n", maiorAcimaDiagonal(x));
}
