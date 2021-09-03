import java.util.*;

class TP01Q14 {
  public static boolean isFim(String s){
    return (s.charAt(0) == '0');
  }

  public static boolean strComp(String a, String b) {
    boolean resposta = true;
    // Compara duas strings
    if (a.length() != b.length()) {
      resposta = false;
    } else {
      for (int i = 0; i < a.length(); i++) {
        if (a.charAt(i) != b.charAt(i)) {
          resposta = false;
        }
      }
    }

    return resposta;
  }

  public static String substituirString(String s) {
    String[] possibilidades = { // Esse array possui todas as possibilidades diferentes com até 4 valores 
      "not(0)", "not(1)",
      "or(0,0)", "or(0,1)", "or(1,0)", "or(1,1)",
      "or(0,0,0)", "or(0,0,1)", "or(0,1,0)", "or(0,1,1)", "or(1,0,0)", "or(1,0,1)", "or(1,1,0)", "or(1,1,1)",
      "or(0,0,0,0)", "or(0,0,0,1)", "or(0,0,1,0)", "or(0,0,1,1)", "or(0,1,0,0)", "or(0,1,0,1)", "or(0,1,1,0)",
      "or(0,1,1,1)", "or(1,0,0,0)", "or(1,0,0,1)", "or(1,0,1,0)", "or(1,0,1,1)", "or(1,1,0,0)", "or(1,1,0,1)",
      "or(1,1,1,0)", "or(1,1,1,1)",
      "and(0,0)", "and(0,1)", "and(1,0)", "and(1,1)",
      "and(0,0,0)", "and(0,0,1)", "and(0,1,0)", "and(0,1,1)", "and(1,0,0)", "and(1,0,1)", "and(1,1,0)", "and(1,1,1)",
      "and(0,0,0,0)", "and(0,0,0,1)", "and(0,0,1,0)", "and(0,0,1,1)", "and(0,1,0,0)", "and(0,1,0,1)", "and(0,1,1,0)",
      "and(0,1,1,1)", "and(1,0,0,0)", "and(1,0,0,1)", "and(1,0,1,0)", "and(1,0,1,1)", "and(1,1,0,0)", "and(1,1,0,1)",
      "and(1,1,1,0)", "and(1,1,1,1)"      
    };
    String[] possibRespostas = { // Esse array representa a resposta para cada possibilidade diferente
      "1", "0",
      "0", "1", "1", "1",
      "0", "1", "1", "1", "1", "1", "1", "1",
      "0", "1", "1", "1", "1", "1", "1",
      "1", "1", "1", "1", "1", "1", "1",
      "1", "1",
      "0", "0", "0", "1",
      "0", "0", "0", "0", "0", "0", "0", "1",
      "0", "0", "0", "0", "0", "0", "0",
      "0", "0", "0", "0", "0", "0", "0",
      "0", "1"
    };
  

    String retorno = "";
    for (int i = 0; i < possibilidades.length; i++) {
      if (strComp(s, possibilidades[i])) {
        return possibRespostas[i];
      }
    }
    return s;
  }

  public static String parser(String s) {
    // Função auxiliar
    char numeroEntradas = s.charAt(0), A = s.charAt(2), B = s.charAt(4), C = s.charAt(6);
   
    // Caso a string tenha 3 variáveis, a posição inicial da álgebra booleana é 8
    int posicaoInicial = 6; 
    if (numeroEntradas == '3') {
      posicaoInicial = 8;
    }

    String str = "";
    for (int i = posicaoInicial; i < s.length(); i++) {
    // Retirando espaços e substituindo os valores de A, B (e C caso o número de entradas seja 3) por 0 e 1
      if (s.charAt(i) == 'A') {
        str += A;
      } else if (s.charAt(i) == 'B') {
        str += B;
      } else if (numeroEntradas == '3' && s.charAt(i) == 'C') {
        str += C;
      } else if (s.charAt(i) != ' ') {
        str += s.charAt(i);
      }
    }
    return algebraBooleana(str);
  }

  public static String algebraBooleana(String str) {
    String retorno;
    if (str.length() == 1) {
      retorno = str;
    } else {
      String temp = "", resposta = "";
      int pos1 = 0, pos2 = 0;
      // pos2 = a primeira ocorrência do char ")" na string, pos1 = char "(" que fecha o parenteses da posicao2

      for (int i = 0; i < str.length(); i++) {
        // Função que acha pos1 e pos2
        if (str.charAt(i) == ')') {
          pos2 = i;
          int j = i;
          while (pos1 == 0) {
            if (str.charAt(j) == '(') {
              pos1 = j;
            }
            j--;
          }
          break;
        }
      }

      // Essa parte cria uma string "temp" que vai de pos1 à pos2, juntamente com a função realiza (not, or ou and)
      if (str.charAt(pos1 - 2) == 'o' && str.charAt(pos1 - 1) == 'r') {
      // Como or possui apenas 2 letras, precisamos fazer um if apenas para ele
        for (int i = pos1 - 2; i <= pos2; i++) {
          temp += str.charAt(i);
        }

        for (int i = 0; i < pos1 - 2; i++) { // Aqui somamos tudo que vem antes de or(...) à string resposta
          resposta += str.charAt(i);
        }

        resposta += substituirString(temp); // Soma o que a função retornar à string resposta

        for(int i = pos2 + 1; i < str.length(); i++) { // Soma tudo que vem depois de or(...) à string
          resposta += str.charAt(i);
        }

      } else {
        for (int i = pos1 - 3; i <= pos2; i++) {
        // Faz a mesma coisa que o if acima, porém para not e and, já que eles possuem 1 letra a mais que or
          temp+= str.charAt(i);
        }

        for (int i = 0; i < pos1 - 3; i++) {
          resposta += str.charAt(i);
        }

        resposta += substituirString(temp);

        for(int i = pos2 + 1; i < str.length(); i++) {
          resposta += str.charAt(i);
        }
      }

      retorno = algebraBooleana(resposta);
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
    numEntrada--;   //Desconsiderar ultima linha contendo o número 0

    //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
    for(int i = 0; i < numEntrada; i++){
      MyIO.println(parser(entrada[i]));
    }
  }
}
