#include <stdio.h>

int main()
{
  int cand1, cand2, cand3, cand4, nulos, branco, total;
  cand1 = cand2 = cand3 = cand4 = nulos = branco = total = 0;
  printf("----------ELEIÇÃO----------\n");
  printf("1, 2, 3, 4: Códigos dos respectivos candidatos;\n");
  printf("5: Voto nulo;\n");
  printf("6: Voto em branco;\n\n");

  while (1 == 1)
  {
    int voto;
    printf("Digite o voto: ");
    scanf("%d", &voto);
    if (voto == 0)
    {
      printf("---------------------------\n\n");
      printf("Votos do candidato 1: %d\n", cand1);
      printf("Votos do candidato 2: %d\n", cand2);
      printf("Votos do candidato 3: %d\n", cand3);
      printf("Votos do candidato 4: %d\n\n", cand4);
      printf("Votos nulos: %d\n", nulos);
      printf("Votos em branco: %d\n\n", branco);
      printf("Porcentagem de votos nulos sobre o total de votos: %.2lf%%\n", 100 * ((float)nulos / (float)total));
      printf("Porcentagem de votos em branco sobre o total de votos: %.2lf%%\n", 100 * ((float)branco / (float)total));
      return 0;
    }
    if (voto == 1)
    {
      cand1++;
      total++;
    }
    else if (voto == 2)
    {
      cand2++;
      total++;
    }
    else if (voto == 3)
    {
      cand3++;
      total++;
    }
    else if (voto == 4)
    {
      cand4++;
      total++;
    }
    else if (voto == 5)
    {
      nulos++;
      total++;
    }
    else if (voto == 6)
    {
      branco++;
      total++;
    }
    else
    {
      printf("Erro: voto inválido\n");
    }
  }
}