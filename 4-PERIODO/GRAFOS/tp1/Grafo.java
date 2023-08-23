import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Grafo {
  // A user define class to represent a graph.
  // A graph is an array of adjacency lists.
  // Size of array will be n (number of vertices
  // in graph)
  private int n;
  private ArrayList<ArrayList<Integer>> adj;

  // constructor
  public Grafo(int n) {
    this.n = n;
    // define the size of array as
    // number of vertices
    adj = new ArrayList<>();

    // Create a new list for each vertex
    // such that adjacent nodes can be stored

    for (int i = 0; i < n; i++) {
      adj.add(i, new ArrayList<>());
    }
  }

  // Adds an edge to an undirected graph
  public void addAresta(int src, int dest) {
    // Add an edge from src to dest.
    adj.get(src).add(dest);

    // Since graph is undirected, add an edge from dest
    // to src also
    adj.get(dest).add(src);
  }

  private ArrayList<Integer> buscaProfundidade(int v, boolean[] visited, ArrayList<Integer> arr) {
    arr.add(v);
    // System.out.print("Debug: v = " + v + ", ");
    // for (int i = 0; i < arr.size(); i++) {
    // System.out.print(arr.get(i) + " ");
    // }
    // Mark the current node as visited and print it
    System.out.print(v + ", " + arr.size() + " " +arr.get(v) + "|");
    visited[v] = true;
    // System.out.print(v + " ");
    // Recur for all the vertices
    // adjacent to this vertex
    for (int x : adj.get(v)) {
      if (!visited[x])
        buscaProfundidade(x, visited, arr);
    }

    return arr;
  }

  public ArrayList<ArrayList<Integer>> componentesConexos() {
    // Mark all the vertices as not visited
    boolean[] visited = new boolean[n];
    int count = 0;
    ArrayList<ArrayList<Integer>> componentes = new ArrayList<ArrayList<Integer>>();
    for (int v = 0; v < n; v++) {
      if (!visited[v]) {
        // print all reachable vertices
        // from v
        count++;
        ArrayList<Integer> k = new ArrayList<Integer>();
        componentes.add(buscaProfundidade(v, visited, k));
        // System.out.println();
      }
    }
    //System.out.println("COUNT: " + count);

    return componentes;
  }

  public void gerarGrafo() {
    Random random = new Random();
    float p = random.nextFloat();
    this.gerarGrafo(p);
  }

  public void gerarGrafo(float p) {
    Random random = new Random();
    System.out.println("Probability: " + p);
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        float p2 = random.nextFloat();
        if (p2 < p) 
          addAresta(i, j);
      }
    }

    ArrayList<ArrayList<Integer>> componentes = this.componentesConexos();

    while (componentes.size() > 1) {
      for (int k = 0; k + 1 < componentes.size(); k++) { // componentes
        for (int i = 0; i < componentes.get(k).size(); i++) {
          for (int j = 0; j < componentes.get(k+1).size(); j++) {
            float p2 = random.nextFloat();
            if (p2 < p) 
              addAresta(componentes.get(k).get(i), componentes.get(k+1).get(j));
          }
        }
      }

      componentes = this.componentesConexos();
    }
  }

  public ArrayList<int[]> pontesNaive() {
    boolean[] marcados = new boolean[n];
    ArrayList<int[]> pontes = new ArrayList<int[]>();
    for (int i = 0; i < n; i++) {
      marcados[i] = true;
      for (int j = 0; j < adj.get(i).size(); j++) {
        int a = i;
        int b = adj.get(i).get(j);
        if (marcados[b]) continue;

        ArrayList<Integer> adjA = new ArrayList<Integer>(adj.get(a));
        adjA.removeIf(s -> s == b);

        ArrayList<Integer> adjB = new ArrayList<Integer>(adj.get(b));
        adjB.removeIf(s -> s == a);
        
        boolean ponte = true;
        for (int k = 0; k < adjA.size(); k++) {
          for (int v = 0; v < adjB.size(); v++) {
            if (adjA.get(k) == adjB.get(v)) {
              ponte = false;
              break;
            }
          }
          if (!ponte) break;
        }

        if (ponte) {
          int temp[] = {a, b}; 
          pontes.add(temp);
        }

      }
    }
  
    return pontes;
  }

  public void printLista() {
    System.out.println("\n----- LISTA DE ADJACENCIA -----");
    for (int i = 0; i < adj.size(); i++) {
      System.out.print(i + ": [");
      for (int j = 0; j < adj.get(i).size(); j++) {
        System.out.print(adj.get(i).get(j));
        if (j + 1 < adj.get(i).size()) 
          System.out.print(", ");
      }
      System.out.println("]");
    }
  }

  public void teste() {
    ArrayList<Integer> adjRaiz = new ArrayList<Integer>(adj.get(0));

    int b = adjRaiz.get(2);

    adjRaiz.removeIf(s -> s == b);

    System.out.println("adj--------");
    for (int i = 0; i < adj.size(); i++) System.out.println(adj.get(i));

    System.out.println("adjRaiz--------");
    for (int i = 0; i < adjRaiz.size(); i++) System.out.println(adjRaiz.get(i));
  }

  // Driver code
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    // Create a graph given in the above diagram
    Grafo g = new Grafo(n);
    if (args.length > 1) {
      float p = Float.parseFloat(args[1]);
      System.out.println(p);
      g.gerarGrafo(p);
    } else {
      g.gerarGrafo();
    }

    /*
    g.addAresta(1, 0);
    g.addAresta(2, 1);
    g.addAresta(3, 4);
    
    System.out.println(
        "Following are connected components");
    ArrayList<ArrayList<Integer>> componentes = g.componentesConexos();

    for (int i = 0; i < componentes.size(); i++) {
      for (int j = 0; j < componentes.get(i).size(); j++) {
        System.out.print(componentes.get(i).get(j) + " ");
      }
      System.out.println();
    }
    */

    ArrayList<int[]> pontes = g.pontesNaive();

    System.out.println("PONTES-------------");
    System.out.println(pontes.size());
    /*
    for (int i = 0; i < pontes.size(); i++) {
      int[] p = pontes.get(i);
      for (int j = 0; j < p.length; j++) {
        System.out.print(p[j] + " ");
      }
      System.out.println();
    }
    


    g.printLista(); */
    
  }
}
