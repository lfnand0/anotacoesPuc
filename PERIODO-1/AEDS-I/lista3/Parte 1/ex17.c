#include <stdio.h>

int main()
{
  int total4, total5, total7, total12, total, i = 1;
  total4 = total5 = total7 = total12 = total = 0;
  while (1 == 1)
  {
    int canal, ligada, pessoas;
    printf("----------CASA %d----------\n", i);
    printf("Digite 1 se a TV estiver ligada e 0 se estiver desligada: ");
    scanf("%d", &ligada);
    if (ligada == 1)
    {
      printf("CANAIS FORNECIDOS: 4, 5, 7 e 12.\n");
      printf("Digite o canal que a TV da casa %d está ligada em, ou digite 0 para finalizar o programa: ", i);
      scanf("%d", &canal);
      if (canal == 0)
      {
        printf("-------------------------\n");
        printf("\n Canal 4: porcentagem de audiência = %.2f%%\n", 100 * ((float)total4 / (float)total));
        printf("Canal 5: porcentagem de audiência = %.2f%%\n", 100 * ((float)total5 / (float)total));
        printf("Canal 7: porcentagem de audiência = %.2f%%\n", 100 * ((float)total7 / (float)total));
        printf("Canal 12: porcentagem de audiência = %.2f%%\n", 100 * ((float)total12 / (float)total));
        return 0;
      }
      printf("Digite a quantidade de pessoas nessa casa: ");
      scanf("%d", &pessoas);
      if (pessoas < 0)
      {
        printf("Erro: a quantidade de pessoas não pode ser negativo.\n");
        return 0;
      }
      total += pessoas;
      if (canal == 4)
      {
        total4 += pessoas;
      }
      else if (canal == 5)
      {
        total5 += pessoas;
      }
      else if (canal == 7)
      {
        total7 += pessoas;
      }
      else if (canal == 12)
      {
        total12 += pessoas;
      }
      else
      {
        printf("Erro: Canal Inválido.\n");
        return 0;
      }
    }
    i++;
  }
}