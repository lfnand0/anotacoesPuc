#include <stdio.h>

int quantPares(int x[15]) {
	int quantidade = 0;
	for (int i = 0; i < 15; i++) {
		if (x[i] % 2 == 0)
			quantidade++;
	}
	return quantidade;
}

int main() {
	int x[15];
	for (int i = 0; i < 15; i++) {
		printf("Digite o %dº valor do vetor: ", i+1);
		scanf("%d", &x[i]);
	}
	printf("\nA quantidade de elementos pares no vetor é %d.\n", quantPares(x));
}
