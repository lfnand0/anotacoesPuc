#include <stdio.h>
#include <stdlib.h>

void imprimirArquivo(char v[])
{
    FILE *fp;
    fp = fopen(v, "r");
    char c = fgetc(fp);
    printf("Conteúdo do arquivo '%s': ", v);
    while (c != EOF)
    {
        printf("%c", c);
        c = fgetc(fp);
    }
    fclose(fp);
}

void criptografar(char v[])
{
    FILE *fpRead, *fpWrite;

    // abre arquivo ASCII, para escrita
    fpRead = fopen(v, "r");
    fpWrite = fopen("cript.txt", "w");
    if (!fpRead)
    {
        printf("Erro na abertura do arquivo\n");
        exit(0);
    }

    char c = fgetc(fpRead);
    while (c != EOF)
    {
        c++;
        fputc(c, fpWrite);
        c = fgetc(fpRead);
    }
    printf("\nArquivo '%s' criptografado com sucesso.\n", v);
    fclose(fpRead);
    fclose(fpWrite);

    imprimirArquivo("cript.txt");
}

void decriptar(char v[])
{
    FILE *fpRead, *fpWrite;

    // abre arquivo ASCII, para escrita
    fpRead = fopen(v, "r");
    fpWrite = fopen("decript.txt", "w");
    if (!fpRead)
    {
        printf("Erro na abertura do arquivo\n");
        exit(0);
    }

    char c = fgetc(fpRead);
    while (c != EOF)
    {
        c--;
        fputc(c, fpWrite);
        c = fgetc(fpRead);
    }
    printf("\nArquivo '%s' decriptado com sucesso.\n", v);
    fclose(fpRead);
    fclose(fpWrite);

    imprimirArquivo("decript.txt");
}

int main()
{
    criptografar("arquivo.txt");
    decriptar("cript.txt");
}
