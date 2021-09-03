class cometa {
  public static boolean isFim(String s){
    return (s.length() == 1 && s.charAt(0) == '0');
  }

  public static int proxAno(String s){
    int i, anoAtual, proximoAno = 1986;
    i = anoAtual = 0;
    while (i < s.length()) {
      anoAtual = (anoAtual * 10) + (s.charAt(i) - '0');
      i++;
    }
    if ((anoAtual - 1986)%76 == 0) {
      proximoAno = anoAtual + 76;
    } else {
      while (proximoAno < anoAtual) {
        proximoAno += 76;
      }
    }
    return proximoAno;
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
      MyIO.println(proxAno(entrada[i]));
    }
  }
}
