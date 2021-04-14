#include <stdio.h>

int main() {
  int programa, quantVotos1, quantVotos2, quantVotos3, totalVoiceM, totalFaustao;
  float mediaIdadesVoiceM, porcentFaustao1828;
  programa = quantVotos1 = quantVotos2 = quantVotos3 = totalVoiceM = totalFaustao = mediaIdadesVoiceM = porcentFaustao1828 = 0;
  while (programa != 4) {
    int idade, sexo;
    printf("\n1 - Domingão do Faustão\n2 - Luciano Hulk\n3 - The Voice Brasil\n4 - Sair\n");
    printf("Escolha um programa: ");
    scanf("%d", &programa);
    if (programa != 4) {
      while (programa < 1 || programa > 4) {
        printf("Opção inválida!\n");
        printf("Escolha um programa: ");
        scanf("%d", &programa);
      }
      // inputs
      printf("Digite a idade: ");
      scanf("%d", &idade);
      while (idade < 0 || idade > 150) {
        printf("Opção inválida!\n");
        printf("Digite a idade: ");
        scanf("%d", &idade);
      }

      printf("1- Feminino\n2- Masculino\nDigite o sexo: ");
      scanf("%d", &sexo);
      while (sexo != 1 && sexo != 2) {
        printf("Opção inválida!\n");
        printf("Digite o sexo: ");
        scanf("%d", &sexo);
      }

      // calculando os resultados
      if (sexo == 1) {
        if (programa == 1) {
          quantVotos1++;
        } else if (programa == 2) {
          quantVotos2++;
        } else if (programa == 3) {
          quantVotos3++;
        }
      }

      if (sexo == 2) {
        if (programa == 3) {
          totalVoiceM++;
          mediaIdadesVoiceM += idade;
        }
      }

      if (programa == 1) {
        totalFaustao++;
        if (idade >= 18 && idade <= 28) {
          porcentFaustao1828++;
        }
      }
    }
  }
  // RESULTADOS
  printf("\n================================");
  if (quantVotos1 > quantVotos2 && quantVotos1 > quantVotos3) {
    printf("\nO programa de tv que teve maior número de votos femininos foi Domingão do faustão.\n");
  } else if (quantVotos2 > quantVotos1 && quantVotos2 > quantVotos3) {
    printf("\nO programa de tv que teve maior número de votos femininos foi Luciano Hulk.\n");
  } else if (quantVotos3 > quantVotos2 && quantVotos3 > quantVotos1) {
    printf("\nO programa de tv que teve maior número de votos femininos foi The Voice Brasil.\n");
  } else {
    printf("\nHouve um empate entre os programas com maior número de votos femininos.\n");
  }
  if (totalVoiceM != 0) {
    mediaIdadesVoiceM /= (float) totalVoiceM;
    printf("A média das idades dos telespectadores do programa The Voice Brasil (considerando apenas o sexo masculino) é %.1f.\n", mediaIdadesVoiceM);
  } else {
    printf("Como The Voice Brasil não teve telespectadores do sexo masculino, não foi possível calcular a média de idades.\n");
  }

  if (totalFaustao != 0) {
    porcentFaustao1828 /= totalFaustao;
    porcentFaustao1828 *= 100;
    printf("A porcentagem de telespectadores do Domingão do Faustão com idade entre 18 e 28 anos é %.4f%%.\n", porcentFaustao1828);
  } else {
    printf("Como Domingão do Faustão não teve telespectadores, não foi possível calcular a porcentagem de pessoas com idade entre 18 e 28 anos.\n");
  }
  printf("================================\n");
}