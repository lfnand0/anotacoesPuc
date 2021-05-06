#include <stdio.h>

void matriz(float m[10][5]) {
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 5; j++) {
			printf("Digite o valor do elemento da linha %d, coluna %d: ", i + 1, j + 1);
			scanf("%f", &m[i][j]);
		}
		printf("\n");
	}
}

float soma(float m[10][5]) {
	float somaElementos = 0;
	for (int i = 6; i < 10; i++) {
		for (int j = 0; j < 5; j++) {
			somaElementos += m[i][j];
		}
	}
	return somaElementos;
}


int main() {
	float x[10][5];
	matriz(x);
	printf("Soma dos elementos: %f.\n", soma(x));
}
