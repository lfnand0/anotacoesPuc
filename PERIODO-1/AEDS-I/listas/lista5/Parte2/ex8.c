#include <stdio.h>

void fatorial(int a)
{
    int inicial = a, Fatorial = 1; // usado no printf final
    while (a <= 0)
    {
        printf("Erro: O valor precisa ser positivo. Redigite-o: ");
        scanf("%d", &a);
    }
    while (a > 1)
    {
        Fatorial = Fatorial * a;
        a -= 1;
    }
    printf("%d! é igual a %d.\n", inicial, Fatorial);
}

int main()
{
    int num;
    printf("Digite um número: ");
    scanf("%d", &num);
    while (num <= 0)
    {
        printf("Erro: O valor precisa ser positivo. Redigite-o: ");
        scanf("%d", &num);
    }
    fatorial(num);
}