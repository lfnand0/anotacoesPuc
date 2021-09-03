class TP01Q15 {

  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static boolean isVogal(String s, int pos) {
    boolean resposta;
    if (pos == s.length()) {
      resposta = true;
    } else {
      int x = s.charAt(pos);
      // Caso o caractere não seja uma vogal, a string não é composta apenas de vogais
      if (x != 'a' && x != 'e' && x != 'i' && x != 'o' && x != 'u' &&
          x != 'A' && x != 'E' && x != 'I' && x != 'O' && x != 'U') {
            resposta = false;
      } else {
        resposta = isVogal(s, pos + 1);
      }
    }

    return resposta;
  }

  public static boolean isConsoante(String s, int pos) {
    boolean resposta;
    if (pos == s.length()) {
      resposta = true;
    } else {
      int x = s.charAt(pos);
      // Caso o caractere seja igual a uma vogal ou a algum caractere não alfabético, a string não é composta apenas de consoantes
      if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ||
          x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U' ||
          !((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z'))) {
            resposta = false;
      } else {
        resposta = isConsoante(s, pos + 1);
      }
    }

    return resposta;
  }

  public static boolean isInteiro(String s, int pos) {
    boolean resposta;
    if (pos == s.length()) {
      resposta = true;
    } else {
      int x = s.charAt(pos);
      // Caso o caractere seja composto de algo diferente de um número, ele não será um número inteiro
      if (x < '0' || x > '9') { 
        resposta = false;
      } else {
        resposta = isInteiro(s, pos + 1);
      }
    }

    return resposta;
  }

  public static boolean isReal(String s, int pos, int numPontos) {
    boolean resposta;
    if (pos == s.length()) {
      resposta = true;
    } else {
      int x = s.charAt(pos);
      if (x == '.' || x == ',') {
        numPontos++;
      }
      // Nesse caso, o caractere pode possuir um ponto ou uma vírgula, porém não mais que uma
      if (((x < '0' || x > '9') && x != '.' && x != ',' ) || numPontos > 1) { 
        resposta = false;
      } else {
        resposta = isReal(s, pos + 1, numPontos);
      }
    }

    return resposta;
  }
  

  public static String makeLine(String s) {
    String resposta = "";
    // Essa função gera a string que será printada na tela
    if (isVogal(s, 0) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }

    if (isConsoante(s, 0) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }


    if (isInteiro(s, 0) == true) {
      resposta += "SIM ";
    } else {
      resposta += "NAO ";
    }
    
    if (isReal(s, 0, 0) == true) {
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
