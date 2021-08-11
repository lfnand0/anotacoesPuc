class TP01Q05 {
  public static boolean isFim(String s){
    return (s.charAt(0) == 0);
  }

  public static boolean funcNot(String s) {

  }

  public static boolean funcAnd(String s) {

  }

  public static boolean funcOr(String s) {

  }

  public static String algebraBooleana(String s) {
    int numeroEntradas = s.charAt(0), A = s.charAt(2), B = s.charAt(4), C;
    
    int posicao = 6; 
    if (numeroDeEntradas == 3) {
      C = s.charAt(6);
      posicao = 8;
    }

    boolean resultado;
    for (int i = posicao; i < s.length(); i++) {
      // NOT
      if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 't' && s.charAt(i + 3) == '(') {
        i += 4;
        String entreParenteses = "";
        int numParenteses = 1;
        while (s.charAt(i) !== 0) {
          if (s.charAt(i) == ')' && numParenteses == 1) {
            numParenteses--;
          } else {
            entreParenteses += s.charAt(i);
            if (s.charAt(i) == '(') {
              numParenteses++;
            } else if (s.charAt(i) == ')') {
              numParenteses--;
            }
          }
          i++;
        }
        funcNot(entreParenteses);
      }

      // AND
      if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'n' && s.charAt(i + 2) == 'd' && s.charAt(i + 3) == '('){
        i += 4;
        String entreParenteses = "";
        int numParenteses = 1;
        while (s.charAt(i) !== 0) {
          if (s.charAt(i) == ')' && numParenteses == 1) {
            numParenteses--;
          } else {
            entreParenteses += s.charAt(i);
            if (s.charAt(i) == '(') {
              numParenteses++;
            } else if (s.charAt(i) == ')') {
              numParenteses--;
            }
          }
          i++;
        }
        funcAnd(entreParenteses);
      } 
    }
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
      MyIO.println(algebraBooleana(entrada[i]));
    }
  }
}
