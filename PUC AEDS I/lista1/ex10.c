#include <stdio.h>

int main() {
    int nascimento;
    int atual;
    printf("Digite o ano de nascimento da pessoa e o ano atual: \n");
    scanf("%d %d", &nascimento, &atual);

    printf("A pessoa tem %d anos, e em 2050 ela terá %d.", atual - nascimento, 2050 - nascimento);
}