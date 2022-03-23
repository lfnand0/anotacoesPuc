import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;

class Serie2{
    //declarando
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
    public Serie2(){
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
    public Serie2(String name, String format, String duration, String country, String language, String broadcaster, String streaming, int seasons, 
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
    }

    //sets
    public void setName(String name){
        this.name = name;}
    public void setFormat(String format){
        this.format = format;}
    public void setDuration(String duration){
        this.duration = duration;}
    public void setCountry(String country){
        this.country = country;}
    public void setLanguage(String language){
        this.language = language;}
    public void setBroadcaster(String broadcaster){
        this.broadcaster = broadcaster;}
    public void setStreaming(String streaming){
        this.streaming = streaming;}
    public void setSeasons(int seasons){
        this.seasons = seasons;}
    public void setEpisodes(int episodes){
        this.episodes = episodes;
    }

    //returns
    public String getName(){ 
        return this.name; }
    public String getFormat(){ 
        return this.format; }
    public String getDuration(){ 
        return this.duration; }
    public String getCountry(){
        return this.country; }
    public String getLanguage(){ 
        this.language = this.language.trim(); 
        return this.language; }
    public String getBroadcaster(){ 
        return this.broadcaster; }
    public String getStreaming(){ 
        return this.streaming; }
    public int getSeasons(){ 
        return this.seasons; }
    public int getEpisodes(){ 
        return this.episodes; }

        
    //clone
    public Serie2 clone(){
        Serie2 resp = new Serie2();
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
    //print class
    public void printClass(){
        System.out.println(this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes);
    }
    public String toString() {
        return this.name + " " + this.format + " " + this.duration + " " + this.country + " " + this.language + " " + this.broadcaster + " " +
        this.streaming + " " + this.seasons + " " + this.episodes;
	}
    //tratando linha
    public int justInt(String line){
        String resp = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9'){ //nmbr -> resp
                resp += line.charAt(i);
            } else { 
                i = line.length();
            }
        }
        return Integer.parseInt(resp); 
    }

    //remove tags
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

    public String searchName(String fileName){
        String resp = "";
        for(int i = 0; i < fileName.length(); i++){
            if(fileName.charAt(i)  == '_'){ //caso o caracter na posição i seja igual ao '_' a variável resp recebe um espaço em branco
                resp += ' ';
            } else { //caso não tenha espaço em branco o caracter é concatenado à string resp
                resp += fileName.charAt(i);
            }
        }
        return resp.substring(0, resp.length()-5); //retorno da substring resp retirando os 5 últimos caracteres relacionados à extensão do arquivo
    }
    //le arq .html
    public void readClass(String fileName){
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
            
            //mostrar class
            //fechar br
            br.close();         
        //Tratamento de exceções
        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");                
        } catch(IOException e) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }
}   
   
class Hash {
    Serie2 tabela[];
    int m;
    Serie2 NULO = null;
    public Hash (){
        this(21);
    }
	public Hash (int m){
        this.m = m;
        this.tabela = new Serie2 [this.m];
        for(int i = 0; i < m; i++){
                tabela[i] = NULO;
        }
    }
    public int h(String elemento){
        int ascii =0;
        for(int i = 0; i < elemento.length() ; i++){   
            char character = elemento.charAt(i); 
            ascii += (int) character;
        }
        return ascii % m;
    }
    public int reh(String elemento){
        int ascii2 =0;
        for(int i = 0; i < elemento.length() ; i++){   
            char character = elemento.charAt(i); 
            ascii2 = (int) character;
        }
        return ++ascii2 % m;
    }
    public boolean inserir (Serie2 elemento){
        boolean resp = false;

        if(elemento != NULO){
            int pos = h(elemento.getName());
            if(tabela[pos] == NULO){
                tabela[pos] = elemento;
                resp = true;

            } else{
                pos = reh(elemento.getName());
                if(tabela[pos] == NULO){
                    tabela[pos] = elemento;
                    resp = true;
                }
            }
        }
        return resp;
    }
    public boolean pesquisar (String elemento){
        boolean resp = false;
        int pos = h(elemento);
        if(tabela[pos] == NULO){
            return false;
        }
        else{
        if(tabela[pos].getName().equals(elemento)){
            resp = true;

        } else {
            pos = reh(elemento);
            if(tabela[pos].getName().equals(elemento)){
                resp = true;
            }
        }
    }
        return resp;
    }

}


class main {
    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main (String []args){  
        String entrada = MyIO.readLine();
        Serie2 serie = new Serie2();   
        Hash a = new Hash();
        do{
            serie = new Serie2();
            try{
                serie.readClass(entrada);
            }catch(Exception e){}
            try {
                a.inserir(serie);
            } catch (Exception e) {
            }
            entrada = MyIO.readLine();
        }while(isFim(entrada)!=true);
        String entrada2 = "";
        do {
            entrada2 = MyIO.readLine(); 
            if(isFim(entrada2) != true){
            if(a.pesquisar(entrada2)==true)
            System.out.print(" SIM");
            else
            System.out.print(" NAO");
            }
            System.out.print("\n");
        } while (isFim(entrada2) != true);
        entrada = "";
    }
}
