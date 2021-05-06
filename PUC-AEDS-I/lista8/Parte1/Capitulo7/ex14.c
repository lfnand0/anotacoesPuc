#include <stdio.h>

int main() {
	int m[2][3];
	for (int i = 0; i < 2; i++)	{
		for (int j = 0; j < 3; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%d", &m[i][j]);
		}
		printf("\n");
	}
	
	int quantidade = 0;
	for (int i = 0; i < 2; i++)	{
		for (int j = 0; j < 3; j++)	{
			if (m[i][j] < 5 || m[i][j] > 15) {
				quantidade++;
			}
		}
	}
	printf("Quantidade de elementos da matriz que não pertencem ao intervalo [5, 15]: %d.\n", quantidade);
}
