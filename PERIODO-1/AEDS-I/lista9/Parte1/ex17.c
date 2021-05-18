#include <stdio.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
}

void imprimirString(char v[]) {
  for (int i = 0; i < strlen(v); i++) {
    printf("%c", v[i]);
  }
  printf("\n");
}

void removerEspacoInicio(char v[]) {
  int length = strlen(v), posicao = 0, inicio = 0;
  char vOriginal[strlen(v)];
  strcpy(vOriginal, v);
  for (int i = 0; i < length; i++) {
    v[i] = 0;
    if (vOriginal[i] != ' ' && inicio == 0) {
      inicio = 1;
    }
    if (inicio == 1) {
      v[posicao] = vOriginal[i];
      posicao++;
    }
  }  
}

void removerEspacoFinal(char v[]) {
  int length = strlen(v), posicao = 0, fim = 0;
  char vOriginal[strlen(v)];
  strcpy(vOriginal, v);
  for (int i = 0; i < 256; i++) {
    v[i] = 0; // limpando o vetor
  }
  for (int i = length - 2; i >= 0; i--) {
    if (vOriginal[i] != ' ' && fim == 0) {
      fim = i;
    }
  }
  for (int i = 0; i <= fim; i++) {
    v[i] = vOriginal[i];
  }
  v[fim + 1] = '\0';
}

void removerEspacosDuplos(char v[]) {
  int length = strlen(v);
  for (int i = 0; i < length; i++) {
    if (v[i] == ' ' && v[i + 1] == ' ') {
      for (int j = i + 1; j < length - 1; j++) {
        v[j] = v[j + 1];
      }
      i--;
      v[length] = v[length - 1] = 0;
      length--;
    }
  }
}

void inverterString(char v[]) {
  int length = strlen(v);
  for (int i = 0; i < length / 2; i++) {
    char temp = v[i];
    v[i] = v[length - i - 1];
    v[length - i - 1] = temp;
  }
}

// NÃO ESTÁ FUNCIONANDO (ainda)
void criptografarString(char v[]) {
  char vMod[256], p1[256], p2[256];
  for (int k = 0; k < 256; k++) {
    p1[k] = 0;
    p2[k] = 0;
    vMod[k] = 0;
  }

  removerEspacosDuplos(v);
  removerEspacoFinal(v);
  removerEspacoInicio(v);

  int length = strlen(v), posPalavra = 0, posMod = 0;
  // posMod = posicionamento no vetor resultante,  posPalavra = posicionamento dos vetores p1 e p2;
  for (int i = 0; i <= length; i++) {
    if (v[i] != ' ' && v[i] != '\n' && v[i] != '\0') {
      p1[posPalavra] = v[i];
      p1[posPalavra + 1] = '\0';
      posPalavra++;
    } else if (v[i] == '\0') {
      for (int j = 0; j < strlen(p1); j++) {
        inverterString(p1);
        vMod[posMod] = p1[j];
        vMod[posMod + 1] = '\0';
        posMod++;
      }
    } else {
      posPalavra = 0;
      for (int j = i + 1; j <= length; j++) {
        if (v[j] != ' ' && v[j] != '\n' && v[j] != '\0') {
          p2[posPalavra] = v[j];
          p2[posPalavra + 1] = '\0';
          posPalavra++;
        } else { // nesse momento teremos duas palavras
          inverterString(p2);
          int length1 = strlen(p1), length2 = strlen(p2);
          // printf("DEBUG: p1[3] = %d e p1[4] = %d\n", p1[3], p1[4]);
          // printf("DEBUG: strlen(p1) = %d\n", length2);
          for (int k = 0; k < (length1 > length2 ? length1 : length2); k++) {
            printf("DEBUG: p1[%d] = %d\n", k, p1[k]);
            printf("DEBUG: p2[%d] = %d\n", k, p2[k]);
            if (p1[k] != 0){ // checando se p1[k] é um caractere válido
              vMod[posMod] = p1[k];
              vMod[posMod + 1] = '\0';
              posMod++;
            }
            if (p2[k] != 0) {
              vMod[posMod] = p2[k];
              vMod[posMod + 1] = '\0';
              posMod++;
            }
          }
        }
      }
      posPalavra = 0;
      vMod[posMod] = ' ';
      posMod++;
      // limpando vetores
      for (int k = 0; k < 256; k++) {
        p1[k] = 0;
        p2[k] = 0;
      }
    }
  
  }
  strcpy(v, vMod);
}

int main() {
  char v[256];
  inputString(v);
  criptografarString(v);
  imprimirString(v);
}