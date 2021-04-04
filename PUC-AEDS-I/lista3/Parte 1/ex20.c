#include <stdio.h>

int main()
{
  printf("Menu de opções\n1. Média aritmética\n2. Média ponderada\n3. Sair\n\nDigite a opção desejada.\n");
  int opcao;
  scanf("%d", &opcao);
  if (opcao == 3)
  {
    return 0;
  }
  else if (opcao == 1)
  {
    int a, b;
    printf("\nDigite duas notas: ");
    scanf("%d %d", &a, &b);
    printf("A média entre %d e %d é %.2f\n", a, b, (a + b) / 2.0);
    return 0;
  }
  else if (opcao == 2)
  {
    double a, b, c, pesoA, pesoB, pesoC;
    printf("\nDigite a primeira nota e seu peso: ");
    scanf("%lf %lf", &a, &pesoA);
    printf("Digite a segunda nota e seu peso: ");
    scanf("%lf %lf", &b, &pesoB);
    printf("Digite a terceira nota e seu peso: ");
    scanf("%lf %lf", &c, &pesoC);
    double media = (a * pesoA + b * pesoB + c * pesoC) / (pesoA + pesoB + pesoC);
    printf("A média é igual a %.3lf", media);
    return 0;
  }
  else
  {
    printf("Erro: opção inválida.\n");
    return 0;
  }
}