#include <stdio.h>

int main()
{
	int m[5][5];
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%d", &m[i][j]);
		}
		printf("\n");
	}

	printf("\nSoma dos elementos da linha 4: ");
	int soma = 0;
	for (int i = 0; i < 5; i++)
	{
		soma += m[3][i];
	}
	printf("%d\n", soma);

	printf("Soma dos elementos da coluna 2: ");
	soma = 0;
	for (int i = 0; i < 5; i++)
	{
		soma += m[i][1];
	}
	printf("%d\n", soma);

	printf("Soma dos elementos da diagonal principal: ");
	soma = 0;
	for (int i = 0; i < 5; i++)
	{
		soma += m[i][i];
	}
	printf("%d\n", soma);

	printf("Soma dos elementos da diagonal secundária: ");
	soma = 0;
	for (int i = 0; i < 5; i++)
	{
		soma += m[i][4 - i];
	}
	printf("%d\n", soma);
}
