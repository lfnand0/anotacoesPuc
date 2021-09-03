class ex2 {
  public static void salvarFrase(String nome, String frase) {
    Arq.openWrite(nome);
    Arq.print(frase);
    Arq.close();
  }

  public static void lerArquivo(String nome) {
    Arq.openRead(nome);
    MyIO.print(Arq.readAll());
  }

  public static void lerEConverterParaMaiusculas(String nome) {
    String conteudo = Arq.openReadClose(nome);
    String retorno = "";

    for (int i = 0; i < conteudo.length(); i++) {
      if (conteudo.charAt(i) >= 97 && conteudo.charAt(i) <= 122) {
        retorno += (char)((int)conteudo.charAt(i) - 32);
      } else {
        retorno += conteudo.charAt(i);
      }
    }

    Arq.openWrite(nome);
    Arq.print(retorno);
    Arq.close();
  }

  public static void copiarConteudo(String arq1, String arq2) {
    String conteudo = Arq.openReadClose(arq1);
    Arq.openWrite(arq2);
    Arq.print(conteudo);
    Arq.close();
  }

  public static void abrirConverterParaMaiusculaESalvar(String arq1, String arq2) {
    String conteudo = Arq.openReadClose(arq1);
    String retorno = "";

    for (int i = 0; i < conteudo.length(); i++) {
      if (conteudo.charAt(i) >= 97 && conteudo.charAt(i) <= 122) {
        retorno += (char)((int)conteudo.charAt(i) - 32);
      } else {
        retorno += conteudo.charAt(i);
      }
    }

    Arq.openWrite(arq2);
    Arq.print(retorno);
    Arq.close();
  }

  public static void inverterESalvar(String arq1, String arq2) {
    String conteudo = Arq.openReadClose(arq1);
    String retorno = "";

    for (int i = conteudo.length() - 1; i >= 0; i--) {
      retorno += conteudo.charAt(i);
    }

    Arq.openWrite(arq2);
    Arq.print(retorno);
    Arq.close();

  }

  public static void ciframento(String arq1) {
    String conteudo = Arq.openReadClose(arq1);
    String retorno = "";

    for (int i = 0; i < conteudo.length(); i++) {
      retorno += (char)((int)conteudo.charAt(i) + 3);
    }

    MyIO.println(retorno);
  }

  public static void desciframento(String arq1) {
    String conteudo = Arq.openReadClose(arq1);
    String retorno = "";

    for (int i = 0; i < conteudo.length(); i++) {
      retorno += (char)((int)conteudo.charAt(i) - 3);
    }

    MyIO.println(retorno);
  }




  public static void main(String[]args) {
    salvarFrase("salvar.txt", "Teste");
    lerArquivo("salvar.txt");
    abrirConverterParaMaiusculaESalvar("salvar.txt", "exemplo.txt");
    lerEConverterParaMaiusculas("salvar.txt");
    copiarConteudo("salvar.txt", "exemplo.txt");
    lerArquivo("exemplo.txt");
    inverterESalvar("salvar.txt", "exemplo.txt");
    lerArquivo("exemplo.txt");
    ciframento("exemplo.txt");
    desciframento("cifra.txt");
  }
}
