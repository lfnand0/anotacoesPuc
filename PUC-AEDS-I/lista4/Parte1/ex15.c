#include <stdio.h>

int main(){
    int n;
    printf("(Para finalizar a qualquer momento, digite 0.)\n");
    do {
        printf("\nDigite um valor para n: ");
+       scanf("%d", &n);
        if (n > 0) {
            printf("%d É POSITIVO.\n", n);
        } else if(n < 0) {
            printf("%d É NEGATIVO.\n", n);
        }
    } while (n != 0);
}
