import java.util.Random;

class TP01Q04 {
  public static boolean isFim(String s){
    return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }

  public static String alteracaoAleatoria(String s) {
    String novaString = "";
    Random gerador = new Random();
    char letra1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
    char letra2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == letra1) {
        novaString += letra2;
      } else if (s.charAt(i) == letra2) {
        novaString += letra1;
      } else {
        novaString += s.charAt(i);
      }
    }
    //novaString += (" " + letra1 + " " + letra2);
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
      MyIO.println(alteracaoAleatoria(entrada[i]));
    }
  }
}
