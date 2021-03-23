#include <stdio.h>
#include <math.h>

int main() {
    int n;
    printf("Digite um número: \n");
    scanf("%d", &n);

    double raiz = sqrt(n);
    printf("A raiz quadrada de %d é %lf", n, raiz);
}