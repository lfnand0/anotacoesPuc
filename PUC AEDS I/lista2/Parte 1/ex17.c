#include <stdio.h>

int main()
{
    int senha;
    printf("Digite a senha: ");
    scanf("%d", &senha);
    if (senha == 4531)
    {
        printf("Acesso validado. Redirecionando...\n");
        return 0;
    }
    else
    {
        printf("Senha inválida, tente novamente.\n");
        return 0;
    }
    return 1;
}