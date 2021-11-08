import java.io.*;
import java.util.*;
import java.lang.*;

class Serie {
    private String nome;
    private String formato;
    private String duracao;
    private String paisDeOrigem;
    private String idioma;
    private String emissora;
    private String transmissao;
    private int numeroDeTemporadas;
    private int numeroDeEpisodios;

    // CONSTRUTORES
    Serie() {
        nome = "";
        formato = "";
        duracao = "";
        paisDeOrigem = "";
        idioma = "";
        emissora = "";
        transmissao = "";
        numeroDeEpisodios = 0;
        numeroDeTemporadas = 0;
    }

    Serie(String nome, String formato, String duracao, String paisDeOrigem, String idioma, String emissora,
            String transmissao, int numeroDeTemporadas, int numeroDeEpisodios) {
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.paisDeOrigem = paisDeOrigem;
        this.idioma = idioma;
        this.emissora = emissora;
        this.transmissao = transmissao;
        this.numeroDeEpisodios = numeroDeEpisodios;
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    // SETTERS
    public void setNome(String s) {
        if (s != null) {
            this.nome = s;
        }
    }

    public void setFormato(String s) {
        if (s != null) {
            this.formato = s;
        }
    }

    public void setDuracao(String s) {
        if (s != null) {
            this.duracao = s;
        }
    }

    public void setPaisDeOrigem(String s) {
        if (s != null) {
            this.paisDeOrigem = s;
        }
    }

    public void setIdioma(String s) {
        if (s != null) {
            this.idioma = s;
        }
    }

    public void setEmissora(String s) {
        if (s != null) {
            this.emissora = s;
        }
    }

    public void setTransmissao(String s) {
        if (s != null) {
            this.transmissao = s;
        }
    }

    public void setNumeroDeTemporadas(int n) {
        if (n > 0) {
            this.numeroDeTemporadas = n;
        }
    }

    public void setNumeroDeEpisodios(int n) {
        if (n > 0) {
            this.numeroDeEpisodios = n;
        }
    }

    // GETTERS
    public String getNome() {
        return this.nome;
    }

    public String getFormato() {
        return this.formato;
    }

    public String getDuracao() {
        return this.duracao;
    }

    public String getPaisDeOrigem() {
        return this.paisDeOrigem;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public String getEmissora() {
        return this.emissora;
    }

    public String getTransmicao() {
        return this.transmissao;
    }

    public int getNumeroDeEpisodios() {
        return this.numeroDeEpisodios;
    }

    public int getNumeroDeTemporadas() {
        return this.numeroDeTemporadas;
    }

    public void imprimir() {
        MyIO.println(this.nome + " " + this.formato + " " + this.duracao + " " + this.paisDeOrigem + " " + this.idioma
                + " " + this.emissora + " " + this.transmissao + " " + numeroDeTemporadas + " " + numeroDeEpisodios);
    }

    String removeTags(String s) {
        String retorno = "";
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '<') {
                i++;
                while (s.charAt(i) != '>') {
                    i++;
                }
            } else {
                retorno += s.charAt(i);
            }
            i++;
        }
        return retorno;
    }

    public void ler(String html) throws Exception {
        String nome = "";
        int pos = 0;
        while (html.charAt(pos) != '.' && pos < html.length()) {
            nome += html.charAt(pos++);
        }
        nome = nome.replace('_', ' ');
        this.nome = nome;

        html = "/tmp/series/" + html;

        InputStreamReader isr = new InputStreamReader(new FileInputStream(html));
        BufferedReader br = new BufferedReader(isr);

        while (!br.readLine().contains("Formato"))
            ;
        this.setFormato(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Duração"))
            ;
        this.setDuracao(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("País de origem"))
            ;
        this.setPaisDeOrigem(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Idioma original"))
            ;
        this.setIdioma(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Emissora de televisão original"))
            ;
        this.setEmissora(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Transmissão original"))
            ;
        this.setTransmissao(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("N.º de temporadas"))
            ;
        String temp = removeTags(br.readLine()).trim();
        int num = 0;
        int i = 0;
        while (i < temp.length()) {
            if ((int) temp.charAt(i) >= 48 && (int) temp.charAt(i) <= 57) {
                num = num * 10 + temp.charAt(i) - '0';
                i++;
            } else {
                i = temp.length();
            }
        }
        this.setNumeroDeTemporadas(num);

        while (!br.readLine().contains("N.º de episódios"))
            ;
        temp = removeTags(br.readLine()).trim();
        num = i = 0;
        while (i < temp.length()) {
            if ((int) temp.charAt(i) >= 48 && (int) temp.charAt(i) <= 57) {
                num = num * 10 + temp.charAt(i) - '0';
                i++;
            } else {
                i = temp.length();
            }
        }
        this.setNumeroDeEpisodios(num);

        br.close();
    }
}


/**
 * Classe Célula
 * 
 * @author Luiz Fernando Oliveira Maciel
 * 
 */
class Celula {
	public Serie elemento;
	public Celula prox;

    public Celula() {
        elemento = null;
        prox = null;
    }  

    public Celula(Serie serie) {
        elemento = serie;
        prox = null;
    }

    public Celula(Serie serie, Celula proxima) {
        elemento = serie;
        prox = proxima;
    }
}

/**
 * Classe FIla (com alocação flexível)
 * 
 * @author Luiz Fernando Oliveira Maciel
 * 
 */
class Fila {
    public Celula frente;
    public Celula tras;
    public int n;
    public int tamanho;

    public Fila() {
        frente = new Celula();
        tras = frente;
        tamanho = 5;
        n = 0;
    }

    /**
     * Adiciona um item ao fim da fila, e caso a fila
     * esteja cheia, retira o elemento da frente e adiciona
     * 
     * @param item a ser adicionado
     */
    public void enfileirar(Serie item) {
        if (n < tamanho) {
            tras.prox = new Celula(item);
            tras = tras.prox;
            getMedia();
            n++;
        } else {
            desenfileirar();
            enfileirar(item);
        }
    }

    /**
     * Remove a célula na frente da fila
     * 
     * @return Serie a ser removida
     * @return null quando a fila está vazia
     */
    public Serie desenfileirar(){
        Serie retorno = null;

        if (frente != tras && n > 0) {
            Celula aux = frente;
            frente = frente.prox;

            retorno = frente.elemento;

            aux.prox = null;
            aux = null;

            n--;
        }

        return retorno;
    }

    /**
     * Calcula a média do número de temporadas de todas as séries da fila
     * 
     */
    public void getMedia() {
        double media = 0;
        double total = 0;
        for (Celula temp = frente.prox; temp != null; temp = temp.prox) {
            media += temp.elemento.getNumeroDeTemporadas();
            total++;
        }

        media = media / total;
        media = Math.round(media);
        MyIO.println((int) media);
    }

    /**
     * Imprime a fila do primeiro elemento ao último
     * 
     */
    public void mostrar() {
        for (Celula temp = frente.prox; temp != null; temp = temp.prox) {
            temp.elemento.imprimir();
        }
    }
}

class TP03Q13 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];

        int numEntrada = 0;

        // Leitura da entrada padrão
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        Fila fila = new Fila();

        for (int i = 0; i < numEntrada; i++) {
            Serie serie = new Serie();

            try {
                serie.ler(entrada[i]);
                fila.enfileirar(serie);
            } catch (Exception e) {
            }
        }

        entrada = new String[1000];
        String temp = MyIO.readLine().trim();
        numEntrada = 0;
        for (int i = 0; i < temp.length(); i++) {
            numEntrada = numEntrada * 10 + temp.charAt(i) - '0';
        }

        for (int i = 0; i < numEntrada; i++) {
            Serie serie = new Serie();
            String linha = MyIO.readLine();
            String comando = "" + linha.charAt(0);
            int pos = 0;
            if (comando.equals("I") == true) {
                try {
                    serie.ler(linha.substring(2).trim());
                } catch (Exception e) {}

                fila.enfileirar(serie);
            } else if (comando.equals("R") == true) {
                fila.desenfileirar();
            }
        }
    }
}
