import java.util.Scanner;

/**
 * 
 * Lista de adjacência por meio de vetores, representação forward star
 * 
 */
class ListaVetor {
  private int n; // numero de vertices
  private int[] pointer;
  private int[] arc_dest;

  ListaVetor(int n) {
    this.setN(n);
    makeLista();
  }

  public void setN(int n) {
    this.n = n;
    this.pointer = new int[n];
    this.arc_dest = new int[n*n];
  }

  public void makeLista() {
    Scanner sc = new Scanner(System.in);
    
    if (this.n > 1) {
      int pos = 0;
      int[] origem = new int[n*n];
      for (int vert = 1; vert <= this.n; vert++) {
        System.out.println("Digite os sucessores do vértice " + vert + " (ou 0 para sair):");
        int sucessor = sc.nextInt();
        this.pointer[vert - 1] = pos; 
        while (sucessor != 0) {
          origem[pos] = vert;
          arc_dest[pos] = sucessor;
          pos++;
          sucessor = sc.nextInt();
        }
      }

      mostrar();
    } else {
      System.out.println("Erro: grafo possui 1 ou menos vértices.");
    }
  
    sc.close();
  } 

  public void mostrar() {
    System.out.print("Pointer: [");
      for (int i = 0; i < pointer.length; i++) {
        System.out.print(pointer[i]);
        if (i + 1 < pointer.length) {
          System.out.print(", ");
        }
      }
      System.out.print("]\n");

      System.out.print("Arc_dest: [");
      for (int i = 0; i < arc_dest.length && arc_dest[i] > 0; i++) {
        System.out.print(arc_dest[i]);
        if (i + 1 < arc_dest.length && arc_dest[i + 1] > 0) {
          System.out.print(", ");
        }
      }
      System.out.print("]\n");
  }

  
  


}

class Celula {
  public int n;
  public Celula prox;

  Celula(int n) {
    this(n, null);
  }

  Celula(int n, Celula prox) {
    this.n = n;
    this.prox = prox;
  }
}

class ListaEncadeada {
  private int n;
  private Celula header;
  
  ListaEncadeada(int n) {
    this.n = n;
    this.header = null;
  }
}

public class Lista {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices = 0;

    while (vertices < 1) {
      System.out.println("Digite o número de vértices (Maior ou igual a 1): ");
      vertices = sc.nextInt();
    }

    int escolha = 0;
    while (escolha < 1 || escolha > 2) {
      System.out.println("1. Usar lista encadeada;\n2. Usar lista de vetores");
      escolha = sc.nextInt();
    }

    switch (escolha) {
      case 1:
        ListaEncadeada enc = new ListaEncadeada(vertices);
        break;
      case 2:
        ListaVetor lista = new ListaVetor(vertices);
        break;
    }

    // for(int i = 1; i < vertices; i++) {
    //   System.out.println("Digite o ID do vetor ");
    // }





    sc.close();
  }
}