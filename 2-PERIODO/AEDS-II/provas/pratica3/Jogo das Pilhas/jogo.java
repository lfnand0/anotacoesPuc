import java.io.*;
import java.util.*;

class Celula {
  public int item;
  public Celula prox;

  public Celula(int valorItem, Celula proxCelula) {
    item = valorItem;
    prox = proxCelula;
  }

  public Celula(int valorItem) {
    item = valorItem;
    prox = null;
  }

  public Celula() {
    item = -1;
    prox = null;
  }
}

class Pilha {
  private Celula topo = null;
  private int qtde;

  public Pilha() {
    // nenhum c�digo
  }

  public boolean vazia() {
    return topo == null;
  }

  public void empilha(int valorItem) {
    topo = new Celula(valorItem, topo);
    qtde++;
  }

  public int desempilha() {
    int item = -1;
    if (topo != null) {
      item = topo.item;
      topo = topo.prox;
      qtde--;
    }
    return item;
  }

  public boolean contem(int valorItem) {
    Celula aux = topo;
    while (aux != null) {
      if (aux.item == valorItem)
        return true;
      aux = aux.prox;
    }
    return false;
  }

  public boolean contemFor(int valorItem) {
    for (Celula aux = topo; aux != null; aux = aux.prox)
      if (aux.item == valorItem)
        return true;
    return false;
  }

  public int peek() {
    return (topo != null) ? topo.item : null;
  }

  public void mostra() {
    System.out.println("\ntopo");
    System.out.println("  | ");
    System.out.println("  v ");
    for (Celula c = topo; c != null; c = c.prox)
      System.out.println("[ " + c.item + " ]");
    System.out.println("  | ");
    System.out.println("  v ");
    System.out.println("null\n");
  }

  public int quantidade() {
    return qtde;
  }

  public Celula getTopo() {
    return topo;
  }
}

public class jogo {
  public static void main(String[] args) {
    int n = MyIO.readInt();
    while (n != 0) {
      Pilha pilha1 = new Pilha();
      Pilha pilha2 = new Pilha();
      Pilha pilha3 = new Pilha();

      for (int i = 0; i < n; i++) {
        String linha = MyIO.readLine();

        int a = Integer.parseInt(linha.charAt(0) + "");
        int b = Integer.parseInt(linha.charAt(2) + "");
        int c = Integer.parseInt(linha.charAt(4) + "");

        pilha1.empilha(a);
        pilha2.empilha(b);
        pilha3.empilha(c);
      }

      for (int l = 0; l < n; l++) {
        // PILHA 1
        int k = 3;
        boolean resp = false;
        Celula aux = pilha1.getTopo();
        int soma = 0;
        while (k > 0 && !resp && aux != null) {
          soma += aux.item;
          if (soma % 3 == 0) {
            resp = true;
          }

          aux = aux.prox;
          k--;
        }

        while (k < 3 && !pilha1.vazia() && resp) {
          pilha1.desempilha();
          k++;
        }

        // PILHA 2
        k = 3;
        resp = false;
        aux = pilha2.getTopo();
        soma = 0;
        while (k > 0 && !resp && aux != null) {
          soma += aux.item;
          if (soma % 3 == 0) {
            resp = true;
          }

          aux = aux.prox;
          k--;
        }

        while (k < 3 && !pilha2.vazia() && resp) {
          pilha2.desempilha();
          k++;
        }

        // PILHA 3
        k = 3;
        resp = false;
        aux = pilha3.getTopo();
        soma = 0;
        while (k > 0 && !resp && aux != null) {
          soma += aux.item;
          if (soma % 3 == 0 && soma != 0) {
            resp = true;
          }

          aux = aux.prox;
          k--;
        }

        while (k < 3 && !pilha3.vazia() && resp) {
          pilha3.desempilha();
          k++;
        }
      }

      System.out.println((pilha1.vazia() || pilha2.vazia() || pilha3.vazia()) ? "1" : "0");

      n = MyIO.readInt();
    }
  }
}
