#include <stdio.h>

int main()
{
  int v[10], v2[5], tamanhoPar, tamanhoImpar;
  printf("PRIMEIRO VETOR: \n");
  for (int i = 0; i < 10; i++)
  {
    printf("Digite o %dº elemento do vetor: ", i + 1);
    scanf("%d", &v[i]);
  }

  printf("\n\nSEGUNDO VETOR: \n");
  for (int i = 0; i < 5; i++)
  {
    printf("Digite o %dº elemento do vetor: ", i + 1);
    scanf("%d", &v2[i]);
  }

  tamanhoPar = tamanhoImpar = 0;
  for (int i = 0; i < 10; i++)
  {
    v[i] % 2 == 0 ? tamanhoPar++ : tamanhoImpar++;
    // esses valores serão utilizados para o tamanho dos vetores do resultado
  }
  int vResult1[tamanhoPar], vResult2[tamanhoImpar], contPar, contImpar;
  contPar = contImpar = 0;

  for (int i = 0; i < 10; i++)
  {
    if (v[i] % 2 == 0)
    {
      vResult1[contPar] = v[i];
      for (int j = 0; j < 5; j++)
      {
        vResult1[contPar] += v2[j];
      }
      contPar++;
    }
    else
    {
      int contDivisores = 0;
      vResult2[contImpar] = v[i];
      for (int j = 0; j < 5; j++)
      {
        if (vResult2[contImpar] % v2[j] == 0)
        {
          contDivisores++;
        }
      }
      vResult2[contImpar] = contDivisores;
      contImpar++;
    }
  }

  printf("\nPrimeiro vetor resultante:\n");
  for (int i = 0; i < tamanhoPar; i++)
  {
    printf("%d, ", vResult1[i]);
  }

  printf("\n\nSegundo vetor resultante:\n");
  for (int i = 0; i < tamanhoImpar; i++)
  {
    printf("%d, ", vResult2[i]);
  }
  printf("\n");
}
