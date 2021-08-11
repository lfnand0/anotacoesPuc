class TP01Q03 {
  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String ciframento(String s) {
    String novaString = "";
    for (int i = 0; i < s.length(); i++) {
      //Salva o caractere da posição i na variável caractere, adiciona 3 à ela e a retorna para a string
      char caractere = s.charAt(i);
      caractere = (char)(caractere + 3);
      novaString += caractere;
    }
    return novaString;
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
      MyIO.println(ciframento(entrada[i]));
    }
  }
}
