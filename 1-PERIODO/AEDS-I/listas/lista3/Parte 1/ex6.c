#include <stdio.h>

int main()
{
  double totalPrazo, totalVista, total, valor;
  totalPrazo = totalVista = total = 0;
  char codigo;

  int i = 1;
  while (i < 16)
  {
    printf("Digite a %dª prestação e seu respectivo código: ", i);
    scanf("%lf %c", &valor, &codigo);
    if (codigo == 86 || codigo == 118)
    { // V e v em ASCII
      total += valor;
      totalVista += valor;
    }
    else if (codigo == 80 || codigo == 112)
    { // P e p em ASCII
      total += valor;
      totalPrazo += valor;
    }
    else
    {
      printf("Erro: código inválido (precisa ser V ou P)\n");
      return 0;
    }
    i++;
  }
  printf("\n-------------------------\n");
  printf("O valor total das compras à vista foi de R$%.2lf\n", totalVista);
  printf("O valor total das compras a prazo foi de R$%.2lf\n", totalPrazo);
  printf("O valor total das compras efeituadas foi de R$%.2lf\n", total);
  printf("O valor da primeira prestação das compras a prazo juntas foi de R$%.2lf\n", totalPrazo / 3.0);
  printf("-------------------------\n");
}