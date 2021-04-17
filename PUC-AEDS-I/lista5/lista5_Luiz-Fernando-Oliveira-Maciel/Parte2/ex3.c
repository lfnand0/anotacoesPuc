#include <stdio.h>

int funcao(int a, int b) {
    if (a % b == 0) {
        return 0;
    } else {
        int i = b + 1;
        while (a % i != 0) {
            i++;
        }
        return i;
    }
}

int main() {
    int a, b;
    printf("Digite dois números: ");
    scanf("%d %d", &a, &b);
    printf("%d", funcao(a,b));
}