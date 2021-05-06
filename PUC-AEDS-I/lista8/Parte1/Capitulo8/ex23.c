#include <stdio.h>

int formaTriangulo(int a, int b, int c) {
	if (a < 0 || b < 0 || c < 0) {
		printf("\nErro: todos os valores precisam ser positivos.\n");
		return 0;
	} else if (a + b < c || a + c < b || b + c < a) {
		printf("\nOs valores %d, %d e %d não formam um triângulo.\n", a, b, c);
		return 0;
	} else {
		printf("\nOs valores %d, %d e %d formam um triângulo.\n", a, b, c);
		return 1;
	}
	
}

void tipoTriangulo(int a, int b, int c) {
	if (formaTriangulo(a, b, c)) {
		if (a == b && b == c) {
			printf("O triângulo de lados %d, %d e %d é equilátero.\n", a, b, c);
		} else if (a == b || b == c) {
			printf("O triângulo de lados %d, %d e %d é isósceles.\n", a, b, c);
		} else {
			printf("O triângulo de lados %d, %d e %d é escaleno.\n", a, b, c);
		}
	}
}

int main() {
	int a, b, c;
	printf("Digite o valor de a: ");
	scanf("%d", &a);
	printf("Digite o valor de b: ");
	scanf("%d", &b);
	printf("Digite o valor de c: ");
	scanf("%d", &c);
	tipoTriangulo(a, b, c);
	
}
