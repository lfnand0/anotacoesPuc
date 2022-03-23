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

class Hash {
    public int[] tabela;
    private int tamanhoNormal;
    private int tamanhoReserva;
    private int tamanhoTotal;
    private int indexReserva;
    private int compareCounter;

    final int NULO = -1;

    Set<String> itensInseridos = new HashSet<String>();

    /**
     * Construtor da classe.
     */
    public Hash() {
        this(21, 9);
    }

    public Hash(int tamanhoNormal, int tamanhoReserva) {
        this.tamanhoNormal = tamanhoNormal;
        this.tamanhoReserva = tamanhoReserva;
        this.tamanhoTotal = tamanhoNormal + tamanhoReserva;
        this.tabela = new int[this.tamanhoTotal];
        for (int i = 0; i < tamanhoNormal; i++) {
            tabela[i] = NULO;
        }
        indexReserva = 0;
    }

    public int h(int elemento) {
        return elemento % tamanhoNormal;
    }

    public boolean inserir(int elemento) {
        boolean retorno = false;
        if (elemento != NULO) {
            int pos = h(elemento);
            if (tabela[pos] == NULO) {
                tabela[pos] = elemento;

                retorno = true;
            } else if (indexReserva < tamanhoReserva) {
                tabela[tamanhoNormal + indexReserva] = elemento;
                indexReserva++;

                retorno = true;
            }
        }

        return retorno;
    }

    public boolean pesquisar(int elemento) {
        boolean retorno = false;
        int pos = h(elemento);

        if (tabela[pos] == elemento) {
            retorno = true;
        } else if (tabela[pos] != NULO) {
            for (int i = 0; i < indexReserva; i++) {
                if (tabela[tamanhoNormal + i] == elemento) {
                    retorno = true;
                    i = indexReserva;
                }
            }
        }

        return retorno;
    }

    public void matricula(long time) { // criação do arq log

        try {
            File myObj = new File("matrícula_hashReserva.txt");
            if (myObj.createNewFile()) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("matrícula_hashReserva.txt");
            myWriter.write("727245" + "\t" + time + "\t" + compareCounter);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TP04Q06 {
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];

        int numEntrada = 0;

        // Leitura da entrada padrão
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        Serie series[] = new Serie[numEntrada];

        Hash hashTable = new Hash();
        int soma = 0;

        for (int i = 0; i < numEntrada; i++) {
            series[i] = new Serie();

            try {
                series[i].ler(entrada[i]);
            } catch (Exception e) {
            }

            for (int j = 0; j < series[i].getNome().length(); j++) {
                soma += (int) (series[i].getNome().charAt(j));
            }

            soma = hashTable.h(soma);
            if (hashTable.inserir(soma) == true) {
                hashTable.itensInseridos.add(series[i].getNome());
            }

            soma = 0;
        }

        entrada = new String[1000];
        numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar última linha contendo FIM

        for (int i = 0; i < numEntrada; i++) {
            if (hashTable.itensInseridos.contains(entrada[i])) {
                System.out.println(" SIM");
            } else {
                for (int j = 0; j < entrada[i].length(); j++) {
                    soma += (int) entrada[i].charAt(j);
                }
                soma = hashTable.h(soma);
                hashTable.pesquisar(soma);
                soma = 0;
                System.out.println(" NAO");
            }
        }

        long duration = System.nanoTime() - startTime;
        hashTable.matricula(duration);
    }
}
