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

        while (!br.readLine().contains("Formato"));
        this.setFormato(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Duração"));
        this.setDuracao(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("País de origem"));
        this.setPaisDeOrigem(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Idioma original"));
        this.setIdioma(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Emissora de televisão original"));
        this.setEmissora(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("Transmissão original"));
        this.setTransmissao(removeTags(br.readLine()).replaceAll("&#160;", "").replaceAll("&nbsp;", "").trim());

        while (!br.readLine().contains("N.º de temporadas"));
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

class Celula {
    public int Elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this(elemento, null, null, null, null);
    }

    public Celula(int item, Celula inferior, Celula superior, Celula esquerda, Celula direita) {
        elemento = item;
        sup = superior;
        inf = inferior;
        esq = esquerda;
        dir = direita;
    }
}


class Matriz {
    private Celula[][] matriz;
    private Celula inicio;
    private int linha;
    private int coluna;

    public Matriz(int l, int c) {
        matriz = new Celula[l][c];
        linha = l;
        coluna = c;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = new Celula();
            }
        }

        for (int i = 0; i < l; i++) {
            for (j = 0; j < c; j++) {
                if (j == 0) {
                    matriz[i][j].esq = null; 
                } else {
                    matriz[i][j].esq = matriz[i][j - 1];
                }

                if (j == c - 1) {
                    matriz[i][j].dir = null;
                } else {
                    matriz[i][j].dir = matriz[i][j + 1];
                }

                if (i == 0) {
                    matriz[i][j].sup = null; 
                } else {
                    matriz[i][j].sup = matriz[i - 1][j];
                }

                if (i == l - 1) {
                    matriz[i][j].inf = null;
                } else {
                    matriz[i][j].inf = matriz[i + 1][j];
                }
            }
        }
    }
}


/**
 * Classe Lista duplamente encadeada
 * 
 * @author Luiz Fernando Oliveira Maciel
 * 
 */
class Lista {
    private CelulaDupla primeira;
    private CelulaDupla ultima;
    private int n;
    private int compareCounter;
    private int swapCounter;

    /**
     * Construtor da classe.
     */
    public Lista() {
        primeira = new CelulaDupla();
        ultima = primeira;
        n = 0;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * 
     * @param item a ser inserido.
     */
    public void inserirFim(Serie item) {
        ultima.prox = new CelulaDupla(item, ultima, null);
        ultima = ultima.prox;
        n++;
    }

    /**
     * Troca duas células (a e b) de posição
     * 
     */
    public void swap(CelulaDupla a, CelulaDupla b) {
        Serie temp = a.elemento;
        a.elemento = b.elemento;
        b.elemento = temp;

        swapCounter++;
    }

    /**
     * Retorna o ponteiro da celna posição x
     * 
     * @param x: posicao
     * @return Célula a ser retornada
     * @return null se a posição for inválida
     */
    public CelulaDupla posicao(int x) {
        CelulaDupla retorno = null;
        if (x < n) {
            int i = n - 1;
            retorno = ultima;
            while (i > x) {
                retorno = retorno.ant;
                i--;
            }
        }

        return retorno;
    }

    public void teste() {
        mostrar();

        swap(primeira.prox.prox, primeira.prox.prox.prox.prox);
        MyIO.println("----------------------------------");
        mostrar();
    }

    /**
     * Printa todos os elementos da lista
     */
    public void mostrar() {
        for (CelulaDupla i = primeira.prox; i != null; i = i.prox) {
            i.elemento.imprimir();
        }
    }

    /**
     * Compara duas séries de acordo com o atributo paisDeOrigem, e caso eles sejam
     * iguais, compara de acordo com o atributo nome
     */
    public int comparar(Serie a, Serie b) {
        String str1 = a.getPaisDeOrigem(), str2 = b.getPaisDeOrigem().trim();
        if (str1.compareTo(str2) == 0) {
            str1 = a.getNome().trim();
            str2 = b.getNome().trim();
        }

        compareCounter += 2;
        return str1.compareTo(str2);
    }

    /**
     * Ordena a lista de acordo com o atributo paisDeOrigem utilizando o algoritmo
     * Quicksort
     */
    public void ordenar() {
        long startTime = System.nanoTime();
        
        quicksort(0, n-1);

        long duration = System.nanoTime() - startTime;
        this.matricula(duration);
    }

    /**
     * Função recursiva de quicksort
     * 
     * @param esq: limite inferior 
     * @param dir: limite superior
     */
    public void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        Serie pivo = posicao((dir + esq) / 2).elemento;

        while (i <= j) {
            while (comparar(posicao(i).elemento, pivo) < 0) {
                i++;
            }

            while (comparar(posicao(j).elemento, pivo) > 0) {
                j--;
            }

            if (i <= j) {
                swap(posicao(i), posicao(j));

                i++;
                j--;
            }
        }

        if (esq < j) quicksort(esq, j);
        if (i < dir) quicksort(i, dir);
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_quicksort2.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_quicksort2.txt");
            myWriter.write("727245" + "\t" + compareCounter + "\t" + swapCounter + "\t" + time);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TP03Q14 {
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

        Lista lista = new Lista();

        for (int i = 0; i < numEntrada; i++) {
            Serie serie = new Serie();

            try {
                serie.ler(entrada[i]);
            } catch (Exception e) {
            }

            lista.inserirFim(serie);
        }
        // lista.teste();
        
        lista.ordenar();
        lista.mostrar();
    }
}
