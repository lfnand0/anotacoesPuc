#include <stdio.h>

int main()
{
    int idade;
    printf("Digite a idade: ");
    scanf("%d", &idade);
    if (idade < 5)
    {
        printf("Idade inválida (menor de 5)\n");
        return 0;
    }
    else if (idade >= 5 && idade <= 7)
    {
        printf("Infantil (idade: %d)\n", idade);
        return 0;
    }
    else if (idade >= 8 && idade <= 10)
    {
        printf("Juvenil (idade: %d)\n", idade);
        return 0;
    }
    else if (idade >= 11 && idade <= 15)
    {
        printf("Adolescente (idade: %d)\n", idade);
        return 0;
    }
    else if (idade >= 16 && idade <= 30)
    {
        printf("Adulto (idade: %d)\n", idade);
        return 0;
    }
    else if (idade > 30)
    {
        printf("Sênior (idade: %d)\n", idade);
        return 0;
    }
    return 1;
}