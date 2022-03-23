import java.io.*;
import java.util.*;
import java.lang.*;

class Camisetas {

  /**
   * Lê uma string contendo diversos números e retorna um array com eles 
   * 
   * @param str: string
   * @param k: quantidade de números que a string possui
   * @return arrray com os números
   */
  public static int[] lerString(String str, int k) {
    int[] arr = new int[k];

    int pos = 0;

    for (int i = 0; i < k; i++) {
      String aux = "";
      while (pos < str.length() && str.charAt(pos) != ' ') {
        aux += str.charAt(pos);
        pos++;
      }
      pos++;
      
      arr[i] = Integer.parseInt(aux);
    }

    return arr;
  }
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = 0;
    String[] entrada = new String[1000];

    // Leitura do input
    for (int i = 0; i < 4; i++) {
      try {
        entrada[i] = br.readLine();
      } catch (IOException e) {
        System.out.println(e);
      }
    }
    

    n = Integer.parseInt(entrada[0]);

    int[] solicitados = lerString(entrada[1], n);

    int pequenas = Integer.parseInt(entrada[2]);
    int medias = Integer.parseInt(entrada[3]);
    
    // "Retira" uma camiseta do estoque para cada pedido
    for (int i = 0; i < n; i++) {
      if (solicitados[i] == 1) {
        pequenas--;
      } else if (solicitados[i] == 2) {
        medias--;
      }
    }

    if (pequenas >= 0 && medias >= 0) {
      System.out.println("S");
    } else {
      System.out.println("N");
    }
  }
}