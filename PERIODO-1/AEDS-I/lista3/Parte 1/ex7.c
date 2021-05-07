#include <stdio.h>

// porcentagemPeso = porcentagem de pessoas com peso inferior a 40kg
// num10_20anos = número de pessoas com idade de 10 a 20 anos
// somaAltura10_20anos = soma da altura de pessoas com idade de 10 a 20 anos
// idade50 = quantidade de pessoas com idade superior a 50 a nos

int main()
{
  double peso, altura, porcentagemPeso, somaAltura10_20anos, num10_20anos, idade, idade50;
  porcentagemPeso = somaAltura10_20anos = num10_20anos = idade50 = 0;
  int i = 1;
  while (i < 6)
  {
    printf("Digite a idade, o peso (em kg) e a altura (em metros) da %dª pessoa: ", i);
    scanf("%lf %lf %lf", &idade, &peso, &altura);
    idade > 50 ? idade50++ : idade50;
    idade >= 10 && idade <= 20 ? num10_20anos++, somaAltura10_20anos += altura : num10_20anos;
    peso < 40 ? porcentagemPeso += 20 : porcentagemPeso;
    i++;
  }
  printf("\nA quantidade de pessoas com idade superior a 50 é %d\n", (int)idade50);
  printf("A média das alturas das pessoas com idade entre 10 e 20 anos é %.02lf metros\n", somaAltura10_20anos / num10_20anos);
  printf("A porcentagem de pessoas com peso inferior a 40kg é de %d%%\n", (int)porcentagemPeso);
}