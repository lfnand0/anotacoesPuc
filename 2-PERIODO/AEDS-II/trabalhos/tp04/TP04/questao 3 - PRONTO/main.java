import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
import java.time.*;


class Serie {
   private String nome;
   private String formato;
   private String duracao;
   private String pais;
   private String idioma;
   private String emissora;
   private String transmissao;
   private String temp;
   private String eps;

   // construtor primario
   public Serie() {
      this.nome = "";
      this.formato = "";
      this.duracao = "";
      this.pais = "";
      this.idioma = "";
      this.emissora = "";
      this.transmissao = "";
      this.eps = "";
      this.temp = "";
   }

   // construtor secundario
   public Serie(String nome, String formato, String duracao, String pais, String idioma, String emissora,
         String transmissao, String temp, String eps) {
      this.nome = nome;
      this.formato = formato;
      this.duracao = duracao;
      this.pais = pais;
      this.idioma = idioma;
      this.emissora = emissora;
      this.transmissao = transmissao;
      this.eps = eps;
      this.temp = temp;
   }

   //sets and gets
   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getFormato() {
      return formato;
   }

   public void setFormato(String formato) {
      this.formato = formato;
   }

   public String getDuracao() {
      return this.duracao;
   }

   public void setDuracao(String duracao) {
      this.duracao = duracao;
   }

   public String getPais() {
      return pais;
   }

   public void setPais(String pais) {
      this.pais = pais;
   }

   public String getIdioma() {
      return idioma;
   }

   public void setIdioma(String idioma) {
      this.idioma = idioma;
   }

   public String getEmissora() {
      return emissora;
   }

   public void setEmissora(String emissora) {
      this.emissora = emissora;
   }

   public String getTransmissao() {
      return transmissao;
   }

   public void setTransmissao(String transmissao) {
      this.transmissao = transmissao;
   }

   public String getTemp() {
      return temp;
   }

   public void setTemp(String temp) {
      this.temp = temp;
   }

   public String getEps() {
      return eps;
   }

   public void setEps(String eps) {
      this.eps = eps;
   }

   public Serie clone() {
      Serie result = new Serie();
      result.nome = this.nome;
      result.formato = this.formato;
      result.duracao = this.duracao;
      result.pais = this.pais;
      result.idioma = this.idioma;
      result.emissora = this.emissora;
      result.transmissao = this.transmissao;
      result.temp = this.temp;
      result.eps = this.eps;
      return result;
   }

   // mostra apenas inteiros
   public int justInt(String line) {
      String result = "";
      for (int i = 0; i < line.length(); i++) {
         if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
            result += line.charAt(i);
         } else {
            i = line.length();
         }
      }
      return Integer.parseInt(result);
   }

   public String removeTags(String line) {
      String result = "";
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
            result += line.charAt(i);
         }
         i++;
      }
      return result;
   }

   public String searchNome(String filenome) {
      String result = "";
      for (int i = 0; i < filenome.length(); i++) {
         if (filenome.charAt(i) == '_') {
            result += ' ';
         } else {
            result += filenome.charAt(i);
         }
      }
      return result.substring(0, result.length() - 5);
   }

   public void ler(String filenome) {
      String file = "/tmp/series/" + filenome;
      try {
         FileReader fileReader = new FileReader(file);

         BufferedReader br = new BufferedReader(fileReader);

         this.nome = searchNome(filenome);

         while (!br.readLine().contains("Formato"))
            ;
         this.formato = removeTags(br.readLine());

         while (!br.readLine().contains("Duração"))
            ;
         this.duracao = removeTags(br.readLine());

         while (!br.readLine().contains("País de origem"))
            ;
         this.pais = removeTags(br.readLine());

         while (!br.readLine().contains("Idioma original"))
            ;
         this.idioma = removeTags(br.readLine());

         while (!br.readLine().contains("Emissora de televisão"))
            ;
         this.emissora = removeTags(br.readLine());

         while (!br.readLine().contains("Transmissão original"))
            ;
         this.transmissao = removeTags(br.readLine());

         while (!br.readLine().contains("N.º de temporadas"))
            ;
         this.temp = removeTags(br.readLine());

         while (!br.readLine().contains("N.º de episódios"))
            ;
         this.eps = removeTags(br.readLine());

         br.close();
      } catch (Exception e) {
      }
   }
}

class AVL {
   private No raiz;

   public AVL() {
      raiz = null;
   }

   //pesquisa publica
   public boolean pesquisar(String item) {
      return pesquisar(item, raiz);
   }

   //pesquisa privada
   private boolean pesquisar(String item, No no) {
      boolean result = false;
      if (no == raiz) {
         System.out.print(" raiz ");
      }
      if (no == null) {
         result = false;
         System.out.print("NAO");
      } else if (item.compareTo(no.item.getNome()) == 0) {
         result = true;
         System.out.print("SIM");
      } else if (item.compareTo(no.item.getNome()) < 0) {
         System.out.print("esq ");
         result = pesquisar(item, no.esq);
      } else {
         System.out.print("dir ");
         result = pesquisar(item, no.dir);
      }
      return result;
   }

   //insere item publico
   public void inserir(Serie item) {
      raiz = inserir(item, raiz);
   }

   //insere item privado
   private No inserir(Serie item, No no) {
      if (no == null) {
         no = new No(item);

      } else if (item.getNome().compareTo(no.item.getNome()) < 0) {
         no.esq = inserir(item, no.esq);

      } else if (item.getNome().compareTo(no.item.getNome()) > 0) {
         no.dir = inserir(item, no.dir);

      }
      return balancear(no);
   }

   public Serie remover(Serie item) {
      raiz = remover(item, raiz);
      return item;
   }

   private No remover(Serie item, No no) {

      if (item.getNome().compareTo(no.item.getNome()) < 0) {
         no.esq = remover(item, no.esq);
      } else if (item.getNome().compareTo(no.item.getNome()) > 0) {
         no.dir = remover(item, no.dir);
      } else if (no.dir == null) {
         no = no.esq;
      } else if (no.esq == null) {
         no = no.dir;
      } else {
         no.esq = maiorEsq(no, no.esq);
      }
      return balancear(no);
   }

   private No maiorEsq(No noA, No noB) {
      if (noB.dir == null) {
         noA.item = noB.item;
         noB = noB.esq;
      } else {
         noB.dir = maiorEsq(noA, noB.dir);
      }
      return noB;
   }

   private No balancear(No no) {
      if (no != null) {
         int f = No.getNivel(no.dir) - No.getNivel(no.esq);
         if (Math.abs(f) <= 1) {
            no.setNivel();
         } else if (f == 2) {
            int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
            if (fatorFilhoDir == -1) {
               no.dir = rotacionarDir(no.dir);
            }
            no = rotacionarEsq(no);
         } else if (f == -2) {
            int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
            if (fatorFilhoEsq == 1) {
               no.esq = rotacionarEsq(no.esq);
            }
            no = rotacionarDir(no);
         }
      }
      return no;
   }

   private No rotacionarDir(No no) {
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;

      noEsq.dir = no;
      no.esq = noEsqDir;
      no.setNivel();
      noEsq.setNivel();

      return noEsq;
   }

   private No rotacionarEsq(No no) {
      No noDir = no.dir;
      No noDirEsq = noDir.esq;

      noDir.esq = no;
      no.dir = noDirEsq;

      no.setNivel();
      noDir.setNivel();
      return noDir;
   }
}

class No {
   public Serie item;
   public No esq, dir;
   public int nivel;

   public No(Serie item) {
      this(item, null, null, 1);
   }

   public No(Serie item, No esq, No dir, int nivel) {
      this.item = item;
      this.esq = esq;
      this.dir = dir;
      this.nivel = nivel;
   }

   public void setNivel() {
      this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
   }

   public static int getNivel(No no) {
      return (no == null) ? 0 : no.nivel;
   }
}

public class main {
   public static void log(long inicio) {
      try {
         RandomAccessFile log = new RandomAccessFile("matrícula_avl.txt", "rw");
         long tempo = Instant.now().toEpochMilli() - inicio;
         log.writeChars(String.format("724735\t%d\t%d", tempo, 0));
         log.close();
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   public static void main(String[] args) {
      AVL arv = new AVL();
      Scanner sc = new Scanner(System.in);
      String entrada = "";
      long inicio = Instant.now().toEpochMilli();
      int num = 0;
      Serie serie = new Serie();

      while (true) {
         serie = new Serie();
         entrada = sc.nextLine();
         if (entrada.equals("FIM")) {
            break;
         }
         serie.ler(entrada);
         arv.inserir(serie);
      }

      while (true) {
         serie = new Serie();
         entrada = sc.nextLine();
         if (entrada.equals("FIM")) {
            break;
         }
         arv.pesquisar(entrada);
         System.out.print("\n");
      }
      sc.close();
      log(inicio);
   }
}
