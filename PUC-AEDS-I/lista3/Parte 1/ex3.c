#include <stdio.h>

// Novamente utilizei arrays pra facilitar. Espero que não seja um problema :)
int main()
{
  int idade[8];
  printf("Digite as 8 idades: \n");
  scanf("%d %d %d %d %d %d %d %d", &idade[0], &idade[1], &idade[2], &idade[3], &idade[4], &idade[5], &idade[6], &idade[7]);

  int i = 0, faixa1, faixa2, faixa3, faixa4, faixa5;
  faixa1 = faixa2 = faixa3 = faixa4 = faixa5 = 0;
  while (i < 8)
  {
    if (idade[i] < 0)
    {
      printf("Erro: as idades não podem ser negativas.\n");
      return 0;
    }
    if (idade[i] <= 15)
    {
      faixa1++;
    }
    else if (idade[i] > 15 && idade[i] <= 30)
    {
      faixa2++;
    }
    else if (idade[i] > 30 && idade[i] <= 45)
    {
      faixa3++;
    }
    else if (idade[i] > 45 && idade[i] <= 60)
    {
      faixa4++;
    }
    else
    {
      faixa5++;
    }

    i++;
  }
  printf("A primeira faixa etária (até 15 anos) possui %d pessoas\n", faixa1);
  printf("A segunda faixa etária (de 16 a 30 anos) possui %d pessoas\n", faixa2);
  printf("A terceira faixa etária (de 31 a 45 anos) possui %d pessoas\n", faixa3);
  printf("A quarta faixa etária (de 46 a 60 anos) possui %d pessoas\n", faixa4);
  printf("A quinta (última) faixa etária (acima de 60 anos) possui %d pessoas\n", faixa5);

  printf("\nA porcentagem de pessoas na primeira faixa etária é de %.2f%%\n", ((float)faixa1 / 8.0) * 100);
  printf("A porcentagem de pessoas na última faixa etária é de %.2f%%\n", ((float)faixa5 / 8.0) * 100);
}