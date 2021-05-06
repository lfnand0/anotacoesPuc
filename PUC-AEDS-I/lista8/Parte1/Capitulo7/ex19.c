#include <stdio.h>

int main() {
	float m[8][6];
	for (int i = 0; i < 8; i++)	{
		for (int j = 0; j < 6; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%f", &m[i][j]);
		}
		printf("\n");
	}

	printf("Média dos elementos das linhas pares: \n");
	for (int i = 1; i < 8; i += 2)	{
		float media = 0;
		for (int j = 0; j < 6; j++)	{
			media += m[i][j] / 6.0;
		}
		printf("Linha %d: %.2f\n", i + 1, media);
	}
}
