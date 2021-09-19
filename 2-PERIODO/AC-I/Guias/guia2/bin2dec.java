import java.util.*;

class guia2 {
  public static int bin2dec (int x) {
    int retorno = 0, potencia = 0;
    while (x > 0) {
      retorno += (x % 10) * Math.pow(2, potencia);
      potencia++;
      x /= 10;
    }
    return retorno;
  }

  public static void main(String[] args) {
    System.out.println(bin2dec(10101));
    System.out.println(bin2dec(11010));
    System.out.println(bin2dec(101001));
    System.out.println(bin2dec(111001));
    System.out.println(bin2dec(100011));
  }
}

