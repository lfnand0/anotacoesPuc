#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inputString(char v[]) {
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void juntarEOrdenarVetores(int v1[], int v2[]) {
  int *vResultante;
  int length1 = sizeof(v1), length2 = sizeof(v2);
  vResultante = calloc(length1 + length2, sizeof(int));

  int pos1 = 0, pos2 = 0;
  for (int i = 0; i < length1 + length2 - 1; i++) {
    if (v1[pos1] < v2[pos2]) {
      vResultante[i] = v1[pos1++];
    } else {
      vResultante[i] = v2[pos2++];
    }
    printf("vResultante[%d] = %d\n", i, vResultante[i]);
  }
  free(vResultante);

}

int main() {
  int v1[] = {1,3,5,7,9,10};
  int v2[] = {4, 9, 10, 123, 1};
  juntarEOrdenarVetores(v1, v2);
}