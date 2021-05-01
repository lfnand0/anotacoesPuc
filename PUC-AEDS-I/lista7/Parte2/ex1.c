#include <stdio.h>

void funcaoA(int v[], int n, int atual)
{
  if (atual >= n)
  {
    return;
  }
  printf("%d, ", v[atual]);
  funcaoA(v, n, atual + 1);
}

void funcaoB(int v[], int n)
{
  if (n == 0)
  {
    return;
  }
  printf("%d, ", v[n - 1]);
  funcaoB(v, n - 1);
}

void funcaoC(int v[], int n, int soma)
{
  if (n < 0)
  {
    printf("%d\n", soma);
    return;
  }
  else
  {
    soma += v[n - 1];
    funcaoC(v, n - 1, soma);
  }
}

void funcaoD(int v[], int n, int atual, float soma)
{
  if (atual == n)
  {
    printf("%f", soma);
    return;
  }
  else
  {
    soma += (float)v[atual] / (float)n;
    funcaoD(v, n, atual + 1, soma);
  }
}

void teste()
{
  int n;
  printf("1. Função A\n2. Função B\n3. Função C\n4. Função D\n0. Sair\n");
  printf("Digite a função que você deseja testar: ");
  scanf("%d", &n);
  while (n < 0 || n > 4)
  {
    printf("Erro: escolha um valor entre 0 e 4: ");
    scanf("%d", &n);
  }
  if (n == 0)
  {
    return;
  }
  else
  {
    int tamanho;
    printf("\nDigite o tamanho do vetor a ser utilizado: ");
    scanf("%d", &tamanho);
    int v[tamanho];
    for (int i = 0; i < tamanho; i++)
    {
      printf("Digite o %dº valor do vetor: ", i + 1);
      scanf("%d", &v[i]);
    }
    if (n == 1)
    {
      funcaoA(v, tamanho, 0);
    }
    else if (n == 2)
    {
      funcaoB(v, tamanho);
    }
    else if (n == 3)
    {
      funcaoC(v, tamanho, 0);
    }
    else if (n == 4)
    {
      funcaoD(v, tamanho, 0, 0);
    }
  }
}

int main()
{
  teste();
}
