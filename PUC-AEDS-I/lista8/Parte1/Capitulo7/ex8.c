#include <stdio.h>

int main() { 
  int m[3][8], m2[3][8];
 	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 8; j++) {
     	printf("MATRIZ 1: Digite o valor do elemento da linha %d, coluna %d: ", i+1, j+1);
     	scanf("%d", &m[i][j]);
   	}
   	printf("\n");
 	}
 	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 8; j++) {
     	printf("MATRIZ 2: Digite o valor do elemento da linha %d, coluna %d: ", i+1, j+1);
     	scanf("%d", &m2[i][j]);
   	}
   	printf("\n");
 	}

	int mSoma[3][8], mDiferenca[3][8];
 	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 8; j++) {
			mSoma[i][j] = m[i][j] + m2[i][j];
			mDiferenca[i][j] = m[i][j] - m2[i][j];
		}
	}

	printf("Soma das matrizes: \n");
	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 8; j++) {
			printf("%d ", mSoma[i][j]);
		}
		printf("\n");
	}

	printf("\nDiferença das matrizes: \n");
	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 8; j++) {
			printf("%d ", mDiferenca[i][j]);
		}
		printf("\n");
	}
}
