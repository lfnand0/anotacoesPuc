import java.util.*;

class guia2 {
  public static int auxHex (char c) {
    int retorno = 0;  
    // Transforma os valores A, B, C, D, E e F em, respectivamente, 10, 11, 12, 13, 14 e 15 
    if (c == 'A') {
      retorno = 10;
    } else if (c == 'B') {
      retorno = 11;
    } else if (c == 'C') {
      retorno = 12;
    } else if (c == 'D') {
      retorno = 13;
    } else if (c == 'E') {
      retorno = 14;
    } else if (c == 'F') {
      retorno = 15;
    } else {
      retorno = Character.getNumericValue(c);
    }
    return retorno;
  }

  public static int hex2dec (String s, int pos) {
    int retorno;
    if (pos == s.length()) {
      retorno = 0;
    } else {
      int valorNaPos = auxHex(s.charAt(s.length() - pos - 1));
      retorno = hex2dec(s, pos + 1) + (int)(valorNaPos * Math.pow(16, pos));
    }

    return retorno;
  }

  public static String auxDec (int x) {
    String retorno = "";  
    // Transforma os valores 10, 11, 12, 13, 14 e 15 em, respectivamente, A, B, C, D e E
    if (x == 10) {
      retorno = "A";
    } else if (x == 11) {
      retorno = "B";
    } else if (x == 12) {
      retorno = "C";
    } else if (x == 13) {
      retorno = "D";
    } else if (x == 14) {
      retorno = "E";
    } else if (x == 15) {
      retorno = "F";
    } else {
      retorno = Integer.toString(x);
    }
    return retorno;
  }

  public static String dec2hex (int x) {
    String retorno = "";
    if (x < 16) {
      retorno = auxDec(x);
    } else {
      if (x / 16 >= 16) {
        retorno = dec2hex(x/16) + auxDec(x % 16);
      } else {
        retorno = auxDec(x/16) + auxDec(x % 16);
      }
    }

    return retorno;
  }

  public static String ASCII2hex (String s) {
    String resposta = "";
    for (int i = 0; i < s.length(); i++) {
      resposta += dec2hex((int)(s.charAt(i))) + " ";
    }
    return resposta;
  }

  public static String hex2ASCII (String s) {
    String retorno = "";
    int pos = 0;
    while (pos < s.length()) {
      String aux = "";
      while (pos < s.length() && s.charAt(pos) != ' ') {
        aux += s.charAt(pos);
        pos++;
      }
      retorno += (char)hex2dec(aux, 0);
      pos++;
    }

    return retorno;
  }

  public static void main(String[] args) {
    System.out.println(ASCII2hex("PUC-MINAS"));
    System.out.println(ASCII2hex("2021-1"));
    System.out.println(ASCII2hex("Brasil"));
    System.out.println(hex2ASCII("124 101 122 104 105"));
    System.out.println(hex2ASCII("62 2E 68 2E 2D 6D 67"));

  }
}

