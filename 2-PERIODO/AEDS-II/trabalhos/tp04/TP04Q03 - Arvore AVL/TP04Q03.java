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
 * No da arvore binaria
 * 
 * @author Max do Val Machado
 */
class No {
    public Serie elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.
    public int nivel;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(Serie elemento) {
        this(elemento, null, null, 1);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(Serie elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
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

class AVL {
    private No raiz;
    private int compareCounter;

    public AVL() {
        raiz = null;
    }

    public void inserir(Serie item) throws Exception {
        raiz = inserir(item, raiz);
    }

    private No inserir(Serie item, No i) throws Exception {
        if (i == null) {
            i = new No(item);
        } else if (item.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(item, i.esq);
        } else if (item.getNome().compareTo(i.elemento.getNome()) > 0) {
            compareCounter++;
            i.dir = inserir(item, i.dir);
        } else {
            compareCounter++;
            throw new Exception("Erro: o item já existe na árvore");
        }
        compareCounter++;

        return balancear(i);
    }

    public Serie remover(Serie item) throws Exception {
        raiz = remover(item, raiz);
        return item;
    }

    private No remover(Serie item, No i) throws Exception {
        if (item.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = remover(item, i.esq);
        } else if (item.getNome().compareTo(i.elemento.getNome()) > 0) {
            compareCounter++;
            i.dir = remover(item, i.dir);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        compareCounter++;

        return balancear(i);
    }

    public boolean pesquisar(String nome) {
        boolean retorno = pesquisar(nome, raiz);
        System.out.println(retorno ? "SIM" : "NAO");

        return retorno;
    }

    private boolean pesquisar(String nome, No i) {
        boolean retorno = false;
        if (i == raiz) {
            System.out.print("raiz ");
        }

        if (i == null) {
            retorno = false;
        } else if (nome.compareTo(i.elemento.getNome()) == 0) {
            retorno = true;
        } else if (nome.compareTo(i.elemento.getNome()) < 0) {
            compareCounter++;
            retorno = pesquisar(nome, i.esq);
            System.out.print("esq ");
        } else {
            compareCounter++;
            retorno = pesquisar(nome, i.dir);
            System.out.print("dir ");
        }

        compareCounter++;
        return retorno;
    }

    private No maiorEsq(No i, No j) {
        // Encontrou o máximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
            // Existe nó à direita.
        } else {
            // Caminha para a direita.
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }

    private No balancear(No i) {
        if (i != null) {
            int f = No.getNivel(i.dir) - No.getNivel(i.esq);
            if (Math.abs(f) <= 1) {
                i.setNivel();
            } else if (f == 2) {
                int fatorFilhoDir = No.getNivel(i.dir.dir) - No.getNivel(i.dir.esq);
                if (fatorFilhoDir == -1) {
                    i.dir = rotacionarDir(i.dir);
                }
                i = rotacionarEsq(i);
            } else if (f == -2) {
                int fatorFilhoEsq = No.getNivel(i.esq.dir) - No.getNivel(i.esq.esq);
                if (fatorFilhoEsq == 1) {
                    i.esq = rotacionarEsq(i.esq);
                }
                i = rotacionarDir(i);
            }
        }
        return i;
    }

    private No rotacionarDir(No i) {
        No noEsq = i.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = i;
        i.esq = noEsqDir;
        i.setNivel();
        noEsq.setNivel();

        return noEsq;
    }

    private No rotacionarEsq(No i) {
        No noDir = i.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = i;
        i.dir = noDirEsq;

        i.setNivel();
        noDir.setNivel();
        return noDir;
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_avl.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_avl.txt");
            myWriter.write("727245" + "\t" + compareCounter + "\t" + time);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TP04Q03 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        // MyIO.setCharset("UTF-8");
        long startTime = System.nanoTime();
        String[] entrada = new String[1000];
        AVL arvore = new AVL();

        int numEntrada = 0;

        // Leitura da entrada padrão
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        for (int i = 0; i < numEntrada; i++) {
            Serie serie = new Serie();

            try {
                serie.ler(entrada[i]);
                arvore.inserir(serie);
            } catch (Exception e) {
            }
        }

        numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        for (int i = 0; i < numEntrada; i++) {
            // System.out.println(entrada[i] + "-- ");
            arvore.pesquisar(entrada[i]);
        }

        long duration = System.nanoTime() - startTime;
        arvore.matricula(duration);
    }
}
