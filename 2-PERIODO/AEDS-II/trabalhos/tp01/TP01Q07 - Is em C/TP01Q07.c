#include <stdio.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int isVogal(char *s) {
  int resposta = 1;
  int length = strlen(s);
  for (int i = 0; i < length; i++) {
    int x = s[i];
    // Caso o caractere não seja uma vogal, a string não é composta apenas de vogais
    if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u' && x != 'A' &&
        x != 'E' && x != 'I' && x != 'O' && x != 'U') {
      resposta = 0;
      i = length;
    }
  }

  return resposta;
}

int isConsoante(char *s) {
  int resposta = 1;
  int length = strlen(s);
  for (int i = 0; i < length; i++) {
    int x = s[i];
    // Caso o caractere seja igual a uma vogal ou a algum caractere não alfabético, a string não é composta apenas de consoantes
    if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' || x == 'A' ||
        x == 'E' || x == 'I' || x == 'O' || x == 'U' ||
        !((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z'))) {
      resposta = 0;
      i = length;
    }
  }

  return resposta;
}

int isInteiro(char *s) {
  int resposta = 1;
  int length = strlen(s);
  for (int i = 0; i < length; i++) {
    int x = s[i];
    // Caso o caractere seja composto de algo diferente de um número, ele não será um número inteiro
    if (x < '0' || x > '9') {
      resposta = 0;
      i = length;
    }
  }

  return resposta;
}

int isReal(char *s) {
  int resposta = 1;
  int length = strlen(s);
  int numeroDePontos = 0;
  for (int i = 0; i < length; i++) {
    int x = s[i];
    // Nesse caso, o caractere pode possuir um ponto ou uma vírgula, porém não mais que uma
    if (((x < '0' || x > '9') && x != '.' && x != ',') || numeroDePontos > 1) {
      resposta = 0;
      i = length;
    }

    if (x == '.' || x == ',') {
      numeroDePontos++;
    }
  }

  return resposta;
}

void makeLine(char *s) {
  // Essa função printa as strings de acordo com o que é retornado ao executar as funções
  if (isVogal(s)) {
    printf("SIM ");
  } else {
    printf("NAO ");
  }

  if (isConsoante(s)) {
    printf("SIM ");
  } else {
    printf("NAO ");
  }

  if (isInteiro(s)) {
    printf("SIM ");
  } else {
    printf("NAO ");
  }

  if (isReal(s)) {
    printf("SIM\n");
  } else {
    printf("NAO\n");
  }
}

int main() {
  int numEntrada = 0;
  char arrayStrings[2000][1000];

  do {
    fgets(arrayStrings[numEntrada], 1000, stdin); // Leitura da linha
    setbuf(stdin, NULL);
    arrayStrings[numEntrada][strcspn(arrayStrings[numEntrada], "\n")] = 0; // Retira o caractere de '/n' do fim da string
  } while (isFim(arrayStrings[numEntrada++]) == 0); // Checa se a linha é igual a "FIM"
  numEntrada--;

  for (int i = 0; i < numEntrada; i++) {
    makeLine(arrayStrings[i]);
  }
}
