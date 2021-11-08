#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_FIELD_SIZE 100

typedef struct
{
  char nome[MAX_FIELD_SIZE];
  char formato[MAX_FIELD_SIZE];
  char duracao[MAX_FIELD_SIZE];
  char pais[MAX_FIELD_SIZE];
  char idioma[MAX_FIELD_SIZE];
  char emissora[MAX_FIELD_SIZE];
  char transmissao[MAX_FIELD_SIZE];
  int num_temporadas;
  int num_episodios;
} Serie;

char *remove_line_break(char *line)
{
  while (*line != '\r' && *line != '\n')
    line++;
  *line = '\0';
  return line;
}

char *freadline(char *line, int max_size, FILE *file)
{
  return remove_line_break(fgets(line, max_size, file));
}

char *readline(char *line, int max_size)
{
  return freadline(line, max_size, stdin);
}

void print_serie(Serie *serie)
{
  printf("%s %s %s %s %s %s %s %d %d\n",
         serie->nome,
         serie->formato,
         serie->duracao,
         serie->pais,
         serie->idioma,
         serie->emissora,
         serie->transmissao,
         serie->num_temporadas,
         serie->num_episodios);
}

// Retorna o tamanho em bytes de um arquivo.
long tam_arquivo(FILE *file)
{
  fseek(file, 0L, SEEK_END);
  long size = ftell(file);
  rewind(file);
  return size;
}

// Retorna todo o conteúdo do arquivo numa string.
char *ler_html(char filename[])
{
  FILE *file = fopen(filename, "r");
  if (!file)
  {
    fprintf(stderr, "Falha ao abrir arquivo %s\n", filename);
    exit(1);
  }
  long tam = tam_arquivo(file);
  char *html = (char *)malloc(sizeof(char) * (tam + 1));
  fread(html, 1, tam, file);
  fclose(file);
  html[tam] = '\0';
  return html;
}

/**
 * @brief Extrai os textos de uma tag html.
 * 
 * @param html Ponteiro para o caractere que abre a tag '<'.
 * @param texto Ponteiro para onde o texto deve ser colocado.
 * 
 * @return Ponteiro para o texto extraído.
 */
char *extrair_texto(char *html, char *texto)
{
  char *start = texto;
  int contagem = 0;
  while (*html != '\0')
  {
    if (*html == '<')
    {
      if (
          (*(html + 1) == 'p') ||
          (*(html + 1) == 'b' && *(html + 2) == 'r') ||
          (*(html + 1) == '/' && *(html + 2) == 'h' && *(html + 3) == '1') ||
          (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'h') ||
          (*(html + 1) == '/' && *(html + 2) == 't' && *(html + 3) == 'd'))
        break;
      else
        contagem++;
    }
    else if (*html == '>')
      contagem--;
    else if (contagem == 0 && *html != '"')
    {
      if (*html == '&')
        html = strchr(html, ';');
      else if (*html != '\r' && *html != '\n')
        *texto++ = *html;
    }
    html++;
  }
  *texto = '\0';
  return *start == ' ' ? start + 1 : start;
}

/**
 * @brief Lê o HTML da série e popula os campos da struct.
 * 
 * @param serie Struct Serie que vai receber os dados.
 * @param html String contendo todo o HTML do arquivo.
 */
void ler_serie(Serie *serie, char *html)
{
  char texto[MAX_FIELD_SIZE];

  char *ptr = strstr(html, "<h1");
  extrair_texto(ptr, texto);

  char *parenteses_ptr = strchr(texto, '(');
  if (parenteses_ptr != NULL)
    *(parenteses_ptr - 1) = '\0';

  strcpy(serie->nome, texto);

  ptr = strstr(ptr, "<table class=\"infobox_v2\"");

  ptr = strstr(ptr, "Formato");
  ptr = strstr(ptr, "<td");
  strcpy(serie->formato, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "Duração");
  ptr = strstr(ptr, "<td");
  strcpy(serie->duracao, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "País de origem");
  ptr = strstr(ptr, "<td");
  strcpy(serie->pais, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "Idioma original");
  ptr = strstr(ptr, "<td");
  strcpy(serie->idioma, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "Emissora de televisão original");
  ptr = strstr(ptr, "<td");
  strcpy(serie->emissora, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "Transmissão original");
  ptr = strstr(ptr, "<td");
  strcpy(serie->transmissao, extrair_texto(ptr, texto));

  ptr = strstr(ptr, "N.º de temporadas");
  ptr = strstr(ptr, "<td");
  sscanf(extrair_texto(ptr, texto), "%d", &serie->num_temporadas);

  ptr = strstr(ptr, "N.º de episódios");
  ptr = strstr(ptr, "<td");
  sscanf(extrair_texto(ptr, texto), "%d", &serie->num_episodios);
}

#define MAX_LINE_SIZE 250
#define PREFIXO "/tmp/series/"
// #define PREFIXO "../entrada e saida/tp02/series/"

int isFim(char line[])
{
  return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
}

void matricula(int compareCounter, int swapCounter, float time)
{
  FILE *fp = fopen("matrícula_countingsort.txt", "w");
  fprintf(fp, "727245\t%d\t%d\t%f ", compareCounter, swapCounter, time);
}

/** 
 * Função auxiliar para tratar a string antes de realizar a comparação, útil para evitar
 * problemas como espaços no fim de uma string, etc 
 * 
*/
char *tratarString(char *s)
{
  char *newString = malloc(sizeof(char) * (strlen(s) + 1));
  strcpy(newString, s);

  int pos = 0;
  for (int i = 0; i < strlen(s); i++)
  {
    if (s[i] >= 65 && s[i] <= 90)
    {
      newString[pos++] = (char)(s[i] + 32);
    }
    else if ((s[i] >= 97 && s[i] <= 122) || (s[i] == ' ') || (s[i] >= 48 && s[i] <= 57))
    {
      newString[pos++] = s[i];
    }
    newString[pos] = '\0';
  }

  pos = 0;
  for (int i = 0; i < strlen(newString); i++)
  {
    if (!(newString[i] == ' ' && pos == 0))
    {
      newString[pos++] = newString[i];
    }
  }

  newString[pos] = '\0';

  pos = strlen(newString) - 1;
  while (newString[pos] == ' ')
  {
    newString[pos--] = '\0';
  }

  // printf("Debug: %s\n", newString);
  return newString;
}

/** 
 * Função auxiliar para trocar duas posições de um array
 * 
*/
void swap(Serie lista[], int a, int b, int *swapCounter)
{
  Serie temp = lista[a];
  lista[a] = lista[b];
  lista[b] = temp;

  *swapCounter = *swapCounter + 1;
}

/** 
 * Encontra o maior elemento no array de acordo com o atributo num_temporadas
 * 
*/
int getMaior(Serie lista[], int n)
{
  int maior = lista[0].num_temporadas;
  for (int i = 1; i < n; i++)
  {
    if (lista[i].num_temporadas > maior)
    {
      maior = lista[i].num_temporadas;
    }
  }

  return maior;
}

/** 
 * Algoritmo recursivo de ordenação Selection Sort, necessário para a execução
 * do algoritmo Counting Sort
 * 
*/
void selection(Serie lista[], int n, int *swapCounter, int *compareCounter, int i)
{
  int menor = i;

  for (int j = i + 1; j < n; j++)
  {
    if (lista[j].num_temporadas < lista[menor].num_temporadas ||
        (lista[j].num_temporadas == lista[menor].num_temporadas) &&
            strcmp(lista[j].nome, lista[menor].nome) < 0)
    {
      menor = j;
    }
    *compareCounter = *compareCounter + 2;
  }

  if (menor != i)
    swap(lista, menor, i, &*swapCounter);

  if (i + 1 < n)
    selection(lista, n, swapCounter, compareCounter, i + 1);
}

/** 
 * Algoritmo de ordenação Counting Sort
 * 
 * @param lista: Array com as séries
 * @param n: tamanho do array lista
 * @param swapCounter: ponteiro para o inteiro que conta a quantidade de swaps realizados no algoritmo
 * @param compareCounter: ponteiro para o inteiro que conta a quantidade de comparações realizados entre dois elementos do array no algoritmo
 * 
*/
void ordenar(Serie lista[], int n, int *swapCounter, int *compareCounter)
{
  int tamanho = getMaior(lista, n) + 1;
  int count[tamanho];
  Serie output[n];

  for (int i = 0; i < tamanho; count[i] = 0, i++)
    ;

  for (int i = 0; i < n; count[lista[i].num_temporadas]++, i++)
    ;

  for (int i = 1; i < tamanho; count[i] += count[i - 1], i++)
    ;

  for (int i = n - 1; i >= 0;
       output[count[lista[i].num_temporadas] - 1] = lista[i],
           count[lista[i].num_temporadas]--,
           *swapCounter = *swapCounter + 1,
           i--)
    ;

  for (int i = 0; i < n; i++)
  {
    lista[i] = output[i];
    *swapCounter = *swapCounter + 1;
  }

  selection(lista, n, &*swapCounter, &*compareCounter, 0);
}

int main()
{
  Serie serie;
  Serie lista[250];
  int compareCounter, swapCounter;
  compareCounter = swapCounter = 0;

  size_t tam_prefixo = strlen(PREFIXO);
  char line[MAX_LINE_SIZE];

  strcpy(line, PREFIXO);
  readline(line + tam_prefixo, MAX_LINE_SIZE);

  int counter = 0;
  while (!isFim(line + tam_prefixo))
  {
    char *html = ler_html(line);
    ler_serie(&serie, html);

    lista[counter++] = serie;

    free(html);
    readline(line + tam_prefixo, MAX_LINE_SIZE);
  }

  clock_t startTime = clock();
  ordenar(lista, counter, &swapCounter, &compareCounter);
  clock_t endTime = clock();
  float time = (float)(endTime - startTime);

  for (int i = 0; i < counter; i++)
  {
    print_serie(&lista[i]);
  }

  matricula(compareCounter, swapCounter, time);

  return EXIT_SUCCESS;
}
