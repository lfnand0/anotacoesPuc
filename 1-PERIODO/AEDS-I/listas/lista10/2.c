#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

void criptografar(char v[], int chave)
{
  FILE *fpRead, *fpWrite;

  // abre arquivo ASCII, para escrita
  fpRead = fopen(v, "r");
  fpWrite = fopen("cript2.txt", "w");
  if (!fpRead)
  {
    printf("Erro na abertura do arquivo\n");
    exit(0);
  }

  char c = fgetc(fpRead);
  while (c != EOF)
  {
    c += chave;
    fputc(c, fpWrite);
    c = fgetc(fpRead);
  }
  printf("\nArquivo '%s' criptografado com sucesso.\n", v);
  fclose(fpRead);
  fclose(fpWrite);

  imprimirArquivo("cript2.txt");
}

void decriptar(char v[], int chave)
{
  FILE *fpRead, *fpWrite;

  // abre arquivo ASCII, para escrita
  fpRead = fopen(v, "r");
  fpWrite = fopen("decript2.txt", "w");
  if (!fpRead)
  {
    printf("Erro na abertura do arquivo\n");
    exit(0);
  }

  char c = fgetc(fpRead);
  while (c != EOF)
  {
    c -= chave;
    fputc(c, fpWrite);
    c = fgetc(fpRead);
  }
  printf("\nArquivo '%s' decriptado com sucesso.\n", v);
  fclose(fpRead);
  fclose(fpWrite);

  imprimirArquivo("decript2.txt");
}

int main(int argc, char *argv[])
{
  if (argc > 2)
  {
    printf("Erro: utilize apenas um argumento\n");
    return 0;
  }
  else if (argc < 2)
  {
    printf("Erro: digite a chave como argumento na hora de executar\n");
    return 0;
  }
  else
  {
    int chave = atoi(argv[1]);
    criptografar("arquivo.txt", chave);
    decriptar("cript2.txt", chave);
  }
}