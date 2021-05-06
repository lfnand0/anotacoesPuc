#include <stdio.h>

int main()
{
  int codigo[10], estoque[10];
  for (int i = 0; i < 10; i++)
  {
    printf("Digite o código do %dº produto: ", i + 1);
    scanf("%d", &codigo[i]);
  }
  for (int i = 0; i < 10; i++)
  {
    printf("Digite a quantidade em estoque do %dº produto: ", i + 1);
    scanf("%d", &estoque[i]);
  }
  for (int i = 0; i < 10; i++)
  {
    printf("DEBUG: codigo[%d] = %d, estoque[%d] = %d\n", i, codigo[i], i, estoque[i]);
  }

  int cliente = 1, produtoCliente, estoqueCliente, produtoExiste;
  printf("\nPARA FINALIZAR O PROGRAMA, DIGITE 0 NO CÓDIGO DO CLIENTE\n");
  while (cliente != 0)
  {
    printf("\nDígite o código do cliente: ");
    scanf("%d", &cliente);
    if (cliente != 0)
    {
      printf("Digite o código do produto que o cliente deseja comprar: ");
      scanf("%d", &produtoCliente);
      produtoExiste = 0;
      for (int i = 0; i < 10; i++)
      {
        if (produtoCliente == codigo[i])
        {
          produtoExiste = 1;
        }
      }
      if (produtoExiste == 0)
      {
        printf("Código inexistente\n");
      }
      else
      {
        printf("Digite a quantidade de produto que o cliente deseja comprar: ");
        scanf("%d", &estoqueCliente);
        for (int i = 0; i < 10; i++)
        {
          if (produtoCliente == codigo[i])
          {
            if (estoque[i] < estoqueCliente)
            {
              printf("Não temos estoque dessa mercadoria\n");
            }
            else
            {
              estoque[i] -= estoqueCliente;
              printf("Pedido atendido. Obrigado e volte sempre\n");
            }
          }
        }
      }
    }
  }
  printf("\n--------------------\n");
  for (int i = 0; i < 10; i++)
  {
    printf("PRODUTO %d:\nQuantidade em estoque = %d.\n\n", codigo[i], estoque[i]);
  }
}