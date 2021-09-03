#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 1 && s[0] == '0');
}

int idadeFilhoMaisVelho(char *s) {
  int i, monica, filho1, filho2, contador;
  i = monica = filho1 = filho2 = contador = 0;
  char idadeString[strlen(s)];

  // monica
  while (s[i] != ' ') {
    idadeString[contador] = s[i];
    i++; contador++;
    idadeString[contador] = '\0';
  }
  // printf("monica - %s\n", idadeString);

  i++;
  monica = atoi(idadeString);
  contador = 0;

  // filho1 
  while (s[i] != ' ') {
    idadeString[contador] = s[i];
    i++; contador++;
    idadeString[contador] = '\0';
  }
  // printf("filho1 - %s\n", idadeString);

  i++;
  filho1 = atoi(idadeString);
  contador = 0;

  // filho2
  while (i < strlen(s)) {
    idadeString[contador] = s[i];
    i++; contador++;
    idadeString[contador] = '\0';
  }
  // printf("filho2 - %s\n", idadeString);
  filho2 = atoi(idadeString);

  // filho3
  int filho3 = (monica - filho1) - filho2;
  // printf("filho3 - %d\n", filho3);

  // Encontrando o filho mais velho
  int filhoMaisVelho = filho1;

  if (filhoMaisVelho < filho2) {
    filhoMaisVelho = filho2;
  }
  if (filhoMaisVelho < filho3) {
    filhoMaisVelho = filho3;
  }

  return filhoMaisVelho;
}

int main() {
  int numEntrada = 0;
  char arrayStrings[2000][1000];

  do {
    fgets(arrayStrings[numEntrada], 1000, stdin); // Leitura da linha
    setbuf(stdin, NULL);
    arrayStrings[numEntrada][strcspn(arrayStrings[numEntrada], "\n")] =
        0; // Retira o caractere de '/n' do fim da string
  } while (isFim(arrayStrings[numEntrada++]) ==
           0); // Checa se a linha é igual a "FIM"
  numEntrada--;

  for (int i = 0; i < numEntrada; i++) {
    printf("%d\n", idadeFilhoMaisVelho(arrayStrings[i]));
  }
}

