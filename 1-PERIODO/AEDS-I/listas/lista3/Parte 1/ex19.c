#include <stdio.h>

int main()
{
  int lucroSuperior1000, lucroInferior200;
  double lucroTotal;
  lucroSuperior1000 = lucroInferior200 = lucroTotal = 0;
  printf("\nPara finalizar o programa, digite 'F' como tipo de ação\n\n");

  int i = 0;
  while (1 == 1)
  {
    i++;
    char acao;
    double compra, venda, lucro;

    printf("----------%dª AÇÃO-----------\n", i);
    printf("Digite o tipo de ação: ");
    scanf(" %c", &acao);
    if (acao == 70)
    {
      printf("---------------------------\n\n");
      printf("A quantidade de ações com lucro superior a R$1000.00 foi %d.\n", lucroSuperior1000);
      printf("A quantidade de ações com lucro inferior a R$200.00 foi %d.\n", lucroInferior200);
      if (lucroTotal < 0)
      {
        printf("O prejuízo final foi de R$%.2lf\n\n", lucroTotal);
        return 0;
      }
      printf("O lucro final foi de R$%.2lf\n\n", lucroTotal);
      return 0;
    }

    printf("Digite o valor de compra: ");
    scanf("%lf", &compra);
    printf("Digite o valor de venda: ");
    scanf("%lf", &venda);
    lucro = venda - compra;
    lucroTotal += lucro;

    printf("\nLUCRO DA AÇÃO DO TIPO '%c': R$%.2lf\n", acao, lucro);

    if (lucro > 1000)
    {
      lucroSuperior1000++;
    }
    else if (lucro < 200)
    {
      lucroInferior200++;
    }
  }
}