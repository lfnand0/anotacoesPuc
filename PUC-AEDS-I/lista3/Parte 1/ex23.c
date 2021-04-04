#include <stdio.h>

int main()
{
  printf("Menu de opções:\n1. Novo salário\n2. Férias\n3. Décimo terceiro\n4. Sair\n\n");
  printf("Digite a opção desejada.\n");
  int opcao;
  scanf("%d", &opcao);
  if (opcao == 4)
  {
    return 0;
  }
  else if (opcao == 1)
  {
    float salario, novoSalario;
    printf("\n----------NOVO SALÁRIO----------\n");
    printf("Digite seu salário atual: ");
    scanf("%f", &salario);
    if (salario < 210)
    {
      novoSalario = salario * 1.15;
    }
    else if (salario >= 210 && salario <= 600)
    {
      novoSalario = salario * 1.1;
    }
    else if (salario > 600)
    {
      novoSalario = salario * 1.05;
    }
    printf("NOVO SALÁRIO: R$%.2f", novoSalario);
    printf("\n--------------------------------\n");
    return 0;
  }
  else if (opcao == 2)
  {
    float salario, ferias;
    printf("\n----------FÉRIAS----------\n");
    printf("Digite seu salário atual: ");
    scanf("%f", &salario);
    ferias = salario + (salario / 3.0);
    printf("VALOR DAS FÉRIAS: R$%.2f", ferias);
    printf("\n--------------------------\n");
    return 0;
  }
  else if (opcao == 3)
  {
    printf("\n----------DÉCIMO TERCEIRO----------\n");
    float salario, decimoTerceiro, mesesTrabalho;
    printf("Digite seu salário atual: ");
    scanf("%f", &salario);
    printf("Digite a quantidade de meses trabalhados: ");
    scanf("%f", &mesesTrabalho);
    if (mesesTrabalho <= 0 || mesesTrabalho > 12)
    {
      printf("Erro: número de meses inválido.\n");
      return 0;
    }
    decimoTerceiro = (salario * mesesTrabalho) / 12.0;
    printf("DÉCIMO TERCEIRO: R$%.2f\n", decimoTerceiro);
    return 0;
  }
  else
  {
    printf("Erro: opção inválida.\n");
    return 0;
  }
}