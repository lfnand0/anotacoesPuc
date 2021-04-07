#include <stdio.h>
#include <math.h>

int main() {
  double num, contador, soma, somaPotencia, desvio, media;
  /*
    ADAPTANDO FÓRMULA AO PROGRAMA:
    desvio = sqrt(((num1²+num2²+...+numx²) - 2*media*(num1+num2+...+numx) + contador * media²)/contador)
  */
  contador = soma = somaPotencia = desvio = media = 0;
  while (num != 0) {
    printf("Digite um valor: ");
    scanf("%lf", &num);
    if (num != 0) {
      // evitando o input 0
      contador++;
      soma += num;
      somaPotencia += num * num;
    }
  }
  media = soma/contador;
  desvio = sqrt((somaPotencia - (2 * media * soma) + contador * media * media)/contador);
  printf("Média = %lf; Desvio Padrão = %lf\n", media, desvio);

}