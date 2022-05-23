import java.io.*;
import java.util.*;

public class generator {
  public static void main(String[] args) {
    Random gen = new Random(System.currentTimeMillis());
    Scanner sc = new Scanner(System.in);
    String[] arr = {
        "An",
        "nAoB",
        "AnB",
        "zeroL",
        "nAeB",
        "Bn",
        "AxB",
        "ABn",
        "AnoB",
        "nAxB",
        "copiaB",
        "AB",
        "umL",
        "AoBn",
        "AoB",
        "copiaA"
    };

    System.out.println("Digite a quantidade de linhas a serem geradas: ");
    int numEntrada = sc.nextInt();
    try {
      FileWriter writer = new FileWriter("teste.ula", false);
      writer.write("inicio:\n");
      for (int i = 0; i < numEntrada; i++) {
        int letter = (i < 2) ? i : gen.nextInt(3);
        if (letter == 0 || letter == 1) {
          writer.write(letter == 0 ? "X=" : "Y=");
          int val = gen.nextInt(16);
          writer.write("" + (val >= 10 ? (char) (val + 55) : (char) (val + 48)) + "\n");
        } else {
          int pos = gen.nextInt(arr.length);
          writer.write("W=" + arr[pos] + "\n");

        }
      }

      writer.write("fim.\n");
      writer.close();
    } catch (IOException e) {
    }

    sc.close();

  }
}
