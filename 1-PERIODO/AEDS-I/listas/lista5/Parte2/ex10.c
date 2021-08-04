#include <stdio.h>

void sequencia(int n) {
    while (n < 1) {
        printf("Erro: n precisa ser positivo. Redigite-o: ");
        scanf("%d", &n); 
    }
    float s = 0, i = 1;
    while(i <= n) {
        s += 1.0/i;
        i++;
    }
    printf("O valor da sequência S é de %f.\n", s);
}

int main() {
   int n;
   printf("Digite o valor de n: ");
   scanf("%d", &n);
   sequencia(n);
}