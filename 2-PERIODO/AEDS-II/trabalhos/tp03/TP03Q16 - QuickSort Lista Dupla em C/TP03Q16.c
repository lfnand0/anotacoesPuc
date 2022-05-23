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

void print_serie(Serie serie)
{
  printf("%s %s %s %s %s %s %s %d %d\n",
         serie.nome,
         serie.formato,
         serie.duracao,
         serie.pais,
         serie.idioma,
         serie.emissora,
         serie.transmissao,
         serie.num_temporadas,
         serie.num_episodios);
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
#define PREFIXO "../tmp/series/"
// #define PREFIXO "../entrada e saida/tp02/series/"

typedef struct CelulaDupla
{
  Serie elemento;
  struct CelulaDupla *ant;
  struct CelulaDupla *prox;
} CelulaDupla;

CelulaDupla *novaCelula(Serie serie)
{
  CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
  nova->elemento = serie;
  nova->prox = NULL;
  nova->ant = NULL;
  return nova;
}

CelulaDupla *primeira;
CelulaDupla *ultima;

int swapCounter = 0;
int compareCounter = 0;

void start()
{
  primeira = NULL;
  ultima = NULL;
}

int length()
{
  int l = 0;
  CelulaDupla *aux;
  for (aux = primeira->prox; aux != NULL; aux = aux->prox)
  {
    l++;
  }

  return l;
}

void inserirFim(Serie item)
{
  CelulaDupla *tmp = novaCelula(item);

  if (primeira->prox == NULL) {
    primeira->prox = tmp;
    ultima = tmp;
  } else {
    CelulaDupla *atual;
    atual = ultima;
    tmp->ant = atual;
    atual->prox = tmp;
    ultima = tmp;
  }
}

CelulaDupla *posicao(int pos)
{
  if (pos >= length())
  {
    exit(0);
  }

  CelulaDupla *aux = primeira->prox;
  for (int i = 0; i < pos; i++)
  {
    aux = aux->prox;
  }

  return aux;
}


void swap(int a, int b)
{
  CelulaDupla *celA;
  celA = posicao(a);

  CelulaDupla *celB;
  celB = posicao(b);

  Serie temp = celA->elemento;
  celA->elemento = celB->elemento;
  celB->elemento = temp;

  swapCounter++;
}

void mostrar()
{
  CelulaDupla *i = primeira;

  while (i != NULL)
  {
    print_serie(i->elemento);
    i = i->prox;
  }
}

int comparar(Serie a, Serie b)
{
  int retorno = strcmp(a.pais, b.pais);
  if (retorno == 0)
  {
    retorno = strcmp(a.nome, b.nome);
    compareCounter++;
  }

  compareCounter++;
  return retorno;
}


void quicksort(int esq, int dir)
{
  int i = esq, j = dir;
  Serie pivo = posicao((dir + esq) / 2)->elemento;

  while (i <= j)
  {
    while (comparar(posicao(i)->elemento, pivo) < 0)
    {
      i++;
    }

    while (comparar(posicao(j)->elemento, pivo) > 0)
    {
      j++;
    }

    if (i <= j)
    {
      swap(i, j);

      i++;
      j--;
    }
  }

  if (esq < j)
    quicksort(esq, j);
  if (i < dir)
    quicksort(i, dir);
}

void ordenar()
{
  quicksort(0, length() - 1);
}

int isFim(char line[])
{
  return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
}

void matricula(int compareCounter, int swapCounter, float time)
{
  FILE *fp = fopen("matrícula_countingsort.txt", "w");
  fprintf(fp, "727245\t%d\t%d\t%f ", compareCounter, swapCounter, time);
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
  start();

  
  int counter = 0;
  while (!isFim(line + tam_prefixo))
  {
    char *html = ler_html(line);
    ler_serie(&serie, html);

    inserirFim(serie);

    free(html);
    readline(line + tam_prefixo, MAX_LINE_SIZE);
  }

  clock_t startTime = clock();
  ordenar();
  clock_t endTime = clock();
  float time = (float)(endTime - startTime);

  mostrar();

  matricula(compareCounter, swapCounter, time);

  return EXIT_SUCCESS;
}