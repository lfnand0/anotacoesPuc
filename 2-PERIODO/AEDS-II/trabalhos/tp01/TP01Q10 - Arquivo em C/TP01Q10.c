#include <stdio.h>  
#include <string.h>

int main() {
  int n;
  scanf("%d\n", &n);

  FILE * arquivo = fopen("arq.txt", "wb"); // Abrindo em modo de escrita em binário;

  if (arquivo) {
    for (int i = 0; i < n; i++) {
      double num;
      scanf("%lf", &num);
      fwrite(&num, sizeof(double), 1, arquivo); // escreve num no arquivo
    }
  } else {
    printf("Erro\n"); // error handling
  }

  fclose(arquivo);

  arquivo = fopen("arq.txt", "rb"); // Abrindo em modo de leitura em binário

  if (arquivo) {
    for (int i = 0; i < n; i++) {
      fseek(arquivo, (n - 1 - i) * 8, SEEK_SET); // Cabeçote com offset de -8 bytes do fim do arquivo por cada iteração 
      double num;
      fread(&num, sizeof(double), 1, arquivo); // Lê o valor e salva na variável num

      int temp = num;
      if (num != temp) {
        // caso num == temp, num é um inteiro e, portanto, precisamos retornar apenas o número (sem casa decimal .0 no final)
        printf("%g\n", num);
      } else {
        printf("%d\n", temp);
      }
    } 
  } else {
    printf("Erro 2\n"); // error handling
  }

  fclose(arquivo);
}
