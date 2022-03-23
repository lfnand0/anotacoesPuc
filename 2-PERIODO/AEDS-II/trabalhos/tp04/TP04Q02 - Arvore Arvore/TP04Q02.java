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
    public char item; // Conteudo do no.
    public No esq, dir;  // Filhos da esq e dir.
    public No2 arvore;

    /**
     * Construtor da classe.
     * @param item Conteudo do no.
     */
    public No (char item) {
        this(item, null, null, null);
    }

    /**
     * Construtor da classe.
     * @param item Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    public No (char item, No esq, No dir, No2 arvore) {
        this.item = item;
        this.esq = esq;
        this.dir = dir;
        this.arvore = arvore;
    }
}

class No2 {
    public String item;
    public No2 esq, dir;

    public No2 (String item) {
        this(item, null, null);
    }

    public No2 (String item, No2 esq, No2 dir) {
        this.item = item;
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

    public void inserirBase(char x) throws Exception{
        raiz = inserirBase(x, raiz);
    }

    private No inserirBase(char x, No i) throws Exception {
        if (i == null) {
            i = new No(x);
        } else if (x < i.item) {
            i.esq = inserirBase(x, i.esq);
        } else if (x > i.item) {
            i.dir = inserirBase(x, i.dir);
        } else {
            throw new Error("Erro: inserirBase");
        }

        return i;
    }

    public void inserir(String x) throws Exception {
        raiz = inserir(x, raiz);
    }

    private No inserir(String x, No i) throws Exception {
        if (i == null) {
            i = new No(x.charAt(0));
            i.arvore = inserirArvore(x, i.arvore);
        } else if (x.charAt(0) < i.item) {
            i.esq = inserir(x, i.esq);
        } else if (x.charAt(0) > i.item) {
            i.dir = inserir(x, i.dir);
        } else {
            i.arvore = inserirArvore(x, i.arvore);
        }

        return i;
    }

    private No2 inserirArvore(String x, No2 i) throws Exception {
        if (i == null) {
            i = new No2(x);
        } else if (x.compareTo(i.item) < 0) {
            compareCounter++;
            i.esq = inserirArvore(x, i.esq);
        } else if (x.compareTo(i.item) > 0) {
            compareCounter += 2;
            i.dir = inserirArvore(x, i.dir);
        } else {
            compareCounter += 2;
            throw new Error("Erro: inserirArvore");
        }

        return i;
    }

    public void remover(String x) throws Exception {
        raiz = remover(x, raiz);
    }

    public No remover(String x, No i) throws Exception{
        if (i != null) {
            if (x.charAt(0) == i.item) {
                i.arvore = removerArvore(x, i.arvore);
            } else if (x.charAt(0) < i.item) {
                i.esq = remover(x, i.esq);
            } else if (x.charAt(0) > i.item) {
                i.dir = remover(x, i.dir);
            } else {
                throw new Error("Erro: remover");
            }
        } else {
            throw new Error("Erro: remover");
        }

        return i;
    }

    private No2 removerArvore(String x, No2 i) throws Exception {
        if (i != null) {
            if (x.compareTo(i.item) < 0) {
               i.esq = removerArvore(x, i.esq); 
            } else if (x.compareTo(i.item) > 0) {
                compareCounter++;
                i.dir = removerArvore(x, i.dir);
            } else if (i.dir == null) {
                i = i.esq;
            } else if (i.esq == null) {
                i = i.dir;
            } else {
                i.esq = maiorEsq(i, i.esq);
            }

            compareCounter++;
        } else {
            throw new Error("Erro: removerArvore");
        }

        return i;
    }

    private No2 maiorEsq(No2 i, No2 j) {
        if (j.dir == null) {
            i.item = j.item;
            j = j.esq;
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        
        return j;
    }

    public boolean pesquisar(String x) {
        System.out.print("raiz");
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(String x, No i) {
        boolean retorno = false;
        if (i != null) {
            if (i.arvore != null) {
                retorno = pesquisarArvore(x, i.arvore);
            }

            if (!retorno) {
                System.out.print(" esq");
                retorno = pesquisar(x, i.esq);

                if (!retorno) {
                    System.out.print(" dir");
                    retorno = pesquisar(x, i.dir);
                }
            }
        }
    
        return retorno;
    }

    private boolean pesquisarArvore (String x, No2 i) {
        boolean retorno = false;
        if (i != null) {
            if (x.compareTo(i.item) == 0) {
                retorno = true;
            } else {
                System.out.print(" ESQ");
                retorno = pesquisarArvore(x, i.esq);

                if (!retorno) {
                    System.out.print(" DIR");
                    retorno = pesquisarArvore(x, i.dir);
                }
            }

            compareCounter++;
        }
        
        return retorno;
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_arvoreArvore.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_arvoreArvore.txt");
            myWriter.write("727245" + "\t" + compareCounter + "\t" + time);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class TP04Q02 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        // MyIO.setCharset("UTF-8");
        long startTime = System.nanoTime();
        String[] entrada = new String[1000];
        Arvore arvore = new Arvore();
        char[] base = { 'D', 'R', 'Z', 'X', 'V', 'B', 'F', 'P', 'U', 'I', 'G', 'E', 'J', 'L', 'H', 'T', 'A', 'W', 'S',
        'O', 'M', 'N', 'K', 'C', 'Y', 'Q' };

        for (int i = 0; i < base.length; i++) {
            try {
                arvore.inserirBase(base[i]);
            } catch (Exception e) {}
        }

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
                arvore.inserir(serie.getNome());
            } catch (Exception e) {}  
        }

        numEntrada = 0;
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        for (int i = 0; i < numEntrada; i++) {
            if (arvore.pesquisar(entrada[i])) {
                System.out.println(" SIM");
            } else {
                System.out.println(" NAO");
            }
        }

        long duration = System.nanoTime() - startTime;
        arvore.matricula(duration);
    }
}
