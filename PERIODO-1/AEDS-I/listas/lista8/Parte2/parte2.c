#include <stdio.h>

void multiplicacao(int n, int a[n][n], int b[n][n], int m[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            m[i][j] = 0; // limpando o valor antes do cálculo
            for (int l = 0; l < n; l++) {
                m[i][j] += (a[i][l] * b[l][j]);
            }
        }
    }
}

int main() {
    int n;
    printf("Digite o tamanho das matrizes: ");
    scanf("%d", &n);
    
	int a[n][n], b[n][n];
	for (int i = 0; i < n; i++)	{
		for (int j = 0; j < n; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d da primeira matriz: ", i + 1, j + 1);
			scanf("%d", &a[i][j]);
		}
		printf("\n");
	}
    
	for (int i = 0; i < n; i++)	{
		for (int j = 0; j < n; j++)	{
			printf("Digite o valor do elemento da linha %d, coluna %d da segunda matriz: ", i + 1, j + 1);
			scanf("%d", &b[i][j]);
		}
		printf("\n");
	}

    int matrizResultante[n][n];
    multiplicacao(n, a, b, matrizResultante);
    
    printf("Matriz Resultante: \n");
	for (int i = 0; i < n; i++)	{
		for (int j = 0; j < n; j++)	{
            printf("%d ", matrizResultante[i][j]);
        }
        printf("\n");
    } 
}
