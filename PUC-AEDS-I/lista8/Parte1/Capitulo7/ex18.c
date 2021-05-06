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

	float soma = 0;
	for (int i = 0; i < 5; i++)	{
		soma += m[i][4-i];
	}
	printf("Soma dos elementos da diagonal secundária: %.2f.\n", soma);

}
