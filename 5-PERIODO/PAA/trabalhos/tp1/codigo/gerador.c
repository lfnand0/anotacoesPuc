#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void gerar(char *arq, int rows, int cols) {
    FILE *fp = fopen(arq, "wb");
    unsigned char *arr;
    // printf("%d\n", rows * (cols + 1));
    if (fp && (arr = (unsigned char *)malloc((long)rows * (cols + 1)))) {
        int pos = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                unsigned char random = (unsigned char)rand();
                arr[pos++] = random;
                // printf("%d\n", (int)random);
            }
        }
        
        fwrite(arr, sizeof(unsigned char), pos, fp);
    }

    fclose(fp);
}

int main(int argc, char **argv) {
    if (argc < 2)
    {
        return 0;
    }

    srand((unsigned)time(NULL));

    // argv[1] = nome do arquivo
    int rows = atoi(argv[2]);
    int cols = atoi(argv[3]);
    gerar(argv[1], rows, cols);
}
