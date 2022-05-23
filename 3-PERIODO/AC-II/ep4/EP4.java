import java.io.*;
import java.util.*;

public class EP4 {
  public static Scanner sc = new Scanner(System.in);

  public static char mnemonicConverter(String str) {
    String[] arr = {
        "An;",
        "nAoB;",
        "AnB;",
        "zeroL;",
        "nAeB;",
        "Bn;",
        "AxB;",
        "ABn;",
        "AnoB;",
        "nAxB;",
        "copiaB;",
        "AB;",
        "umL;",
        "AoBn;",
        "AoB;",
        "copiaA;"
    };

    int resp = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(str)) {
        resp = i;
        i = arr.length;
      }
    }

    char retorno = '0';
    if (resp != -1) {
      retorno = (char) (Integer.toHexString(resp).charAt(0) -
          ((resp >= 10) ? 32 : 0));
    }

    return retorno;
  }

  public static void main(String[] args) {
    try {
      FileWriter writer = new FileWriter("output.hex", false);
      String line = "";
      char x, y, op;
      x = y = op = '0';

      while (!(line = sc.nextLine()).equals("inicio:"))
        ;

      while (!(line = sc.nextLine()).equals("fim.")) {
        switch (line.charAt(0)) {
          case 'X':
            x = (line.charAt(2));
            x = (x >= 97 && x <= 102) ? (char) (x - 32) : x; // passando letra minúscula para maiúscula
            x = ((x >= 65 && x <= 70) || (x >= 48 && x <= 57)) ? x : '0'; // input inválido
            break;
          case 'Y':
            y = line.charAt(2);
            y = (y >= 97 && y <= 102) ? (char) (y - 32) : y; // passando letra minúscula para maiúscula
            y = ((y >= 65 && y <= 70) || (y >= 48 && y <= 57)) ? y : '0'; // input inválido
            break;
          case 'W':
            String aux = "";
            for (int i = 2; i < line.length(); i++) {
              aux += line.charAt(i);
            }
            op = mnemonicConverter(aux);
            // System.out.println("" + x + y + op);
            writer.write("" + x + y + op + "\n");

            break;
        }
      }

      writer.close();
      sc.close();
    } catch (IOException e) {
    }
  }
}
