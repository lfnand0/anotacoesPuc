#include <stdio.h>

int main()
{
  int v[15], maior, maiorPosicao, menor, menorPosicao;
  for (int i = 0; i < 15; i++)
  {
    printf("Digite o %dº valor do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  // valores temporários
  maior = menor = v[0];
  maiorPosicao = menorPosicao = 0;

  for (int i = 1; i < 15; i++)
  {
    if (v[i] > maior)
    {
      maior = v[i];
      maiorPosicao = i;
    }
    else if (v[i] < menor)
    {
      menor = v[i];
      menorPosicao = i;
    }
  }

  printf("Maior número: %d (Posição %d)\n", maior, maiorPosicao);
  printf("Menor número: %d (Posição %d)\n", menor, menorPosicao);
}
