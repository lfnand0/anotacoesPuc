import java.io.*;
import java.util.*;

class No {
    public int elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(int elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Arvore {
    private No raiz;

    public Arvore() {
        raiz = null;
    }

    public void inserir(int item) throws Exception {
        raiz = inserir(item, raiz);
    }

    private No inserir(int item, No i) throws Exception {
        if (i == null) {
            i = new No(item);
        } else if (item < i.elemento) {
            i.esq = inserir(item, i.esq);
        } else if (item > i.elemento) {
            i.dir = inserir(item, i.dir);
        } else {
            throw new Exception("Erro: o item já existe na árvore");
        }

        return i;
    }

    public int getAltura() {
        return getAltura(raiz, 0);
    }

    private int getAltura(No i, int altura) {
        if (i == null) {
            altura--;
        } else {
            int alturaEsq = getAltura(i.esq, altura + 1);
            int alturaDir = getAltura(i.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }

        return altura;
    }

    public void printPorNivel() {
        int alt = getAltura();
        for (int i = 1; i <= alt + 1; i++) {
            printNivel(raiz, i);
        }
    }

    private void printNivel(No i, int nivel) {
        if (i != null) {
            if (nivel == 1) {
                MyIO.print(i.elemento + " ");
            } else {
                printNivel(i.esq, nivel - 1);
                printNivel(i.dir, nivel - 1);
            }
        }
    }

    private No maiorEsq(No i, No j) {
        // Encontrou o máximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento;
            j = j.esq;
            // Existe nó à direita.
        } else {
            // Caminha para a direita.
            j.dir = maiorEsq(i, j.dir);
        }

        return j;
    }
}

public class percurso {
    public static void main(String[] args) {
        int n = MyIO.readInt();

        for (int i = 0; i < n; i++) {
            Arvore arvore = new Arvore();
            int k = MyIO.readInt();

            for (int j = 0; j < k; j++) {
                int temp = MyIO.readInt();
                try {
                    arvore.inserir(temp);
                } catch (Exception e) {
                }
            }

            MyIO.println("Case " + (i + 1) + ":");
            arvore.printPorNivel();
            MyIO.print("\n");
            if (i + 1 < n) {
                MyIO.print("\n");
            }
        }

    }

}
