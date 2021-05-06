#include <stdio.h>

int main() {
	float m[5][5];
	for (int i = 0; i < 5; i++)	{
		for (int j = 0; j < 5; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%f", &m[i][j]);
		}
		printf("\n");
	}

	int maior = m[0][0];
	for (int i = 0; i < 5; i++)	{
		for (int j = 0; j < 5; j++)	{
			if (m[i][j] > maior)
				maior = m[i][j];
		}
	}

	for (int i = 0; i < 5; i++)	{
		m[i][i] *= maior;
	}

	printf("Matriz resultante: \n");
	for (int i = 0; i < 5; i++)	{
		for (int j = 0; j < 5; j++)	{
			printf("%.2f ", m[i][j]);
		}
		printf("\n");
	}
}
