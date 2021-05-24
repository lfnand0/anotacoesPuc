#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void ocorrenciaLetra(char v[], char letra) {
  int length = strlen(v);
  int ocorre = 0;
  for (int i = 0; i < length; i++) {
    if (v[i] == letra) {
      ocorre = 1; 
    }
  }
  if (ocorre == 1) {
    int primeiraOcorrencia = -1, ultimaOcorrencia = -1;

    for (int i = 0; i < length; i++) {
      if (v[i] == letra && primeiraOcorrencia == -1) {
        primeiraOcorrencia = i;
      }
      if (v[length - i - 1] == letra && ultimaOcorrencia == -1) {
        ultimaOcorrencia = length - i - 1;
      }
    }

    if (primeiraOcorrencia == ultimaOcorrencia) {
      printf("A única ocorrência da letra '%c' é na posição %d\n", letra, primeiraOcorrencia);
    } else {
      printf("A primeira ocorrência da letra '%c' é na posição %d, e a última é na posição %d\n", letra, primeiraOcorrencia, ultimaOcorrencia);
    }
  } else {
    printf("A letra '%c' não ocorre na frase.\n", letra);
  }
}

int main() {
  char v[256], letra;
  inputString(v);
  printf("Digite uma letra: ");
  scanf(" %c", &letra);
  ocorrenciaLetra(v, letra);
}
