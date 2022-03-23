#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// questao 1
typedef struct numero {
  int qapi, qapf;
  int *parteinteira;
  int *partefracionaria;
} _numero;

void criarnumero(int qapi, int qapf, int inteira, int fracionaria, _numero *n) {
  n->parteinteira = (int *)malloc((qapi + 1) * sizeof(int));
  n->partefracionaria = (int *)malloc((qapf + 1) * sizeof(int));

  n->qapi = qapi;
  n->qapf = qapf;

  int temp = inteira;
  for (int i = 0; i < qapi; i++) {
    n->parteinteira[qapi - (i + 1)] = temp % 10;
    temp -= temp % 10;
    temp /= 10;
  }

  temp = fracionaria;
  for (int i = 0; i < qapf; i++) {
    n->partefracionaria[qapf - (i + 1)] = temp % 10;
    temp -= temp % 10;
    temp /= 10;
  }
}

struct numero somar(_numero *a, _numero *b) {
  _numero num;
  int pf = a->qapf, pi = a->qapi;

  int inteira = 0, fracionaria = 0, max = 9, expoente = 1;
  for (int i = pf - 1; i >= 0; i--) {
    fracionaria += (a->partefracionaria[i] + b->partefracionaria[i]) * expoente;
    expoente *= 10;
    max *= 10;
    max += 9;
  }
  max /= 10;

  expoente = 1;
  for (int i = pi - 1; i >= 0; i--) {
    inteira += (a->parteinteira[i] + b->parteinteira[i]) * expoente;
    expoente *= 10;

    if (i == pi - 1 && fracionaria > max) {
      inteira += 1;
    }
  }

  inteira = inteira % expoente;

  criarnumero(pi, pf, inteira, fracionaria, &num);

  return num;
}

void printar(int pos, _numero *n) {
  if (pos - n->qapi == 0 && n->qapf != 0) {
    printf(".");
  }

  if (pos >= n->qapi) {
    if (pos - n->qapi < n->qapf) {
      printf("%d", n->partefracionaria[pos - n->qapi]);
      printar(pos + 1, n);
    }
  } else {
    printf("%d", n->parteinteira[pos]);
    printar(pos + 1, n);
  }

  if (pos == n->qapi + n->qapf) {
    printf("\n");
  }
}

void preencher(int length, _numero n[length]) {
  for (int l = 0; l < length; l++) {
    printf("\n-----NÚMERO %d------\n", l + 1);
    int qapi, qapf;
    int inteira, fracionaria;
    printf("Digite o tamanho da parte inteira: ");
    scanf("%d", &qapi);

    printf("Digite o tamanho da parte fracionária: ");
    scanf("%d", &qapf);

    printf("Digite a parte inteira com %d algorismo(s): ", qapi);
    scanf("%d", &inteira);

    int check = 1;
    while (check == 1) {
      int min = 1;
      int max = 9;
      for (int i = 1; i < qapi; i++) {
        min *= 10;
        max *= 10;
        max += 9;
      }

      if (inteira >= min && inteira <= max) {
        check = 0;
      } else {
        printf("Erro: seu número não possui %d algorismo(s). ", qapi);
        printf("Digite outro número: ");
        scanf("%d", &inteira);
      }
    }

    printf("Digite a parte fracionária com %d algorismo(s): ", qapf);
    scanf("%d", &fracionaria);

    check = 1;
    while (check == 1) {
      int min = 1;
      int max = 9;
      for (int i = 1; i < qapf; i++) {
        min *= 10;
        max *= 10;
        max += 9;
      }

      if (fracionaria >= min && fracionaria <= max) {
        check = 0;
      } else {
        printf("Erro: seu número não possui %d algorismo(s). ", qapf);
        printf("Digite outro número: ");
        scanf("%d", &fracionaria);
      }
    }

    criarnumero(qapi, qapf, inteira, fracionaria, &n[l]);
    // printar(0, &n[l]);
  }
}

int main() {
  int n;
  printf("Digite quantos números você deseja criar: ");
  scanf("%d", &n);

  _numero num[n];
  preencher(n, &*num);

  _numero soma = somar(&num[0], &num[1]);
  for (int i = 2; i < n; i++) {
    soma = somar(&soma, &num[i]);
  }

  printf("\nSOMA: ");
  printar(0, &soma);
}
