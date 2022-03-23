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
 * @author Max do Val Machado
 */
class No {
    public Serie elemento; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Serie elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No(Serie elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore{
    private No raiz;
    private int compareCounter;
    
    public Arvore() {
        raiz = null;
    }

    public void inserir(Serie item) throws Exception{
        raiz = inserir(item, raiz);
    }

    private No inserir(Serie item, No i) throws Exception{
        if (i == null) {
            i = new No(item);
        } else if (item.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(item, i.esq);
        } else if (item.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(item, i.dir);
        } else {
            throw new Exception("Erro: o item já existe na árvore");
        }
        compareCounter++;

        return i;
    }

    public void remover(String nome) throws Exception {
        raiz = remover(nome, raiz);
    }

    private No remover(String nome, No i) throws Exception {
        if (i != null) {
            if (nome.compareTo(i.elemento.getNome()) < 0) {
                i.esq = remover(nome, i.esq);
                compareCounter++;
            } else if (nome.compareTo(i.elemento.getNome()) > 0) {
                i.dir = remover(nome, i.dir);
                compareCounter++;
            } else if (i.dir == null) {
                i = i.esq;
            } else if (i.esq == null) {
                i = i.dir;
            } else {
                i.esq = maiorEsq(i, i.esq);
            }
        }
        
        return i;
    }

    public void pesquisar(String nome) {
        System.out.print(" raiz ");
        if (pesquisar(nome, raiz)) {
            System.out.print("SIM\n");
        } else {
            System.out.print("NAO\n");
        }
    }

    private boolean pesquisar(String nome, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (nome.compareTo(i.elemento.getNome()) == 0) {
            resp = true;
            // System.out.println("achou");
            compareCounter++;
        } else if (nome.compareTo(i.elemento.getNome()) < 0) {
            System.out.print("esq ");
            resp = pesquisar(nome, i.esq);
            compareCounter++;
        } else {
            System.out.print("dir ");
            resp = pesquisar(nome, i.dir);
            compareCounter++;
        }

        return resp;
    }

    /**
	 * Método para trocar o elemento "removido" pelo maior da esquerda.
	 * @param i Nó que teve o elemento removido.
	 * @param j Nó da subarvore esquerda.
	 * @return Nó em análise, alterado ou não.
	 */
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

    public void mostrar() {
        mostrar(raiz);
    }

    private void mostrar(No i) {
        if (i != null) {
            mostrar(i.esq);
            i.elemento.imprimir();
            mostrar(i.dir);
        }
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_treesort.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_treesort.txt");
            myWriter.write("727245" + "\t" + compareCounter + "\t" + time);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class TP04Q05 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        long startTime = System.nanoTime();
        String[] entrada = new String[1000];
        Arvore arvore = new Arvore();

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
            } catch (Exception e) {}  
        }

        arvore.mostrar();

        long duration = System.nanoTime() - startTime;
        arvore.matricula(duration);
    }
}
