class PesquisaBinariaRecursiva {
  public static int pesquisa(int[] array, int esq, int dir, int chave) {
    int metade = (dir + esq)/2;
    int returnedValue;
    
    if (dir < esq) {
      returnedValue = -1;
    } else if (chave == array[metade]) {
      returnedValue = metade;
    } else if (chave > metade) {
      returnedValue = pesquisa(array, metade + 1, dir, chave);
    } else {
      returnedValue = pesquisa(array, esq, metade - 1, chave);
    }

    return returnedValue;
  }

  public static void main (String[] args){
    int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    int l = array.length - 1;
    System.out.println(pesquisa(array, 0, l, 0));
    System.out.println(pesquisa(array, 0, l, 1));
    System.out.println(pesquisa(array, 0, l, 2));
    System.out.println(pesquisa(array, 0, l, 3));
    System.out.println(pesquisa(array, 0, l, 4));
    System.out.println(pesquisa(array, 0, l, 5));
    System.out.println(pesquisa(array, 0, l, 6));
    System.out.println(pesquisa(array, 0, l, 7));
    System.out.println(pesquisa(array, 0, l, 8));
    System.out.println(pesquisa(array, 0, l, 9));
    System.out.println(pesquisa(array, 0, l, 10));
  }
}
