import java.io.*;
import java.io.FileReader;
import java.time.Instant;


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

    // construtor primario
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

    // construtor secundario
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

    // Contrutor de clone
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

    // Métodos Get
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

    // print
    public void printSerie() {
        MyIO.println(this.nome + " " + this.formato + " " + this.duracao + " " + this.pais + " " + this.idioma + " "
                + this.emissora + " " + this.transmissao + " " + this.temporada + " " + this.episodios);
    }

    //limpa string
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

    // pega apenas os int
    public int apenasInt(String line) {
        String temp = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                temp += line.charAt(i);
            } else {
                i = line.length();
            }
        }
        return Integer.parseInt(temp); // string -> int
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

class No1 {
    public char item; 
    public No1 esq, dir; 
    public No2 arvore;

    // Construtor
    public No1(char item) {
        this(item, null, null, null);
    }

    // Construtor
    public No1(char item, No1 esq, No1 dir, No2 arvore) {
        this.item = item;
        this.esq = esq;
        this.dir = dir;
        this.arvore = arvore;
    }
}

class No2 {
    public String item; 
    public No2 esq, dir; 

    // Construtor
    public No2(String item) {
        this(item, null, null);
    }

    // Construtor
    public No2(String item, No2 esq, No2 dir) {
        this.item = item;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    private No1 raiz; 

    // construtor
    public ArvoreBinaria() {
        raiz = null;
    }

    //pesquisa item
    public boolean pesquisar(String x) {
        System.out.print("raiz");
        return pesquisar(x, raiz);
    }

    //pesquisa item recursivo
    private boolean pesquisar(String x, No1 i) {
        boolean resp = false;
        if (i == null) {
            resp = false;

        } else {
            if (i.arvore != null) {
                resp = pesquisarArvore(x, i.arvore);
            }
            if (!resp) {
                System.out.print(" esq");
                resp = pesquisar(x, i.esq);
                if (!resp) {
                    System.out.print(" dir");
                    resp = pesquisar(x, i.dir);
                }
            }
        }
        return resp;
    }

    //pesquisa item na arvore
    private boolean pesquisarArvore(String x, No2 i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x.compareTo(i.item) == 0) {
            resp = true;

        } else {
            System.out.print(" ESQ");
            resp = pesquisarArvore(x, i.esq);
            if (!resp) {
                System.out.print(" DIR");
                resp = pesquisarArvore(x, i.dir);
            }
        }
        return resp;
    }

    //mostra itens
    public void caminharCentral() {
        caminharCentral(raiz);
    }

    //mostra itens recursivo
    private void caminharCentral(No1 i) {
        if (i != null) {
            caminharCentral(i.esq); // Elementos da esquerda.
            System.out.println("\n > " + i.item);
            printArvore(i.arvore); // Conteudo do nó
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    // metodo para exibir itens da arvore recursivo
    private void printArvore(No2 i) {
        if (i != null) {
            printArvore(i.esq);
            System.out.print(i.item + " | ");
            printArvore(i.dir);
        }
    }

    //inserir NO1
    public void inserirBase(char x) throws Exception {
        raiz = inserirBase(x, raiz);
    }

    // inserir NO1 recursivo
    private No1 inserirBase(char x, No1 i) throws Exception {
        if (i == null) {
            i = new No1(x);

        } else if (x < i.item) {
            i.esq = inserirBase(x, i.esq);

        } else if (x > i.item) {
            i.dir = inserirBase(x, i.dir);

        } else {
        }
        return i;
    }

    // insere item
    public void inserir(String x) throws Exception {
        raiz = inserir(x, raiz);
    }

    //insere item recursivo
    private No1 inserir(String x, No1 i) throws Exception {
        if (i == null) {
            i = new No1(x.charAt(0));
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

    //insere item na arvore recursivo
    private No2 inserirArvore(String x, No2 i) throws Exception {
        if (i == null) {
            i = new No2(x);

        } else if (x.compareTo(i.item) < 0) {
            i.esq = inserirArvore(x, i.esq);

        } else if (x.compareTo(i.item) > 0) {
            i.dir = inserirArvore(x, i.dir);

        } else {

        }

        return i;
    }

    //remove item
    public void remover(String x) throws Exception {
        raiz = remover(x, raiz);
    }

    //remove item recursivo
    private No1 remover(String x, No1 i) throws Exception {
        if (i == null) {
 
        } else if (x.charAt(0) == i.item) {
            i.arvore = removerArvore(x, i.arvore);
        } else if (x.charAt(0) < i.item) {
            i.esq = remover(x, i.esq);

        } else if (x.charAt(0) > i.item) {
            i.dir = remover(x, i.dir);
        } else {

        }
        return i;
    }

    //remove item da arvore recursivo 
    private No2 removerArvore(String x, No2 i) throws Exception {

        if (i == null) {
        } else if (x.compareTo(i.item) < 0) {
            i.esq = removerArvore(x, i.esq);

        } else if (x.compareTo(i.item) > 0) {
            i.dir = removerArvore(x, i.dir);


        } else if (i.dir == null) {
            i = i.esq;


        } else if (i.esq == null) {
            i = i.dir;

        } else {
            i.esq = maiorEsq(i, i.esq);
        }
        return i;
    }

    //troca item removido pelo maior à esquerda
    private No2 maiorEsq(No2 i, No2 j) {

        if (j.dir == null) {
            i.item = j.item; 
            j = j.esq; 
        } else {
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

}

public class main{
    // finalizador do programa
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) throws Exception {
        long programStartTime = Instant.now().toEpochMilli();
        ArvoreBinaria arvore = new ArvoreBinaria();
        String[] entrada = new String[1000];
        char[] base = { 'D', 'R', 'Z', 'X', 'V', 'B', 'F', 'P', 'U', 'I', 'G', 'E', 'J', 'L', 'H', 'T', 'A', 'W', 'S',
                'O', 'M', 'N', 'K', 'C', 'Y', 'Q' };
        Serie novo = new Serie();
        int n = 0;
        
        for (int i = 0; i < base.length; i++) {
            arvore.inserirBase(base[i]);
        }

        do {
            entrada[n] = MyIO.readLine();
        } while (isFim(entrada[n++]) == false);
        for (int i = 0; i < (n - 1); i++) {
            novo.lerSerie(entrada[i]);
            arvore.inserir(novo.clone().getNome());
        }

        n = 0;
        do {
            entrada[n] = MyIO.readLine();
        } while (isFim(entrada[n++]) == false);
        for (int i = 0; i < (n - 1); i++) {
            if (arvore.pesquisar(entrada[i])) {
                System.out.println(" SIM");
            } else {
                System.out.println(" NAO");
            }
        }

        try {
            RandomAccessFile log = new RandomAccessFile("matrícula_arvoreArvore.txt", "rw");
            long totalRuntime = Instant.now().toEpochMilli() - programStartTime;
            log.writeChars(String.format("727480\t%d\t%d", totalRuntime, 0));
            log.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
