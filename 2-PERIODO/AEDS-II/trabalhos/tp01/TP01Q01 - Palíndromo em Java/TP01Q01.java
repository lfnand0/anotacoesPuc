class TP01Q01 {
  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String isPalindromo(String s) {
    String retorno = "SIM";
    for (int i = 0; i < (s.length() / 2); i++) {
      //Para cada caractere na frase, a condicional checa se o caractere "espelho" é diferente
      //Caso seja, a palavra não é um palíndromo.
      if (s.charAt(i) != s.charAt(s.length() - i - 1)){
        retorno = "NAO";
      }
    }
    return retorno;
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
      MyIO.println(isPalindromo(entrada[i]));
    }
  }
}
