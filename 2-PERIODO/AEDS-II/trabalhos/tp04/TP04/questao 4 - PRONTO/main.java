import java.io.*;
import java.io.FileReader;
import java.io.File;  
import java.io.IOException;  

class AB {
	private No raiz; 
    public static int compareCounter;

	//construtor
	public AB() {
		raiz = null;
	}

   //pesquisa de elemento - publico
	public boolean pesquisar(String x) {
        System.out.print("raiz ");
		return pesquisar(x, raiz);
	}

	//pesquisa de elemento - privado
	private boolean pesquisar(String x, No i) {

        if(i != null){
        }

      boolean resp;
		if (i == null) {
         resp = false;
         System.out.print("NAO");

      } else if (x.compareTo(i.elemento.getName()) == 0 ) {
          compareCounter++;
         resp = true;
         System.out.print("SIM");

      } else if (x.compareTo(i.elemento.getName()) < 0) {
        compareCounter++;
        System.out.print("esq ");
         resp = pesquisar(x, i.esq);

      } else {
        compareCounter++;
        System.out.print("dir ");
         resp = pesquisar(x, i.dir);
      }
      return resp;
	}

	//exibe elementos - publico
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

	//exibe elementos - privado
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); 
			System.out.print(i.elemento + " "); 
			caminharCentral(i.dir); 
		}
	}

   // exibe elemento - publico
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}

   // exibe elemento - privado
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // Conteudo do no.
			caminharPre(i.esq); // Elementos da esquerda.
			caminharPre(i.dir); // Elementos da direita.
		}
	}

   // exibe elementos - iterativo - publico  
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

   // exibe elementos - iterativo -  iterativo 
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq);
			caminharPos(i.dir);
			System.out.print(i.elemento + " "); 
		}
	}

    public void inserir(Serie elemento)  {
        if (raiz == null) {
           raiz = new No(elemento);

  
        // 1 elemento
        } else if (raiz.esq == null && raiz.dir == null) {
           if (elemento.getName().compareTo(raiz.elemento.getName()) < 0) {
              raiz.esq = new No(elemento);
           } else {
              raiz.dir = new No(elemento);
           }
  
        // 2 elementos (raiz e dir)
        } else if (raiz.esq == null) {
           if (elemento.getName().compareTo(raiz.elemento.getName()) < 0) {
              raiz.esq = new No(elemento);
  
           } else if (elemento.getName().compareTo(raiz.dir.elemento.getName()) < 0) {
              raiz.esq = new No(raiz.elemento);
              raiz.elemento = elemento;
  
           } else {
              raiz.esq = new No(raiz.elemento);
              raiz.elemento = raiz.dir.elemento;
              raiz.dir.elemento = elemento;
           }
           raiz.esq.cor = raiz.dir.cor = false;
  
        // 2 elementos (raiz e esq)
        } else if (raiz.dir == null) {
           if (elemento.getName().compareTo(raiz.elemento.getName()) > 0) {
              raiz.dir = new No(elemento);
  
           } else if (elemento.getName().compareTo(raiz.esq.elemento.getName()) > 0) {
              raiz.dir = new No(raiz.elemento);
              raiz.elemento = elemento;
  
           } else {
              raiz.dir = new No(raiz.elemento);
              raiz.elemento = raiz.esq.elemento;
              raiz.esq.elemento = elemento;
           }
           raiz.esq.cor = raiz.dir.cor = false;
  
        // 3 ou mais elementos
        } else {
           inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
     }


     private void inserir(Serie elemento, No bisavo, No avo, No pai, No i) {
      if (i == null) {
         if (elemento.getName().compareTo(pai.elemento.getName()) < 0) {
            i = pai.esq = new No(elemento, true);
         } else {
            i = pai.dir = new No(elemento, true);
         }
         if (pai.cor == true) {
            balancear(bisavo, avo, pai, i);
         }
      } else {
         if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
            i.cor = true;
            i.esq.cor = i.dir.cor = false;
            if (i == raiz) {
               i.cor = false;
            } else if (pai.cor == true) {
               balancear(bisavo, avo, pai, i);
            }
         }
         if (elemento.getName().compareTo(i.elemento.getName()) < 0) {
            inserir(elemento, avo, pai, i, i.esq);
         } else if (elemento.getName().compareTo(i.elemento.getName()) > 0) {
            inserir(elemento, avo, pai, i, i.dir);
         } else {

         }
      }
   }

   // insere elemento - publico
	public void inserirPai(Serie x) throws Exception {
      if(raiz == null){
         raiz = new No(x);
        } else if (x.getName().compareTo(raiz.elemento.getName()) < 0) {
		   inserirPai(x, raiz.esq, raiz);
        } else if (x.getName().compareTo(raiz.elemento.getName()) > 0) {
		   inserirPai(x, raiz.dir, raiz);
      } else {
         throw new Exception("Erro ao inserirPai!");
      }
	}

   // insere elemento - privado
	private void inserirPai(Serie x, No i, No pai) throws Exception {
		if (i == null) {
         if(x.getName().compareTo(pai.elemento.getName()) < 0){
            pai.esq = new No(x);
         } else {
            pai.dir = new No(x);
         }
      } else if (x.getName().compareTo(i.elemento.getName()) < 0) {
         inserirPai(x, i.esq, i);
      } else if (x.getName().compareTo(i.elemento.getName()) > 0) {
         inserirPai(x, i.dir, i);
      } else {
         throw new Exception("Erro ao inserirPai!");
      }
	}




   //troca o elemento removido pelo maior à esquerda
	private No maiorEsq(No i, No j) {
		if (j.dir == null) {
			i.elemento = j.elemento;
			j = j.esq;
		} else {
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

   //retorna o maior elemento
   public Serie getMaior(){
      Serie resp = new Serie();

      if(raiz != null){
         No i;
         for(i = raiz; i.dir != null; i = i.dir);
         resp = i.elemento;
      }

      return resp;
   }


   //retorna o menor elemento
   public Serie getMenor(){
    Serie resp = new Serie();

      if(raiz != null){
         No i;
         for(i = raiz; i.esq != null; i = i.esq);
         resp = i.elemento;
      }

      return resp;
   }


   //retorna a altura da arvore
   public int getAltura(){
      return getAltura(raiz, 0);
   }
   public int getAltura(No i, int altura){
      if(i == null){
         altura--;
      } else {
         int alturaEsq = getAltura(i.esq, altura + 1);
         int alturaDir = getAltura(i.dir, altura + 1);
         altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
      }
      return altura;
   }


	// metodo iterativo para remover o elemento
	public void remover2(String x) throws Exception {
      if (raiz == null) {
         throw new Exception("Erro ao remover2!");
      } else if(x.compareTo(raiz.elemento.getName()) < 0){
         remover2(x, raiz.esq, raiz);
      } else if (x.compareTo(raiz.elemento.getName()) > 0){
         remover2(x, raiz.dir, raiz);
      } else if (raiz.dir == null) {
         raiz = raiz.esq;
      } else if (raiz.esq == null) {
         raiz = raiz.dir;
      } else {
         raiz.esq = maiorEsq(raiz, raiz.esq);
      }
   }

	// metodo recursivo para remover elemento
	private void remover2(String x, No i, No pai) throws Exception {
		if (i == null) {
         throw new Exception("Erro ao remover2!");
      } else if (x.compareTo(i.elemento.getName()) < 0) {
         remover2(x, i.esq, i);
      } else if (x.compareTo(i.elemento.getName()) > 0) {
         remover2(x, i.dir, i);
      } else if (i.dir == null) {
         pai = i.esq;
      } else if (i.esq == null) {
         pai = i.dir;
      } else {
         i.esq = maiorEsq(i, i.esq);
		}
	}

   public Serie getRaiz() throws Exception {
      return raiz.elemento;
   }

   public static boolean igual (AB a1, AB a2){
      return igual(a1.raiz, a2.raiz);
   }

   private static boolean igual (No i1, No i2){
      boolean resp;
      if(i1 != null && i2 != null){
         resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
      } else if(i1 == null && i2 == null){
         resp = true;
      } else {
         resp = false; 
      }
      return resp;
   }

   static void log(long time){

    try {
        File myObj = new File("matrícula_alvinegra.txt");
        if (myObj.createNewFile()) {
        } else {
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        FileWriter myWriter = new FileWriter("matrícula_alvinegra.txt");
        myWriter.write("" + "\t" + time + "\t" + compareCounter);
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

}

private void balancear(No bisavo, No avo, No pai, No i) {
    
    if (pai.cor == true) {
       
       if (pai.elemento.getName().compareTo(avo.elemento.getName()) > 0) { 
          if (i.elemento.getName().compareTo(pai.elemento.getName()) > 0) {
             avo = rotacaoEsq(avo);
          } else {
             avo = rotacaoDirEsq(avo);
          }
       } else { 
          if (i.elemento.getName().compareTo(pai.elemento.getName()) < 0) {
             avo = rotacaoDir(avo);
          } else {
             avo = rotacaoEsqDir(avo);
          }
       }
       if (bisavo == null) {
          raiz = avo;
       } else if (avo.elemento.getName().compareTo(bisavo.elemento.getName()) < 0) {
          bisavo.esq = avo;
       } else {
          bisavo.dir = avo;
       }      
       avo.cor = false;
       avo.esq.cor = avo.dir.cor = true;
    }
 }

 public No rotacaoDir(No no) {
    No noEsq = no.esq;
    No noEsqDir = noEsq.dir;

    noEsq.dir = no;
    no.esq = noEsqDir;

    return noEsq;
 }

 public No rotacaoEsq(No no) {
    No noDir = no.dir;
    No noDirEsq = noDir.esq;

    noDir.esq = no;
    no.dir = noDirEsq;
    return noDir;
 }

 public No rotacaoDirEsq(No no) {
    no.dir = rotacaoDir(no.dir);
    return rotacaoEsq(no);
 }

 public No rotacaoEsqDir(No no) {
    no.esq = rotacaoEsq(no.esq);
    return rotacaoDir(no);
 }

    
}


// no arvore binaria - Max

class No {
    public Serie elemento; 
    public No esq, dir;  
    public boolean cor;

   // construtor de classe
    public No(Serie elemento) {
        this(elemento, false, null, null);
    }

    
    public No(Serie elemento, boolean cor) {
        this(elemento, cor, null, null);
      }

      public No(Serie elemento, boolean cor, No esq, No dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
      }



}




class Serie{
   //declarando atributos
   private String name;
   private String format;
   private String duration;
   private String country;
   private String language;
   private String broadcaster;
   private String streaming;
   private int seasons;
   private int episodes;

   //construtor primário
   public Serie(){
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
   //construtor secundário
   public Serie(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
   int episodes){
       this.name = name;
       this.format = format;
       this.duration = duration;
       this.country = country;
       this.language = language;
       this.broadcaster = broadcaster;
       this.streaming = streaming;
       this.seasons = seasons;
       this.episodes = episodes;

       //sets
   } public void setName(String name){
       this.name = name;
   }    public void setFormat(String format){
       this.format = format;
   }
   public void setDuration(String duration){
       this.duration = duration;
   }    public void setCountry(String country){
       this.country = country;
   }
   public void setLanguage(String language){
       this.language = language;
   }
   public void setBroadcaster(String broadcaster){
       this.broadcaster = broadcaster;
   }
   public void setStreaming(String streaming){
       this.streaming = streaming;
   }    public void setSeasons(int seasons){
       this.seasons = seasons;
   }
   public void setEpisodes(int episodes){
       this.episodes = episodes;
   }

   //return dos atributos
   public String getName(){ 
       return this.name; 
   }
   public String getFormat(){ 
       return this.format; 
   }     
   public String getDuration(){ 
       return this.duration; 
   }
   public String getCountry(){ 
       return this.country; 
   }     
   public String getLanguage(){ 
       return this.language; 
   }     
   public String getBroadcaster(){ 
       return this.broadcaster; 
   }    
   public String getStreaming(){ 
       return this.streaming; 
   }
   public int getSeasons(){ 
       return this.seasons; 
   }    
   public int getEpisodes(){ 
       return this.episodes; 
   }

   //clone
   public Serie clone(){
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
   //método para printar a classe
   public void printClass(){
       System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
       this.streaming + " " + this.seasons + " " + this.episodes);
   }

   public String printName(){
       return this.name;
   }
   //tratar linha
   public int justInt(String line){
       String resp = "";
       for(int i = 0; i < line.length(); i++){
           if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
               resp += line.charAt(i);
           } else { //recebe a condição de parada
               i = line.length();
           }
       }
       return Integer.parseInt(resp); //string -> int
   }

   //limpa a linha para retornar so o necessario 
   public String removeTags(String line){
       String resp = "";
       int i = 0;
       while(i < line.length()){ 
           if(line.charAt(i) == '<'){ 
               i++;
               while(line.charAt(i) != '>') i++;
           } else if(line.charAt(i) == '&'){ 
               i++;
               while(line.charAt(i) != ';') i++;
           } else { 
               resp += line.charAt(i);
           }
           i++;
       }
       return resp;
   }

   //método para trata o nome do arq
   public String searchName(String fileName){
       String resp = "";
       for(int i = 0; i < fileName.length(); i++){
           if(fileName.charAt(i)  == '_'){
               resp += ' ';
           } else { 
               resp += fileName.charAt(i);
           }
       }
       return resp.substring(0, resp.length()-5); 
   }

   //le o arq e trata as linhas
   public void readClass(String fileName){
       String line;
       String resp = "";
       String file = "/tmp/series/" + fileName;
       try {
           FileReader fileReader = new FileReader(file); 

           BufferedReader br = new BufferedReader(fileReader);
           
           //sets
           this.name = searchName(fileName);
           
           while(!br.readLine().contains("Formato"));
           this.format = removeTags(br.readLine());

           while(!br.readLine().contains("Duração"));
           this.duration = removeTags(br.readLine());

           while(!br.readLine().contains("País de origem"));
           this.country = removeTags(br.readLine());

           while(!br.readLine().contains("Idioma original"));
           this.language = removeTags(br.readLine());

           while(!br.readLine().contains("Emissora de televisão"));
           this.broadcaster = removeTags(br.readLine());

           while(!br.readLine().contains("Transmissão original"));
           this.streaming = removeTags(br.readLine());

           while(!br.readLine().contains("N.º de temporadas"));
           this.seasons = justInt(removeTags(br.readLine()));

           while(!br.readLine().contains("N.º de episódios"));
           this.episodes = justInt(removeTags(br.readLine()));
           
           //mostra a classe
           //close bufferedReader
           br.close();         
       // exceções
       } catch(FileNotFoundException e) {
           System.out.println("Unable to open file '" + fileName + "'");                
       } catch(IOException e) {
           System.out.println("Error reading file '" + fileName + "'");
       }
   }
}       
 



public class main{


    public static int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
                resp += line.charAt(i);
            } else { 
                i = line.length();
            }
        }
        return Integer.parseInt(resp); 
    }

   //finalizador do programa
	public static boolean finishProgram(String s){
        if((s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M') ){ 
         return true;
        }       
        else{ 
        return false;            
        }       
    }


	public static void main(String args[]) throws Exception{
   long startTime = System.nanoTime();
   int NumberOperations = 0;
	AB arvore = new AB();
   while(true){
        Serie serie = new Serie();
        String input2 = MyIO.readLine();
        if(finishProgram(input2) == true){break; }
        serie.readClass(input2);
        arvore.inserir(serie);
    }

    while(true){
        Serie serie3 = new Serie();
        String input3 = MyIO.readLine();
        if(finishProgram(input3) == true){break; }
        arvore.pesquisar(input3);
        System.out.print("\n");
    }
    
    long stopTime = System.nanoTime();
    long execTime = stopTime - startTime;
    AB.log(execTime);

    }
}
