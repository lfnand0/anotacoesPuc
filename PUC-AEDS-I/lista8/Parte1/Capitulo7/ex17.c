#include <stdio.h>

int main() {
	float m[10][10];
	for (int i = 0; i < 10; i++)	{
		for (int j = 0; j < 10; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%f", &m[i][j]);
		}
		printf("\n");
	}
	
	float media = 0;
	for (int i = 0; i < 10; i++)	{
		media += m[i][i] / 10.0;
	}
	printf("Média dos elementos na diagonal principal: %.2f.\n", media);	
}
