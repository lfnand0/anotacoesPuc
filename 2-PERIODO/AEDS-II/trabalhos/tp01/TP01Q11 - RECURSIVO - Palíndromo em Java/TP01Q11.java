class TP01Q11 {
  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String isPalindromo(String s, int pos) {
    String retorno;
    int length = s.length();
    
    // O algoritmo checa se a posição "pos" é igual ao seu espelho (length - pos - 1),
    // caso não seja é retornado NAO, caso seja, checamos a próxima posição
    // Caso a posição seja maior ou igual a metade do tamanho da string, quer dizer que não
    // precisamos mais checar
    if (pos >= length / 2) {
      retorno = "SIM";
    } else if (s.charAt(pos) != s.charAt(length - pos - 1)) {
      retorno = "NAO";
    } else {
      retorno = isPalindromo(s, pos + 1);
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
      MyIO.println(isPalindromo(entrada[i], 0));
    }
  }
}
