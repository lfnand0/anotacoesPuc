#include <stdio.h>

// S = 83, N = 78, F = 70, M = 77
int main()
{
  int sim, nao, mulheresSim, homensTotal, homensNao;
  sim = nao = mulheresSim = homensTotal = homensNao = 0;
  int i = 0;
  while (i < 5)
  {
    char sexo, resposta;

    printf("Digite o sexo do entrevistado (M para masculino, F para feminino): ");
    scanf(" %c", &sexo);
    if (sexo != 70 && sexo != 77)
    {
      printf("Erro: digite M ou F para o sexo.\n");
      return 0;
    }

    printf("Digite a resposta (S para sim, N para não): ");
    scanf(" %c", &resposta);
    if (resposta != 83 && resposta != 78)
    {
      printf("Erro: digite S ou N para a resposta.\n");
      return 0;
    }

    if (resposta == 83)
    {
      sim++;
      if (sexo == 70)
      {
        mulheresSim++;
      }
      else if (sexo == 77)
      {
        homensTotal++;
      }
    }

    if (resposta == 78)
    {
      nao++;
      if (sexo == 77)
      {
        homensTotal++;
        homensNao++;
      }
    }
    i++;
  }

  printf("\nO número de pessoas que responderam sim é %d\n", sim);
  printf("O número de pessoas que responderam não é %d\n", nao);
  printf("O número de mulheres que responderam sim é %d\n", mulheresSim);
  printf("A porcentagem de homens que responderam não, entre todos os homens analisados, é %.2f%%\n", 100 * ((float)homensNao / (float)homensTotal));
}