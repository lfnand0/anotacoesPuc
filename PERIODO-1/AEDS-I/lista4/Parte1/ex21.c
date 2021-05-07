#include <stdio.h>

int main(){
    const int senhaCorreta = 1234;
    int senha;
    while (senha != senhaCorreta) {
        printf("\nDigite a senha: ");
        scanf("%d", &senha);
        if (senha != senhaCorreta) {
            printf("SENHA INVÁLIDA\n");
        }
    }
    printf("ACESSO PERMITIDO\n");
}
