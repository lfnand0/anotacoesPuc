#include <stdio.h>

int main()
{
  int carro;

  printf("\n---------TABELA DE ACRÉSCIMOS---------");
  int parcelas, i;
  for (i = 1; i <= 10; i++)
  {
    parcelas = 3;
    parcelas *= i * 2;
    printf("\nQuantidade de parcelas: %d\n", parcelas);
    printf("Percentual de acréscimo sobre o preço final: %d%%\n", parcelas / 2);
  }
  printf("--------------------------------------\n\n");

  int tipoDePagamento;
  printf("Para pagar parcelado, digite 1. Para pagar à vista, digite 2: ");
  scanf("%d", &tipoDePagamento);

  if (tipoDePagamento == 1)
  {
    // preco original * 100% + acrescimo * 80%
    printf("Digite o valor do carro e a quantidade de parcelas que deseja dividir seu pagamento em: ");
    scanf("%d %d", &carro, &parcelas);

    // erro
    if (parcelas % 6 != 0 || parcelas > 60 || parcelas < 6)
    {
      printf("Erro: Valor inválido de parcelas.\n");
      return 0;
    }

    //valor final
    printf("Valor final (com %d%% de acréscimo): R$%.2f\n", parcelas / 2, (float)carro * (100 + parcelas / 2) / 100);
  }
  else if (tipoDePagamento == 2)
  {
    printf("Digite o valor do carro: ");
    scanf("%d", &carro);

    printf("Valor final (com 20%% de desconto): R$%.2f\n", (float)carro * 0.8);
  }
}