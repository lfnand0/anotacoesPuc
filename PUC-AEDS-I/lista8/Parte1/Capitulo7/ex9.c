#include <stdio.h>

int main() {

  float m[3][3], n;
 	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 3; j++) {
     	printf("Digite o valor do elemento da linha %d, coluna %d: ", i+1, j+1);
     	scanf("%f", &m[i][j]);
   	}
   	printf("\n");
 	}
	printf("\nDigite o valor que você deseja multiplicar a matriz por: ");
	scanf("%f", &n);

	printf("Matriz resultante: \n");
 	for (int i = 0; i < 3; i++) {
   	for (int j = 0; j < 3; j++) {
			m[i][j] *= n;
			printf("%.2f ", m[i][j]);
			//mostrando os valores dentro do próprio loop para economizar espaço
		}
		printf("\n");
	}
}

