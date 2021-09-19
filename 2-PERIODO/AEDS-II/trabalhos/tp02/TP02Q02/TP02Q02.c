#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Serie
{
  char nome[100];
  char formato[100];
  char duracao[100];
  char paisDeOrigem[100];
  char idioma[100];
  char emissora[100];
  char transmissao[100];
  int numeroDeTemporadas;
  int numeroDeEpisodios;
};

int isFim(char *s)
{
  int length = strlen(s);
  return (length == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char *removeTags(char *s)
{
  char *retorno = (char *)malloc(10 * sizeof(s));
  int pos = 0;

  for (int i = 0; i < strlen(s); i++)
  {
    if (s[i] == '<')
    {
      while (s[i] != '>' && i < strlen(s))
      {
        i++;
      }
    }
    else if (i + 5 < strlen(s) && s[i] == '&' && s[i + 1] == '#' && s[i + 2] == '1' && s[i + 3] == '6' && s[i + 4] == '0' && s[i + 5] == ';')
    {
      i += 5; // Retirando "&#160;" da string
    }
    else if (i + 5 < strlen(s) && s[i] == '&' && s[i + 1] == 'n' && s[i + 2] == 'b' && s[i + 3] == 's' && s[i + 4] == 'p' && s[i + 5] == ';')
    {
      i += 5; // Retirando "&nbsp;" da string
    }
    else
    {
      if (s[i] != '\n')
      { // Retirando "\n" da string
        retorno[pos] = s[i];
        retorno[pos + 1] = '\0';
        pos++;
      }
    }
  }

  return retorno;
}

int main()
{
  int numEntrada = 0;
  char arrayStrings[1000][1000];

  do
  {
    fgets(arrayStrings[numEntrada], 1000, stdin); // Leitura da linha
    setbuf(stdin, NULL);
    arrayStrings[numEntrada][strcspn(arrayStrings[numEntrada], "\n")] =
        0; // Retira o caractere de '/n' do fim da string
  } while (isFim(arrayStrings[numEntrada++]) ==
           0); // Checa se a linha é igual a "FIM"
  numEntrada--;

  struct Serie series[numEntrada];
  for (int i = 0; i < numEntrada; i++)
  {
    char diretorio[50] = "/tmp/series/";
    strcat(diretorio, arrayStrings[i]);

    FILE *fp;
    if ((fp = fopen(diretorio, "r")) == NULL)
    {
      // Captura de erro
      printf("Erro: fopen (%s)\n", diretorio);
    }
    else
    {
      char nome[50];
      for (int j = 0; j < strlen(arrayStrings[i]) && arrayStrings[i][j] != '.';
           j++)
      {
        if (arrayStrings[i][j] == '_')
        {
          nome[j] = ' ';
        }
        else
        {
          nome[j] = arrayStrings[i][j];
        }
        nome[j + 1] = '\0';
      }
      strcpy(series[i].nome, nome);

      char linha[2000];
      fgets(linha, 2000, fp);

      // Realiza a leitura linha por linha até encontrar as palavras chaves
      while (strstr(linha, "Formato") == NULL)
      {
        fgets(linha, 2000, fp);
        // printf("dbg %s\n", linha);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].formato, removeTags(linha));

      while (strstr(linha, "Duração") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].duracao, removeTags(linha));

      while (strstr(linha, "País de origem") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].paisDeOrigem, removeTags(linha));

      while (strstr(linha, "Idioma original") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].idioma, removeTags(linha));

      while (strstr(linha, "Emissora de televisão original") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].emissora, removeTags(linha));

      while (strstr(linha, "Transmissão original") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(series[i].transmissao, removeTags(linha));

      while (strstr(linha, "N.º de temporadas") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      char aux[50];
      strcpy(aux, removeTags(linha));
      series[i].numeroDeTemporadas = (int)strtol(aux, NULL, 10);

      while (strstr(linha, "N.º de episódios") == NULL)
      {
        fgets(linha, 2000, fp);
      }
      fgets(linha, 2000, fp);
      strcpy(aux, removeTags(linha));
      series[i].numeroDeEpisodios = (int)strtol(aux, NULL, 10);
    }
  }

  for (int i = 0; i < numEntrada; i++)
  {
    // Imprimindo resultados
    printf("%s %s %s %s %s %s %s %d %d\n", series[i].nome, series[i].formato,
           series[i].duracao, series[i].paisDeOrigem, series[i].idioma,
           series[i].emissora, series[i].transmissao,
           series[i].numeroDeTemporadas, series[i].numeroDeEpisodios);
  }
}
