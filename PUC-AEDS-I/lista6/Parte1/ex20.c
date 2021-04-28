#include <stdio.h>

void censo()
{
  float mediaFilhos, quantFamilias = 0, mediaSalarios, porcSalarioInf380, maiorSalario = 0, salario, filhos = 0;
  printf("Para finalizar o programa, digite um valor negativo para o número de filhos");
  while (filhos >= 0)
  {
    printf("\n-------------------\n");
    printf("Digite a quantidade de filhos da %.0fº família: ", quantFamilias + 1);
    scanf("%f", &filhos);
    if (filhos >= 0)
    {
      printf("Digite o salário da %.0fº família: ", quantFamilias + 1);
      scanf("%f", &salario);
      mediaFilhos += filhos;
      mediaSalarios += salario;
      salario < 380 ? porcSalarioInf380++ : 0;
      printf("debug: mediaInf = %f\n", porcSalarioInf380);
      salario > maiorSalario ? maiorSalario = salario : 0;
      quantFamilias++;
    }
  }
  mediaFilhos /= quantFamilias;
  mediaSalarios /= quantFamilias;
  porcSalarioInf380 /= quantFamilias;
  porcSalarioInf380 *= 100;
  printf("\n====================\n");
  printf("Média de filhos por família: %.2f\n", mediaFilhos);
  printf("Salário médio: R$%.2f\n", mediaSalarios);
  printf("Porcentagem de salários abaixo de 380: %.2f%%\n", porcSalarioInf380);
  printf("Maior salário: R$%.2f", maiorSalario);
  printf("\n====================\n");
}

int main()
{
  censo();
}