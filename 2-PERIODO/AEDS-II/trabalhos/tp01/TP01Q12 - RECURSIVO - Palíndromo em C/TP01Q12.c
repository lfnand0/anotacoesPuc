#include <stdio.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char *isPalindromo(char *s, int pos) {
  int length = strlen(s);
  // O algoritmo checa se a posição "pos" é igual ao seu espelho (length - pos - 1)
  //  caso não seja é retornado NAO, caso seja, checamos a próxima posição
  // Caso a posição seja maior ou igual a metade do tamanho da string, quer d
  // zer que não precisamos mais checar
  if (pos >= length / 2) {
    return "SIM";
  }

  if (s[pos] != s[length - pos - 1]) {
    return "NAO";
  }

  return isPalindromo(s, pos + 1);
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
    printf("%s\n", isPalindromo(arrayStrings[i], 0));
  }
}
