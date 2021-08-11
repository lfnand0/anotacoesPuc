#include <stdio.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

const char *isPalindromo(char *s) {
  int length = strlen(s);
    for (int i = 0; i < (length / 2); i++) {
      //Para cada caractere na frase, a condicional checa se o caractere "espelho" é diferente
      //Caso seja, a palavra não é um palíndromo.
      if (s[i] != s[length - i - 1]){
        return "NAO";
      }
    }
    return "SIM";
}

int main() {
  int numEntrada = 0;
  char arrayStrings[2000][1000];

  do {
    //scanf("%[^\n]%*c", arrayStrings[numEntrada]);
    fgets(arrayStrings[numEntrada], 1000, stdin);
    setbuf(stdin, NULL);
    arrayStrings[numEntrada][strcspn(arrayStrings[numEntrada], "\n")] = 0;
    if (isFim(arrayStrings[numEntrada + 2])) {
      printf(" -- %d -- ", numEntrada + 2);
    }
  } while (isFim(arrayStrings[numEntrada++]) == 0);
  numEntrada--;

  printf("depois\n");
  printf("%d\n", numEntrada);
  
  for (int i = 0; i < numEntrada; i++) {
    printf("%s\n", isPalindromo(arrayStrings[i]));
  }
}
