class TP01Q08 {

  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static boolean isVogal(String s) {
    boolean resposta = true;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i);
      // Caso o caractere não seja uma vogal, a string não é composta apenas de vogais
      if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u' &&
          x != 'A' && x != 'E' && x != 'I' && x != 'O' && x != 'U') {
            resposta = false;
            i = s.length();
      }
    }

    return resposta;
  }

  public static boolean isConsoante(String s) {
    boolean resposta = true;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i);
      // Caso o caractere seja igual a uma vogal ou a algum caractere não alfabético, a string não é composta apenas de consoantes
      if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ||
          x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U' ||
          !((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z'))) {
            resposta = false;
            i = s.length();
      }
    }

    return resposta;
  }

  public static boolean isInteiro(String s) {
    boolean resposta = true;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i);
      // Caso o caractere seja composto de algo diferente de um número, ele não será um número inteiro
      if (x < '0' || x > '9') { 
        resposta = false;
        i = s.length();
      }
    }

    return resposta;
  }

  public static boolean isReal(String s) {
    boolean resposta = true;
    int numeroDePontos = 0;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i);
      // Nesse caso, o caractere pode possuir um ponto ou uma vírgula, porém não mais que uma
      if (((x < '0' || x > '9') && x != '.' && x != ',' ) || numeroDePontos > 1) { 
        resposta = false;
        i = s.length();
      }

      if (x == '.' || x == ',') {
        numeroDePontos++;
      }
    }

    return resposta;
  }
  

  public static String makeLine(String s) {
    String resposta = "";
    // Essa função gera a string que será printada na tela
    if (isVogal(s) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }

    if (isConsoante(s) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }


    if (isInteiro(s) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }
    
    if (isReal(s) == true) {
      resposta += "SIM";
    } else {
      resposta += "NAO";
    }

    return resposta;
  }

  public static void main (String[] args){
    String[] entrada = new String[1000];
    int numEntrada = 0;

    //Leitura da entrada padrao
    do {
      entrada[numEntrada] = MyIO.readLine();
    } while (isFim(entrada[numEntrada++]) == false);
    numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

    //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
    for(int i = 0; i < numEntrada; i++){
        MyIO.println(makeLine(entrada[i]));
    }
  }
}
