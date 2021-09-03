#include <stdio.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char *isPalindromo(char *s) {
  int length = strlen(s);
  for (int i = 0; i < (length / 2); i++) {
    // Para cada caractere na frase, a condicional checa se o caractere
    // "espelho" é diferente Caso seja, a palavra não é um palíndromo.
    if (s[i] != s[length - i - 1]) {
      return "NAO";
    }
  }
  return "SIM";
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
    printf("%s\n", isPalindromo(arrayStrings[i]));
  }
}
