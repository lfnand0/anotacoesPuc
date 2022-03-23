import java.io.*;
import java.io.FileReader;
import java.time.Instant;

//Classe series
class Serie {
    private String nome;
    private String formato;
    private String duracao;
    private String pais;
    private String idioma;
    private String emissora;
    private String transmissao;
    private int temporada;
    private int episodios;

    // Contrutora primario
    public Serie() {
        nome = "";
        formato = "";
        duracao = "";
        pais = "";
        idioma = "";
        emissora = "";
        transmissao = "";
        temporada = ' ';
        episodios = ' ';
    }

    // Construtor secundario
    public Serie(String nome, String formato, String duracao, String pais, String idioma, String emissora,
            String transmissao, int temporada, int episodios) {
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.pais = pais;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.temporada = temporada;
        this.episodios = episodios;
    }

    // cloning
    public Serie clone() {
        Serie temp = new Serie();

        temp.nome = this.nome;
        temp.formato = this.formato;
        temp.duracao = this.duracao;
        temp.pais = this.pais;
        temp.idioma = this.idioma;
        temp.emissora = this.emissora;
        temp.transmissao = this.transmissao;
        temp.temporada = this.temporada;
        temp.episodios = this.episodios;

        return temp;
    }

    // sets
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public void setEmissora(String emissora) {
        this.emissora = emissora;
    }
    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }
    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    // Gets
    public String getNome() {
        return nome;
    }
    public String getFormato() {
        return formato;
    }
    public String getDuracao() {
        return duracao;
    }
    public String getPais() {
        return pais;
    }
    public String getIdioma() {
        return idioma;
    }
    public String getEmissora() {
        return emissora;
    }
    public String getTransmissao() {
        return transmissao;
    }
    public int getTemporada() {
        return temporada;
    }
    public int getEpisodios() {
        return episodios;
    }

    // prints
    public void printSerie() {
        MyIO.println(this.nome + " " + this.formato + " " + this.duracao + " " + this.pais + " " + this.idioma + " "
                + this.emissora + " " + this.transmissao + " " + this.temporada + " " + this.episodios);
    }

    // limpa as tags
    public String removeTag(String line) {
        String newLine = "";
        int i = 0;
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') {
                    i++;
                }
            } else if (line.charAt(i) == '&') {
                i++;
                while (line.charAt(i) != ';')
                    i++;
            } else {
                newLine += line.charAt(i);
            }
            i++;
        }
        return newLine;
    }

    public String forcaNome(String entrada) {
        String temp = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '_') {
                temp += ' ';
            } else {
                temp += entrada.charAt(i);
            }
        }
        temp = temp.substring(0, temp.length() - 5);
        return temp;
    }

    public int apenasInt(String line) {
        String temp = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                temp += line.charAt(i);
            } else {
                i = line.length();
            }
        }
        return Integer.parseInt(temp); 
    }

    public void lerSerie(String entrada) {
        String arquivo = "/tmp/series/" + entrada;
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fileReader);

            setNome(forcaNome(entrada).trim());

            while (!br.readLine().contains("Formato"))
                ;
            setFormato(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("Duração"))
                ;
            setDuracao(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("País de origem"))
                ;
            setPais(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("Idioma original"))
                ;
            setIdioma(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("Emissora de televisão original"))
                ;
            setEmissora(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("Transmissão original"))
                ;
            setTransmissao(removeTag(br.readLine()).trim());

            while (!br.readLine().contains("N.º de temporadas"))
                ;
            setTemporada(apenasInt(removeTag(br.readLine())));

            while (!br.readLine().contains("N.º de episódios"))
                ;
            setEpisodios(apenasInt(removeTag(br.readLine())));

            br.close();

        } catch (FileNotFoundException e) {
            MyIO.println("ERROR: Unable to open file '" + entrada + "'");
        } catch (IOException e) {
            MyIO.println("ERROR: Error reading file '" + entrada + "'");
        }
    }

}

// Classe no
class No {
    public Serie item; 
    public No esq, dir; 

    public No(Serie item) {
        this(item, null, null);
    }

    public No(Serie item, No esq, No dir) {
        this.item = item;
        this.esq = esq;
        this.dir = dir;
    }
}

class TreeSort {
    private No raiz;
    private int n;

    public TreeSort() {
        raiz = null;
        n = 0;
    }

    //metodo de ordenação
    public Serie[] sort() {
        Serie[] a = new Serie[n];
        n = 0;
        sort(raiz, a);
        return a;
    }

    //metodo de ordenação recursivo
    private void sort(No i, Serie[] a) {
        if (i != null) {
            sort(i.esq, a);
            a[n++] = i.item;
            sort(i.dir, a);
        }
    }

    //metodo para insert
    public void insert(Serie x) {
        n++;
        raiz = insert(x, raiz);
    }

    //metodo para insert recursivo
    private No insert(Serie x, No i) {
        if (i == null) {
            i = new No(x);
        } else if (x.getNome().compareTo(i.item.getNome()) < 0) {
            i.esq = insert(x, i.esq);
        } else if (x.getNome().compareTo(i.item.getNome()) >= 0) {
            i.dir = insert(x, i.dir);
        }

        return i;
    }
}

public class main {
    //finalizador do programa
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        long programStartTime = Instant.now().toEpochMilli();
        TreeSort arvore = new TreeSort();
        String[] entrada = new String[10000];
        Serie serie = new Serie();
        int n = 0;

        do {
            entrada[n] = MyIO.readLine();
        } while (isFim(entrada[n++]) == false);
        for (int i = 0; i < (n - 1); i++) {
            serie.lerSerie(entrada[i]);
            arvore.insert(serie.clone());
        }

        Serie[] a = arvore.sort();
        for(int i = 0; i < a.length; i++){
            a[i].printSerie();
        }

        try {
            RandomAccessFile log = new RandomAccessFile("matrícula_treesort.txt", "rw");
            long totalRuntime = Instant.now().toEpochMilli() - programStartTime;
            log.writeChars(String.format("727480\t%d\t%d", totalRuntime, 0));
            log.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
