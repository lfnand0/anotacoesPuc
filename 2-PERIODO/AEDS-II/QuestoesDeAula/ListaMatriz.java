class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;

   public Celula() {
      this(0);
   }

   public Celula(int elemento) {
      this.elemento = elemento;
      
   }

   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}


class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz (){
      this(3, 3);
   }

   public Matriz (int linha, int coluna){
    this.linha = linha;
    this.coluna = coluna;


    MyIO.print("Digite um valor para a primeira célula: ");
    int valor = MyIO.readInt();
    this.inicio = new Celula(valor);
    
    Celula i1 = inicio;
    for (int i = 0; i < coluna - 1; i++) {
      MyIO.print("Digite um valor para a " + (i + 2) + "º célula da 1º linha: ");
      valor = MyIO.readInt();
      i1.dir = new Celula(valor);
      i1.dir.esq = i1;
      i1 = i1.dir;
    }

    Celula j1 = inicio;
    for (int i = 0; i < linha - 1; i++) {
      MyIO.print("Digite um valor para a " + (i + 2) + "º célula da 1º coluna: ");
      valor = MyIO.readInt();
      j1.inf = new Celula(valor);
      j1.inf.sup = j1;
      j1 = j1.inf;
    }

    Celula tmp = inicio, tmp2 = inicio;
    for (int i = 0; i < linha - 1; i++) {
      for (int j = 0; j < coluna - 1; j++) {
        MyIO.print("Digite um valor: ");
        valor = MyIO.readInt();
        tmp.dir.inf = new Celula(valor);   
        tmp.dir.inf.sup = tmp.dir;
        tmp.inf.dir = tmp.dir.inf;
        tmp.dir.inf.esq = tmp.inf;
        tmp = tmp.dir;
      }
      tmp = tmp2 = tmp2.inf;
    }
  }

  public Matriz soma (Matriz m) {
    Matriz resp = null;

    if(this.linha == m.linha && this.coluna == m.coluna){
      resp = new Matriz(this.linha, this.coluna);

      Celula a, b, c, a2, b2, c2;
      a = a2 = this.inicio;
      b = b2 = m.inicio;
      c = c2 = resp.inicio;

      for(int i = 0; i < linha; i++){
        for(int j = 0; j < coluna; j++){
        //sendo c (pont em resp), a (em this) e b (em m)
          c.elemento = a.elemento + b.elemento;
          
          if (j + 1 < coluna) {
            c.dir.esq = c.inf.sup = c.sup.inf = c;
            c = c.dir;
          }
        }

        if (i + 1 < linha) {
          a = a2 = a2.inf;
          b = b2 = b2.inf;


          c = c2 = c2.inf;
        }
      }
    }

    return resp;
   }

   /*

   public Matriz multiplicacao (Matriz m) {
      Matriz resp = null;

      if(){
         //...
      }

      return resp;
   }

   public boolean isQuadrada(){
      boolean (this.linha == this.coluna);
   }

   public void mostrarDiagonalPrincipal (){
      if(isQuadrada() == true){

      }
   }

   public void mostrarDiagonalSecundaria (){
      if(isQuadrada() == true){
      }
   }

   */
}

class ListaMatriz {
  public static void main (String[] args) {
    Matriz m = new Matriz();
  }
}
