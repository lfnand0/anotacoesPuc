#include <stdio.h>

int main(){
    int n = 1;
    while (n > 0) {
        printf("\nDigite um valor para n: ");
        scanf("%d", &n);
        if (n > 0 && n % 2 == 0) {
            printf("%d É PAR.\n", n);
        } else if (n > 0 && n % 2 == 1) {
            printf("%d É ÍMPAR.\n", n);
        }
    }
}
