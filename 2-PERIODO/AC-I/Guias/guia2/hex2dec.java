import java.util.*;

class guia2 {
  public static int aux (char c) {
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
      int valorNaPos = aux(s.charAt(s.length() - pos - 1));
      retorno = hex2dec(s, pos + 1) + (int)(valorNaPos * Math.pow(16, pos));
    }

    return retorno;
  }

  public static void main(String[] args) {
    System.out.println(hex2dec("73", 0));
    System.out.println(hex2dec("ABC", 0));
    System.out.println(hex2dec("100", 0));
    System.out.println(hex2dec("9A8", 0));
    System.out.println(hex2dec("1000", 0));
  }
}

