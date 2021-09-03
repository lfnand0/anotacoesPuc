class donaMonica {
  public static boolean isFim(String s){
    return (s.length() == 1 && s.charAt(0) == '0');
  }

  public static int idadeFilhoMaisVelho(String s) {
    int i, monica, filho1, filho2;
    i = monica = filho1 = filho2 = 0;
    
    while ((int)s.charAt(i) != 32) {
      monica = (monica * 10) + (s.charAt(i) - '0');
      i++;
    }
    i++;
    while ((int)s.charAt(i) != ' ') {
      filho1 = (filho1 * 10) + (s.charAt(i) - '0');
      i++;
    }

    i++;
    while (i < s.length()) {
      filho2 = (filho2 * 10) + (s.charAt(i) - '0');
      i++;
    }
    int filho3 = monica - filho1 - filho2;
    int filhoMaisVelho = filho1;

    if (filhoMaisVelho < filho2) {
      filhoMaisVelho = filho2;
    }

    if (filhoMaisVelho < filho3) {
      filhoMaisVelho = filho3;
    }

    return filhoMaisVelho;


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
      MyIO.println(idadeFilhoMaisVelho(entrada[i]));
    }
  }
}
