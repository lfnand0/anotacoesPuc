#include <stdio.h>

int main()
{
  double totalInvestido, totalJuros;
  totalInvestido = totalJuros = 0;
  while (1 == 1)
  {
    int codigo, tipo;
    double valor, juros;
    printf("Digite o código do usuário: ");
    scanf("%d", &codigo);
    if (codigo <= 0)
    {
      printf("--------------------\n\n");
      printf("TOTAL INVESTIDO R$%.2f\n", totalInvestido);
      printf("TOTAL DE JUROS PAGOS: R$%.2f\n", totalJuros);
      return 0;
    }
    printf("Digite o tipo do investimento: ");
    scanf("%d", &tipo);
    printf("Digite o valor investido: ");
    scanf("%lf", &valor);
    totalInvestido += valor;
    if (tipo == 1)
    {
      juros = valor * 0.015;
      totalJuros += juros;
      printf("Rendimento mensal do usuário de código %d: R$%.2f\n\n", codigo, juros);
    }
    else if (tipo == 2)
    {
      juros = valor * 0.02;
      totalJuros += juros;
      printf("Rendimento mensal do usuário de código %d: R$%.2f\n\n", codigo, juros);
    }
    else if (tipo == 3)
    {
      juros = valor * 0.04;
      totalJuros += juros;
      printf("Rendimento mensal do usuário de código %d: R$%.2f\n\n", codigo, juros);
    }
    else
    {
      printf("Erro: tipo de investimento inválido.\n");
      return 0;
    }
  }
}