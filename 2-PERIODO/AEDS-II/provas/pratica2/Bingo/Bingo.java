import java.io.*;
import java.util.*;
import java.lang.*;

class Bingo {

  /**
   * Lê a string contendo os valores de uma cartela e retorna um array de inteiros com eles
   * 
   * @param str: string
   * @param k: quantidade de números que a string possui
   * @return arrray com os números
   */
  public static int[] lerCartela(String str, int k) {
    int[] cartela = new int[k];

    int pos = 0;
    

    for (int i = 0; i < k; i++) {
      String aux = "";
      while (pos < str.length() && str.charAt(pos) != ' ') {
        aux += str.charAt(pos);
        pos++;
      }
      pos++;
      
      cartela[i] = Integer.parseInt(aux);
    }

    return cartela;
  }

  /**
   * Checa se todos os inteiros em um array de inteiros de tamanho k são iguais a -1
   * 
   * @param cartela
   * @param k
   * @return true caso todos os valores sejam iguais a -1
   */
  public static boolean estaVazio(int[] cartela, int k) {
    boolean retorno = true;
    for (int i = 0; i < k; i++) {
      if (cartela[i] != -1) {
        retorno = false;
      }
    }

    return retorno;
  }

  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = 0, k = 0, u = 0;
    String[] entrada = new String[1000];

    
    try {
      entrada[0] = br.readLine();
    } catch (IOException e) {
      System.out.println(e);
    }
    

    int pos = 0;
    for (int i = 0; i < 3; i++) {
      
      String aux = "";

      while (pos < entrada[0].length() && entrada[0].charAt(pos) != ' ') {
        aux += entrada[0].charAt(pos);
        pos++;
      }
      pos++;

      if (i == 0) {
        n = Integer.parseInt(aux);
      } else if (i == 1) {
        k = Integer.parseInt(aux);
      } else {
        u = Integer.parseInt(aux);
      }
    }
    

    // Leitura da entrada padrão
    for (int i = 0; i <= n; i++) {
      try {
        entrada[i] = br.readLine();
      } catch (IOException e) {
        System.out.println(e);
      }
      
    }
    
    // Leitura das n cartelas
    int[][] cartelas = new int[n][k];
    for (int i = 0; i < n; i++) {
      cartelas[i] = lerCartela(entrada[i], k);
    }
    

    // Leitura da linha dos valores sorteados

    
    int[] sorteados = lerCartela(entrada[n], u);

    

    int[] vencedores = new int[n];
    for (int i = 0; i < n; i++) {
      vencedores[i] = -1;
    }

    

    // Encontrando o(s) vencedor(es)
    for (int i = 0; i < u; i++) {
      for (int j = 0; j < n; j++) {
        for (int w = 0; w < k; w++) {
          if (cartelas[j][w] == sorteados[i]) {
            cartelas[j][w] = -1;
          } 

        }

        if (estaVazio(cartelas[j], k)) {
          vencedores[j] = 1;
        }
      }

      if (!estaVazio(vencedores, n)) {
        break;
      }
    }

    // Imprimindo os vencedores
    for (int i = 0; i < n; i++) {
      if (vencedores[i] != -1) {
        System.out.print(i + 1);

        if (i < n-1) {
          System.out.print(" ");
        }
      }
    }
    System.out.print("\n");
  }
}