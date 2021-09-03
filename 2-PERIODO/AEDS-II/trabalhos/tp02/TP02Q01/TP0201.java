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

  Serie(String nome, String formato, String duracao, String paisDeOrigem, 
        String idioma, String emissora, String transmissao, 
        int numeroDeTemporadas, int numeroDeEpisodios) {
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

  public void ler() {

  }

  public void imprimir() {
    MyIO.println(this.nome + " " + this.formato + " " + this.duracao + " " + 
                 this.paisDeOrigem + " " + this.idioma + " " + this.emissora + 
                 " " + this.transmissao + " " + numeroDeTemporadas + " " + numeroDeEpisodios);
  }
}



class TP0201 {
  public static String getHTML(String nome) {
    String html = Arq.openReadClose("./tmp/series" + nome);
    return html;
  }

  public static void main(String[] args) {
    /*
    Serie item = new Serie();
    
    item.setNome("nomeTeste");
    item.setFormato("formatoTeste");
    item.setDuracao("duracaoTeste");
    item.setPaisDeOrigem("paisTeste");
    item.setIdioma("idiomaTeste");
    item.setEmissora("emissoraTeste");
    item.setTransmissao("transmissaoOriginal");
    item.setNumeroDeTemporadas(15);
    item.setNumeroDeEpisodios(30);
    */

    Serie item = new Serie("nomeTeste", "formatoTeste", "duracaoTeste", "paisTeste", 
                           "idiomaTeste", "emissoraTeste", "transmissaoTeste", 15, 30);
   
    MyIO.println(getHTML("13_Reasons_Why.html"));
    item.imprimir();
  }  
}
