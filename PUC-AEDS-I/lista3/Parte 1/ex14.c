#include <stdio.h>

int main()
{
  int i, quantidadeRegular, quantidadeOtimo;
  float mediaIdadesOtimo, percentagemBom;
  mediaIdadesOtimo = quantidadeRegular = quantidadeOtimo = percentagemBom = 0;
  for (i = 1; i <= 15; i++)
  {
    int idade, opiniao;
    printf("\nDigite a idade do %dº espectador: ", i);
    scanf("%d", &idade);
    if (idade < 0)
    {
      printf("Erro: a idade não pode ser negativa");
    }

    printf("Agora, digite a opinião do espectador, sendo 1 = regular, 2 = bom e 3 = ótimo: ");
    scanf("%d", &opiniao);

    if (opiniao == 1)
    {
      quantidadeRegular++;
    }
    else if (opiniao == 2)
    {
      percentagemBom++;
      printf("DEBUG: percentagemBom = %f\n", percentagemBom);
    }
    else if (opiniao == 3)
    {
      mediaIdadesOtimo += idade;
      quantidadeOtimo++;
    }
    else
    {
      printf("Erro: digite 1, 2 ou 3 pra opinião\n");
      return 0;
    }
  }
  if (quantidadeOtimo == 0)
  {
    mediaIdadesOtimo = 0;
  }
  else
  {
    mediaIdadesOtimo /= quantidadeOtimo;
  }
  printf("\nA média das idades das pessoas que responderam ótimo é %.2f\n", mediaIdadesOtimo);
  printf("A quantidade de pessoas que responderam regular é %d\n", quantidadeRegular);

  percentagemBom /= 15;
  percentagemBom *= 100;
  printf("A percentagem de pessoas que responderam bom, entre todos os espectadores analisados, é %.2f%%\n\n", percentagemBom);
}