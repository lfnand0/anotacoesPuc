#include <stdio.h>
#include <string.h>

int isFim(char *s) {
  int length = strlen(s);
  return (length == 1 && s[0] == '0');
}

int cometa(char *s) {
  int i, anoAtual, proximoAno = 1986;
  i = anoAtual = 0;
  while (i < strlen(s)) {
    anoAtual = (anoAtual * 10) + (s[i] - '0');
    i++;
  }
  if ((anoAtual - 1986) % 76 == 0) {
    proximoAno = anoAtual + 76;
  } else {
    while (proximoAno < anoAtual) {
      proximoAno += 76;
    }
  }
  return proximoAno;
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
    printf("%d\n", cometa(arrayStrings[i]));
  }
}
