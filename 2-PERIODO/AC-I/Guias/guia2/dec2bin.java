import java.util.*;

class guia2 {
  public static String dec2bin (int x) {
    String retorno = "";
    if (x == 1) {
      retorno = "1";
    } else {
      retorno = dec2bin(x/2) + (x % 2 == 1 ? "1" : "0");
    }

    return retorno;
  }

  public static void main(String[] args) {
    System.out.println(dec2bin(27));
    System.out.println(dec2bin(51));
    System.out.println(dec2bin(713));
    System.out.println(dec2bin(312));
    System.out.println(dec2bin(360));
  }
}

