import java.io.*;
import java.util.*;
import java.lang.*;

class Celula {
	public int elemento;
	public Celula prox;

    public Celula() {
        elemento = 0;
        prox = null;
    }  

    public Celula(int n) {
        elemento = n;
        prox = null;
    }

    public Celula(int n, Celula proxima) {
        elemento = n;
        prox = proxima;
    }
}

class Pilha {
    public Celula topo = null;
    public int n;

    public Pilha() {}

    public void empilhar(int item) {
        topo = new Celula(item, topo);
        n++;
    }

    public int desempilhar() {
        int retorno;
        if (topo != null) {
            retorno = topo.elemento;
            topo = topo.prox;
            n--;
        } 

        return retorno;
    }

    public void mostrar() {
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.println(i.elemento);
        }
    }

    public Celula extrairdapilha(int i) {
      Celula aux = topo;
      while (aux != null) {
        if (aux.elemento == i) {
          return aux;
        }
        aux = aux.prox;
      }

      return null;
    }
}

class Fila {
  public Celula frente;
  public Celula tras;
  public int n;
  public int tamanho;

  public Fila() {
      frente = new Celula();
      tras = frente;
      tamanho = 5;
      n = 0;
  }

  public void enfileirar(int item) {
      if (n < tamanho) {
          tras.prox = new Celula(item);
          tras = tras.prox;
          n++;
      } else {
          desenfileirar();
          enfileirar(item);
      }
  }

  public int desenfileirar(){
      int retorno = 0;

      if (frente != tras && n > 0) {
          Celula aux = frente;
          frente = frente.prox;

          retorno = frente.elemento;

          aux.prox = null;
          aux = null;

          n--;
      }

      return retorno;
  }

 public void mostrar() {
      for (Celula temp = frente.prox; temp != null; temp = temp.prox) {
        System.out.println(temp.elemento);
      }
  }
}

class Pergunta08 {

  public void copy(Celula topo, Celula primeiro, Celula ultimo) {
    Celula pilhaCel = topo, filaCel = primeiro.prox;
    while (pilhaCel != null && filaCel != ultimo) {
      filaCel.elemento = pilhaCel.elemento;  

      filaCel = filaCel.prox;
      pilhaCel = pilhaCel.prox;
    }
  }

}
