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
    public boolean cor;

    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    public No(Serie item) {
        this(item, null, null, false);
    }

    public No(Serie item, boolean cor) {
        this(item, null, null, cor);
    }

    public No(Serie item, No esq, No dir, boolean cor) {
        this.elemento = item;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }
}

class Alvinegra{
    private No raiz;
    private int compareCounter;
    
    public Alvinegra() {
        raiz = null;
    }

    // public void inserir(Serie item) throws Exception{
    //     raiz = inserir(item, raiz);
    // }

    public void inserir(Serie item) {
        if (raiz == null) {
            raiz = new No(item);
            // 1 elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            if (item.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new No(item);
            } else {
                raiz.dir = new No(item);
            }

            // 2 elementos (raiz e dir)
        } else if (raiz.esq == null) {
            if (item.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new No(item);

            } else if (item.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = item;

            } else {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = item;
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // 2 elementos (raiz e esq)
        } else if (raiz.dir == null) {
            if (item.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                raiz.dir = new No(item);

            } else if (item.getNome().compareTo(raiz.esq.elemento.getNome()) > 0) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = item;

            } else {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = item;
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // 3 ou mais elementos
        } else {
            inserir(item, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void inserir(Serie item, No bisavo, No avo, No pai, No i) {
        if (i == null) {
            if (item.getNome().compareTo(pai.elemento.getNome()) < 0) {
                i = pai.esq = new No(item, true);
            } else {
                i = pai.dir = new No(item, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (item.getNome().compareTo(i.elemento.getNome()) < 0) {
                inserir(item, avo, pai, i, i.esq);
            } else if (item.getNome().compareTo(i.elemento.getNome()) > 0) {
                inserir(item, avo, pai, i, i.dir);
            } else {

            }
        }
    }

    /*

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

    */

    public void pesquisar(String nome) {
        System.out.print("raiz ");
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

    private void balancear(No bisavo, No avo, No pai, No i) {
        if (pai.cor == true) {
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) {
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                avo = rotacaoDir(avo);
            } else {
                avo = rotacaoEsqDir(avo);
            }
            
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }

            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    public No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    public No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    public No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    public No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_arvoreAlvinegra.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_arvoreAlvinegra.txt");
            myWriter.write("727245" + "\t" + compareCounter + "\t" + time);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


class TP04Q04 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        long startTime = System.nanoTime();
        String[] entrada = new String[1000];
        Alvinegra arvore = new Alvinegra();

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
