#include <stdio.h>

void media() {
    int n = 1, total = 0;
    float media = 0;
    while (n != 0) {
        printf("Digite um valor: ");
        scanf("%d", &n);
        if (n != 0) {
            total++;
            media += n;
        }
    }
    media /= (float) total;
    printf("A média dos valores é %f.\n", media);
}

int main() {
    media();
}