import java.io.*;
import java.io.FileReader;
import java.io.File; 
import java.io.IOException; 

class AB {
	private No raiz; // Raiz da arvore.
    public static int compareCounter;

    //construtor de classe
	public AB() {
		raiz = null;
	}

    //metodo publico iterativo para pesquisar elementos
	public boolean pesquisar(String x) {
        System.out.print("raiz ");
		return pesquisar(x, raiz);
	}

    // metodo privado recursivo para pesquisar elemento
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

    //metodo publico iterativo para mostrar elementos
	public void caminharCentral() {
		System.out.print("[ ");
		caminharCentral(raiz);
		System.out.println("]");
	}

    //metodo privado recursivo para mostrar elementos
	private void caminharCentral(No i) {
		if (i != null) {
			caminharCentral(i.esq); // Esquerda
			System.out.print(i.elemento + " "); // No
			caminharCentral(i.dir); // Direita
		}
	}

    //metodo publico iterativo para existir elementos.
	public void caminharPre() {
		System.out.print("[ ");
		caminharPre(raiz);
		System.out.println("]");
	}
    
    //metodo privado recursivo para mostrar elementos
	private void caminharPre(No i) {
		if (i != null) {
			System.out.print(i.elemento + " "); // No
			caminharPre(i.esq); // Esquerda
			caminharPre(i.dir); // Direita
		}
	}

    //metodo publico iterativo para mostrar elementos
	public void caminharPos() {
		System.out.print("[ ");
		caminharPos(raiz);
		System.out.println("]");
	}

    //metodo privado e recursivo para mostrar elementos
	private void caminharPos(No i) {
		if (i != null) {
			caminharPos(i.esq); // Esquerda
			caminharPos(i.dir); // Direita
			System.out.print(i.elemento + " "); // No
		}
	}


	//metodo publico iterativo para inserir elemento
	public void inserir(Serie x) throws Exception {
		raiz = inserir(x, raiz);
	}

	//metodo privado para inserir elemento
	private No inserir(Serie x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

        } else if (x.getName().compareTo(i.elemento.getName()) < 0) {
         i.esq = inserir(x, i.esq);

        } else if (x.getName().compareTo(i.elemento.getName()) > 0) {
         i.dir = inserir(x, i.dir);

      } else {
         throw new Exception("Erro ao inserir!");
      }

		return i;
	}

    //metodo publico para inserir elemento Pai
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

    //metodo privado recursivo para inserir elemento  Pai
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

    //metodo iterativo para remover elemento
	public void remover(Serie x) throws Exception {
		raiz = remover(x, raiz);
	}

    //metodo privado para remover elemento
	private No remover(Serie x, No i) throws Exception {

		if (i == null) {


      } else if (x.getName().compareTo(i.elemento.getName()) < 0) {
        compareCounter++;
         i.esq = remover(x, i.esq);
      } else if (x.getName().compareTo(i.elemento.getName()) > 0) {
        compareCounter++;
         i.dir = remover(x, i.dir);
      } else if (i.dir == null) {
        compareCounter++;
         i = i.esq;
      } else if (i.esq == null) {
        compareCounter++;
         i = i.dir;
      } else {
         i.esq = maiorEsq(i, i.esq);
		}
		return i;
	}

	//troca o elemento removido pelo maior à esquerda
	private No maiorEsq(No i, No j) {
		if (j.dir == null) {
			i.elemento = j.elemento; // Substitui i por j.
			j = j.esq; // Substitui j por j.ESQ.
		} else {
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

	//retorna o maior elemento da arvore
   public Serie getMaior(){
      Serie resp = new Serie();
      if(raiz != null){
         No i;
         for(i = raiz; i.dir != null; i = i.dir);
         resp = i.elemento;
      }
      return resp;
   }


	//retorna o menor elemento da arvore
   public Serie getMenor(){
    Serie resp = new Serie();
      if(raiz != null){
         No i;
         for(i = raiz; i.esq != null; i = i.esq);
         resp = i.elemento;
      }
      return resp;
   }


	// retorna a altura da arvore
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


	//metodo publico para remover elemento
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

   //metodo privado para remover elemento
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

   // Gerador de arq log
   static void log(long time){ 
    try {
        File myObj = new File("matrícula_arvoreBinaria.txt");
        if (myObj.createNewFile()) {
        } else {
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        FileWriter myWriter = new FileWriter("matrícula_arvoreBinaria.txt");
        myWriter.write("" + "\t" + time + "\t" + compareCounter);
        myWriter.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}


// no da arvore binaria - Max 
class No {
    public Serie elemento; // No
    public No esq, dir;  // Filhos da esq e dir.

    //construtor da classe
    public No(Serie elemento) {
        this(elemento, null, null);
    }
    public No(Serie elemento, No esq, No dir) {
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



public class Main{


    public static int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ 
                resp += line.charAt(i);
            } else {
                i = line.length();
            }
        }
        return Integer.parseInt(resp); //string -> int
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


    NumberOperations = justInt(MyIO.readLine());
    for(int i = 0; i < NumberOperations; i++)
    {
        Serie serie2 = new Serie();
        String input =  MyIO.readLine();

        if(input.charAt(0) == 'I')
        {
            input = input.substring(2);
            serie2.readClass(input);
            arvore.inserir(serie2);

        }

        if(input.charAt(0) == 'R')
        {
            input = input.substring(2);
            Serie serie3 = new Serie();
            input = input + ".html";
            input = input.replace(" ", "_");
            serie3.readClass(input);
            arvore.remover(serie3);
        }
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
    arvore.log(execTime);
    }
}