import java.util.*;

class guia2 {
  public static String aux (int x) {
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
      retorno = aux(x);
    } else {
      if (x / 16 >= 16) {
        retorno = dec2hex(x/16) + aux(x % 16);
      } else {
        retorno = aux(x/16) + aux(x % 16);
      }
    }

    return retorno;
  }

  public static void main(String[] args) {
    System.out.println(dec2hex(73));
    System.out.println(dec2hex(47));
    System.out.println(dec2hex(61));
    System.out.println(dec2hex(157));
    System.out.println(dec2hex(171));
  }
}

