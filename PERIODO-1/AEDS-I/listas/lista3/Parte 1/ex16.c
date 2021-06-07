#include <stdio.h>

int main()
{
  int total = 0, numeroDeIdades, idade;
  printf("Especifique a quantidade de idades que serão utilizadas: ");
  scanf("%d", &numeroDeIdades);
  int i;
  for (i = 1; i <= numeroDeIdades; i++)
  {
    printf("Digite a %dª idade: ", i);
    scanf("%d", &idade);
    if (idade < 0)
    {
      printf("Erro: a idade não pode ser negativa.\n");
      return 0;
    }
    total += idade;
  }
  printf("A média das idades é %.2f\n", (float)total / (float)numeroDeIdades);
}