import java.io.*;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

class Serie {

  private String name;
  private String format;
  private String duration;
  private String country;
  private String language;
  private String broadcaster;
  private String streaming;
  private int seasons;
  private int episodes;

  public Serie() {
    name = "";
    format = "";
    duration = "";
    country = "";
    language = "";
    broadcaster = "";
    streaming = "";
    seasons = 0;
    episodes = 0;
  }

  public Serie(String name, String format, String duration, String country, String language, String broadcaster,
      String streaming, int seasons,
      int episodes) {
    this.name = name;
    this.format = format;
    this.duration = duration;
    this.country = country;
    this.language = language;
    this.broadcaster = broadcaster;
    this.streaming = streaming;
    this.seasons = seasons;
    this.episodes = episodes;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setBroadcaster(String broadcaster) {
    this.broadcaster = broadcaster;
  }

  public void setStreaming(String streaming) {
    this.streaming = streaming;
  }

  public void setSeasons(int seasons) {
    this.seasons = seasons;
  }

  public void setEpisodes(int episodes) {
    this.episodes = episodes;
  }

  public String getName() {
    return this.name;
  }

  public String getFormat() {
    return this.format;
  }

  public String getDuration() {
    return this.duration;
  }

  public String getCountry() {
    return this.country;
  }

  public String getLanguage() {
    return this.language;
  }

  public String getBroadcaster() {
    return this.broadcaster;
  }

  public String getStreaming() {
    return this.streaming;
  }

  public int getSeasons() {
    return this.seasons;
  }

  public int getEpisodes() {
    return this.episodes;
  }

  public Serie clone() {
    Serie resp = new Serie();
    resp.name = this.name;
    resp.format = this.format;
    resp.duration = this.duration;
    resp.country = this.country;
    resp.language = this.language;
    resp.broadcaster = this.broadcaster;
    resp.streaming = this.streaming;
    resp.seasons = this.seasons;
    resp.episodes = this.episodes;
    return resp;
  }

  public void printClass() {
    System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language
        + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes);
  }

  public String printName() {
    return this.name;
  }

  public int justInt(String line) {
    String resp = "";
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
        resp += line.charAt(i);
      } else {
        i = line.length();
      }
    }
    return Integer.parseInt(resp);
  }

  public String removeTags(String line) {
    String resp = "";
    int i = 0;
    while (i < line.length()) {
      if (line.charAt(i) == '<') {
        i++;
        while (line.charAt(i) != '>')
          i++;
      } else if (line.charAt(i) == '&') {
        i++;
        while (line.charAt(i) != ';')
          i++;
      } else {
        resp += line.charAt(i);
      }
      i++;
    }
    return resp;
  }

  public String searchName(String fileName) {
    String resp = "";
    for (int i = 0; i < fileName.length(); i++) {
      if (fileName.charAt(i) == '_') {
        resp += ' ';
      } else {
        resp += fileName.charAt(i);
      }
    }
    return resp.substring(0, resp.length() - 5);
  }

  public void readClass(String fileName) {
    String line;
    String resp = "";
    String file = "../tmp/series/" + fileName;
    try {
      FileReader fileReader = new FileReader(file);

      BufferedReader br = new BufferedReader(fileReader);

      this.name = searchName(fileName);

      while (!br.readLine().contains("Formato"))
        ;
      this.format = removeTags(br.readLine());

      while (!br.readLine().contains("Duração"))
        ;
      this.duration = removeTags(br.readLine());

      while (!br.readLine().contains("País de origem"))
        ;
      this.country = removeTags(br.readLine());
      this.country = this.country.trim();

      while (!br.readLine().contains("Idioma original"))
        ;
      this.language = removeTags(br.readLine());
      this.language = this.language.trim();

      while (!br.readLine().contains("Emissora de televisão"))
        ;
      this.broadcaster = removeTags(br.readLine());

      while (!br.readLine().contains("Transmissão original"))
        ;
      this.streaming = removeTags(br.readLine());

      while (!br.readLine().contains("N.º de temporadas"))
        ;
      this.seasons = justInt(removeTags(br.readLine()));

      while (!br.readLine().contains("N.º de episódios"))
        ;
      this.episodes = justInt(removeTags(br.readLine()));

      br.close();

    } catch (FileNotFoundException e) {
      System.out.println("Unable to open file '" + fileName + "'");
    } catch (IOException e) {
      System.out.println("Error reading file '" + fileName + "'");
    }
  }
}

class Celula {
  public int elemento;
  public Celula inf, sup, esq, dir;

  public Celula() {
    this(0);
  }

  public Celula(int elemento) {
    this(elemento, null, null, null, null);
  }

  public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
    this.elemento = elemento;
    this.inf = inf;
    this.sup = sup;
    this.esq = esq;
    this.dir = dir;
  }

  public void setInf(Celula inf) {
    this.inf = inf;
  }

  public void setSup(Celula sup) {
    this.sup = sup;
  }

  public void setEsq(Celula esq) {
    this.esq = esq;
  }

  public void setDir(Celula dir) {
    this.dir = dir;
  }

  public void setElemento(int elemento) {
    this.elemento = elemento;
  }

}

class Matriz {
  private Celula[][] matrix;
  private Celula inicio;
  private static int linha;
  private static int coluna;

  public Matriz(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
    matrix = new Celula[linha][coluna];

    for (int l = 0; l < linha; l++) {
      for (int c = 0; c < coluna; c++) {
        Celula aux = new Celula();
        matrix[l][c] = aux;
      }
    }

    for (int l = 0; l < linha; l++) {
      for (int c = 0; c < coluna; c++) {
        if (c == 0) {
          matrix[l][c].esq = null;
        } else {
          matrix[l][c].esq = matrix[l][c - 1];
        }

        if (c == coluna - 1) {
          matrix[l][c].dir = null;
        } else {
          matrix[l][c].dir = matrix[l][c + 1];
        }

        if (l == 0) {
          matrix[l][c].sup = null;
        } else {
          matrix[l][c].sup = matrix[l - 1][c];
        }

        if (l == linha - 1) {
          matrix[l][c].inf = null;
        } else {
          matrix[l][c].inf = matrix[l + 1][c];
        }

      }
    }

  }

  public void leitrua() {
    for (int l = 0; l < linha; l++) {
      String input = MyIO.readLine();
      int position = 0;
      for (int c = 0; c < coluna; c++) {
        int element = input.charAt(position) - '0';
        matrix[l][c].elemento = element;
        position += 2;
      }
    }
  }

  public Matriz soma(Matriz m) {
    Matriz resp = null;
    if (this.linha == m.linha && this.coluna == m.coluna) {
      resp = new Matriz(this.linha, this.coluna);
      for (int l = 0; l < this.linha; l++) {
        for (int c = 0; c < this.coluna; c++) {
          resp.matrix[l][c].elemento = this.matrix[l][c].elemento + m.matrix[l][c].elemento;
        }
      }
    }
    return resp;
  }

  public Matriz multiplicacao(Matriz m) {
    Matriz resp = null;
    if (this.linha != m.coluna) {
      return resp;
    }
    resp = new Matriz(this.linha, m.coluna);
    for (int l = 0; l < this.linha; l++) {
      for (int c = 0; c < m.coluna; c++) {
        for (int k = 0; k < m.linha; k++)
          resp.matrix[l][c].elemento += this.matrix[l][k].elemento * m.matrix[k][c].elemento;
      }
    }
    return resp;
  }

  public boolean isQuadrada() {
    return (this.linha == this.coluna);
  }

  public void mostrar() {
    int contador = 0;
    for (Celula l = this.matrix[0][0]; l != null; l = l.inf) {
      if (contador != 0) {
        System.out.print("\n");
      }
      contador++;
      for (Celula c = l; c != null; c = c.dir) {
        System.out.print(c.elemento + " ");
      }
    }
    System.out.print("\n");
  }

  public void mostrarDiagonalPrincipal() {
    if (isQuadrada() == true) {

      for (Celula corner = this.matrix[0][0]; corner != null; corner = corner.dir.inf) {
        System.out.print(corner.elemento + " ");
        if (corner.dir == null) {
          break;
        }
      }
      System.out.print("\n");
    }
  }

  public void mostrarDiagonalSecundaria() {
    if (isQuadrada() == true) {
      for (Celula corner = this.matrix[0][this.coluna - 1]; corner != null; corner = corner.esq.inf) {
        System.out.print(corner.elemento + " ");
        if (corner.esq == null) {
          break;
        }
      }
      System.out.print("\n");
    }
  }
}

public class Main {

  public static int MyIoParseInt(String line) {
    String resp = "";
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) >= '0' && line.charAt(i) <= '9')
        resp += line.charAt(i);
      else
        i = line.length();
    }
    return Integer.parseInt(resp);
  }

  public static void main(String args[]) {
    int breakpoint = 0;
    breakpoint = MyIoParseInt(MyIO.readLine());

    for (int i = 0; i < breakpoint; i++) {

      // Leitura da primeira matriz
      int linhas = MyIoParseInt(MyIO.readLine());
      int colunas = MyIoParseInt(MyIO.readLine());
      Matriz matriz1 = new Matriz(linhas, colunas);
      matriz1.leitrua();

      // Leitura da Segunda matriz
      int linhas2 = MyIoParseInt(MyIO.readLine());
      int colunas2 = MyIoParseInt(MyIO.readLine());
      Matriz matriz2 = new Matriz(linhas2, colunas2);
      matriz2.leitrua();

      // Saida da primeira matriz
      matriz1.mostrarDiagonalPrincipal();
      matriz1.mostrarDiagonalSecundaria();

      // Criação da matriz soma
      Matriz soma = new Matriz(linhas, colunas);
      soma = matriz1.soma(matriz2);
      soma.mostrar();

      // Criação da matriz multiplicação
      Matriz multiplicacao;
      multiplicacao = matriz1.multiplicacao(matriz2);
      multiplicacao.mostrar();
    }

  }
}