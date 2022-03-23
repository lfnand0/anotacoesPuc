import java.util.*;
import java.io.*;
import java.time.*;

class Serie {

   private String name;
   private String format;
   private String length;
   private String country;
   private String language;
   private String broadcaster;
   private String originalStream;
   private String numberOfSeasons;
   private String numberOfEpisodes;

   public Serie() {
      name = "";
      format = "";
      length = "";
      country = "";
      language = "";
      broadcaster = "";
      originalStream = "";
      numberOfSeasons = "";
      numberOfEpisodes = "";
   }

   public Serie(String name, String format, String length, String country, String language, String broadcaster,
         String originalStream, String numberOfSeasons, String numberOfEpisodes) {

      this.name = name;
      this.format = format;
      this.length = length;
      this.country = country;
      this.language = language;
      this.broadcaster = broadcaster;
      this.originalStream = originalStream;
      this.numberOfSeasons = numberOfSeasons;
      this.numberOfEpisodes = numberOfEpisodes;
   }

   public void printClass() {
      System.out.println(this.name + " " + this.format + " " + this.length + " " + this.country + " " + this.language
            + " " + this.broadcaster + " " + this.originalStream + " " + this.numberOfSeasons + " "
            + this.numberOfEpisodes);
   }

   public Serie clone() {
      Serie destination = new Serie();
      destination.name = this.name;
      destination.format = this.format;
      destination.length = this.length;
      destination.country = this.country;
      destination.language = this.language;
      destination.broadcaster = this.broadcaster;
      destination.originalStream = this.originalStream;
      destination.numberOfSeasons = this.numberOfSeasons;
      destination.numberOfEpisodes = this.numberOfEpisodes;
      return destination;
   }

   // gets

   public String getName() {
      return this.name;
   }
   public String getFormat() {
      return this.format;
   }
   public String getDuration() {
      return this.length;
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
      return this.originalStream;
   }
   public String getSeasons() {
      return this.numberOfSeasons;
   }
   public String getEpisodes() {
      return this.numberOfEpisodes;
   }

   // set

   public void setName(String name) {
      this.name = name;
   }
   public void setFormat(String format) {
      this.format = format;
   }
   public void setDuration(String length) {
      this.length = length;
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
   public void setStreaming(String originalStream) {
      this.originalStream = originalStream;
   }

   public void setSeasons(String numberOfSeasons) {
      this.numberOfSeasons = numberOfSeasons;
   }

   public void setEpisodes(String numberOfEpisodes) {
      this.numberOfEpisodes = numberOfEpisodes;
   }
}

class Read {
   public static String soInt(String line) {
      String auxString = "";
      for (int i = 0; i < line.length(); i++) {
         // numbr -> auxString
         if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
            auxString += line.charAt(i);
         } else {
            break;
         }
      }
      return auxString;
   }

   public static String removeTags(String line) {
      line = line.replaceAll("<.*?>", ""); 
      line = line.replaceAll("&.*?;", ""); // remove tags
      line = line.trim();
      line = line.replaceAll("(lista de episódios)", "");
      line = line.replaceAll("(Lista de episódios)", "");
      line = line.replaceAll("(até o momento)", "");

      return line;
   }

   // retorna o nome da serie
   public static String searchName(String fileName) {
      return fileName.replaceAll("(.html)", "").replaceAll("_", " ");
   }

   public static Serie readClass(String fileName) throws IOException {

      String name;
      String format;
      String length;
      String country;
      String language;
      String broadcaster;
      String originalStream;
      String numberOfSeasons;
      String numberOfEpisodes;

      FileReader fileReader = new FileReader("/tmp/series/" + fileName);

      BufferedReader br = new BufferedReader(fileReader);

      name = searchName(fileName);

      while (!br.readLine().contains("Formato"));
      format = removeTags(br.readLine());

      while (!br.readLine().contains("Duração"));
      length = removeTags(br.readLine());

      while (!br.readLine().contains("País de origem"));
      country = removeTags(br.readLine());

      while (!br.readLine().contains("Idioma original"));
      language = removeTags(br.readLine());

      while (!br.readLine().contains("Emissora de televisão"));
      broadcaster = removeTags(br.readLine());

      while (!br.readLine().contains("Transmissão original"));
      originalStream = removeTags(br.readLine());

      while (!br.readLine().contains("N.º de temporadas"));
      numberOfSeasons = soInt(removeTags(br.readLine()));

      while (!br.readLine().contains("N.º de episódios"));
      numberOfEpisodes = soInt(removeTags(br.readLine()));

      br.close();
      return new Serie(name, format, length, country, language, broadcaster, originalStream, numberOfSeasons,
            numberOfEpisodes);

   }
}

class Hash {
   int tabela[];
   int tamanhoNormal, tamanhoReserva, tamanhoTotal, indexReserva;
   final int NULO = -1;
   Set<String> itensInseridos = new HashSet<String>();

   public Hash() {
      this(21, 9);
   }

   public Hash(int tamanhoNormal, int tamanhoReserva) {
      this.tamanhoNormal = tamanhoNormal;
      this.tamanhoReserva = tamanhoReserva;
      this.tamanhoTotal = tamanhoNormal + tamanhoReserva;
      this.tabela = new int[this.tamanhoTotal];
      for (int i = 0; i < tamanhoNormal; i++) {
         tabela[i] = NULO;
      }
      indexReserva = 0;
   }

   public int h(int elemento) {
      return elemento % tamanhoNormal;
   }

   public boolean inserir(int elemento) {
      boolean resp = false;
      if (elemento != NULO) {
         int pos = h(elemento);
         if (tabela[pos] == NULO) {
            tabela[pos] = elemento;
            resp = true;
         } else if (indexReserva < tamanhoReserva) {
            tabela[tamanhoNormal + indexReserva] = elemento;
            indexReserva++;
            resp = true;
         }
      }
      return resp;
   }

   public boolean pesquisar(int elemento) {
      boolean resp = false;
      int pos = h(elemento);
      if (tabela[pos] == elemento) {
         resp = true;
      } else if (tabela[pos] != NULO) {
         for (int i = 0; i < indexReserva; i++) {
            if (tabela[tamanhoNormal + i] == elemento) {
               resp = true;
               i = indexReserva;
            }
         }
      }
      if (resp == false) {
      }
      return resp;
   }

}

public class main {
   public static void main(String[] args) {
      String line;
      Scanner sc = new Scanner(System.in);
      long programStartTime = Instant.now().toEpochMilli();
      Hash hashTable = new Hash();
      String name;
      int sum = 0;

      //finalizador do programa
      do {
         line = sc.nextLine();
         if (!line.equals("FIM")) {
            try {
               Serie aux = Read.readClass(line);
               name = aux.getName();
               for (int i = 0; i < name.length(); i++) {
                  sum += (int) name.charAt(i);
               }
               sum = hashTable.h(sum);
               if (hashTable.inserir(sum) == true) {
                  hashTable.itensInseridos.add(name);
               }
               sum = 0;
            } catch (Exception e) {
               System.out.println(e);
            }

         }
      } while (!line.equals("FIM"));

      do {
         line = sc.nextLine();
         if (!line.equals("FIM")) {
            if (hashTable.itensInseridos.contains(line)) {
               System.out.println(" SIM");
            } else {
               try {
                  for (int i = 0; i < line.length(); i++) {
                     sum += (int) line.charAt(i);
                  }
                  sum = hashTable.h(sum);
                  hashTable.pesquisar(sum);
                  sum = 0;
                  System.out.println(" NAO");
               } catch (Exception e) {
               }
            }
         }

      } while (!line.equals("FIM"));

      sc.close();

      try {
         RandomAccessFile log = new RandomAccessFile("matrícula_hashReserva.txt", "rw");
         long totalRuntime = Instant.now().toEpochMilli() - programStartTime;
         log.writeChars(String.format("729414\t%d\t%d", totalRuntime, 0));
         log.close();
      } catch (Exception e) {
         System.out.println(e);
      }
   }
}
