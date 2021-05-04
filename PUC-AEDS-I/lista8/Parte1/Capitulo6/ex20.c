#include <stdio.h>

int main() {
  int v1[10], v2[10];

  for (int i = 0; i < 10; i++) {
    printf("Digite o %dº valor do primeiro vetor: ", i + 1);
    scanf("%d", &v1[i]);
  }
  for (int i = 0; i < 10; i++) {
    printf("Digite o %dº valor do segundo vetor: ", i + 1);
    scanf("%d", &v2[i]);
  }

  for (int i = 0; i < 20; i++) {
    if (i < 10) {
      if (v1[i] > 0) {
        printf("%d, ", v1[i]);
      }
    } else {
      if (v2[i - 10] > 0) {
        printf("%d, ", v2[i - 10]);
      }
    }
  }
  printf("\n");
}
