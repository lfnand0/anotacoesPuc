#include <stdio.h>

int main(){
    int x;
    printf("Digite um valor para x: ");
    scanf("%d", &x);
    while (x < 1 || x > 10) {
        printf("Erro: digite um valor entre 1 e 10: ");
        scanf("%d", &x);
    }
    
    int i;
    for (i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", x, i, x * i);
    }
}
