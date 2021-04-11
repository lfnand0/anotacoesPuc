#include <stdio.h>
#include <math.h>

int main() {
  printf("(Para finalizar o programa a qualquer momento, digite: 0, 0, 0, 0)\n\n");
  double x1, x2, y1, y2, distancia; // x1 = 1 para que o loop rode na primeira instância
  while (x1 != 0 || x2 != 0 || y1 != 0 || y2 != 0) {
    printf("Digite os valores seguindo o formato x1, x2, y1, y2: ");
    scanf("%lf, %lf, %lf, %lf", &x1, &x2, &y1, &y2);
    distancia = pow((x2 - x1), 2) + pow((y2 - y1), 2);
    distancia = sqrt(distancia);
    if (x1 != 0 || x2 != 0 || y1 != 0 || y2 != 0) {
      printf("Distância entre os pontos P e Q: %lf\n\n", distancia);  
    }
  }
  printf("\n");
}
