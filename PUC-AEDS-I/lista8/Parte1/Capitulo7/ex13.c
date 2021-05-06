#include <stdio.h>

int main() {
	int m[6][4];
	for (int i = 0; i < 6; i++)	{
		for (int j = 0; j < 4; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%d", &m[i][j]);
		}
		printf("\n");
	}
	
	for (int i = 0; i < 6; i++) {
		int maior = m[i][0];
		for (int k = 1; k < 4; k++) {
			if (m[i][k] > maior)
				maior = m[i][k];
		}
		for (int j = 0; j < 4; j++) {
			m[i][j] *= maior;
		}
	}

	printf("Matriz resultante: \n");
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 4; j++) {
			printf("%d ", m[i][j]);
		}
		printf("\n");
	}
}
