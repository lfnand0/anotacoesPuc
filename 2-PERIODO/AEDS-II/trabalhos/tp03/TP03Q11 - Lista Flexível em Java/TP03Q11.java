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
public class Celula {
	public Serie elemento;
	public Celula prox;

    public Celula() {
    	this.item = null;
        this.prox = null;
    }  

    public Celula(Serie serie) {
        this.item = serie;
        this.prox = null;
    } 

    public Celula(Serie serie, Celula proxima) {
        this.elemento = serie;
        this.prox = proxima;
    }  	
}

/**
 * Classe Lista (com alocação flexível)
 * 
 * @author Luiz Fernando Oliveira Maciel
 * 
 */
class Lista {
    private Celula primeira;
	private Celula ultima;
    private int n;
    private int compareCounter;
    private int swapCounter;

    /**
     * Construtor da classe.
     */
    public Lista() {
        this.primeira = new Celula();
        this.ultima = this.primeira;
    }

    /**
     * Insere um elemento na primeira posicao da lista e desloca os demais elementos
     * para o fim da lista.
     * 
     * 
     * @param Elemento a ser inserido.
     */
    public void inserirInicio(Serie item) {
        Celula aux = new Celula(item, this.primeira);
        if (this.primeira.elemento == null && this.primeira.prox == null) {
            this.ultima = aux;
        }
        
        this.primeira = aux;
		n++;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * 
     * @param Elemento a ser inserido.
     */
    public void inserirFim(Serie item) {
        // validar insercao
        if (n < array.length) {
            array[n] = item;
            n++;
        }
    }

    /**
     * Insere um elemento em uma posicao especifica e move os demais elementos para
     * o fim da lista.
     * 
     * 
     * @param item: elemento a ser inserido.
     * 
     * @param pos:  Posicao de insercao.
     */
    public void inserir(Serie item, int pos) {

        // validar insercao
        if (n < array.length && pos >= 0 && pos <= n) {
            // Desloca elementos para o fim do array
            for (int i = n; i > pos; i--)
                array[i] = array[i - 1];

            array[pos] = item;
            n++;
        }
    }

    /**
     * Remove um elemento da primeira posicao da lista e movimenta os demais
     * elementos para o inicio da mesma.
     * 
     * 
     * @return Elemento a ser removido.
     */
    public Serie removerInicio() {
        if (n > 0) {
            Serie item = array[0];
            n--;

            for (int i = 0; i < n; i++)
                array[i] = array[i + 1];

            return item;
        }
        return null;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * 
     * @return Elemento a ser removido.
     */
    public Serie removerFim() {
        if (n > 0)
            return array[--n];
        return null;
    }

    /**
     * Remove um elemento de uma posicao especifica da lista e movimenta os demais
     * elementos para o inicio da mesma.
     * 
     * 
     * @param pos: Posicao de remocao.
     * 
     * @return Elemento a ser removido.
     */
    public Serie remover(int pos) {
        if (n > 0 && pos >= 0 && pos < n) {
            Serie item = array[pos];
            n--;

            for (int i = pos; i < n; i++)
                array[i] = array[i + 1];

            return item;
        }
        return null;
    }

    /**
     * Printa todos os elementos da lista
     */
    public void mostrar() {
        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }
}

class TP03Q11 {
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

        Lista lista = new Lista(numEntrada);

        for (int i = 0; i < numEntrada; i++) {
            Serie serie = new Serie();

            try {
                serie.ler(entrada[i]);
            } catch (Exception e) {
            }

            lista.inserirFim(serie);
        }

        lista.ordenar();
        lista.mostrar();
    }
}
