#include <stdio.h>

int main() {
    int num, i = 0;
    printf("Digite um número: ");
    scanf("%d", &num);

    while(i < 11) {
        printf("%d x %d = %d\n", num, i, num*i);
        i++;
    }
}