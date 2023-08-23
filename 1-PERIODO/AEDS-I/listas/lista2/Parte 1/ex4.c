#include <stdio.h>

int main()
{
    int num1;
    int num2;
    int num3;
    printf("Digite três números: \n");
    scanf("%d %d %d", &num1, &num2, &num3);
    if (num1 > num2 && num1 > num3)
    {
        printf("Entre %d, %d e %d, %d é o maior.", num1, num2, num3, num1);
    }
    else if (num2 > num1 && num2 > num3)
    {
        printf("Entre %d, %d e %d, %d é o maior.", num1, num2, num3, num2);
    }
    else if (num3 > num2 && num3 > num1)
    {
        printf("Entre %d, %d e %d, %d é o maior.", num1, num2, num3, num3);
    }
    else
    {
        printf("Dois ou mais valores são iguais.");
    }
}