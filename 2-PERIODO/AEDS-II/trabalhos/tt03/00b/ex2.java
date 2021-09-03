class ex2 {
  public static boolean estaContido(int[] arr, int x) {
    boolean resposta = false;
    int direita = arr.length - 1, esquerda = 0, meio;
    while (esquerda <= direita) { 
      meio = esquerda + ((direita - esquerda)/2);
      if (arr[meio] < x) {
        esquerda = meio + 1;
      } else if (arr[meio] > x) {
        direita = meio - 1;
      } else if (arr[meio] == x) {
        resposta = true;
        break; // sair do while
      }
    }

    return resposta;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println(estaContido(array, 0));
    System.out.println(estaContido(array, 1));
    System.out.println(estaContido(array, 2));
    System.out.println(estaContido(array, 3));
    System.out.println(estaContido(array, 4));
    System.out.println(estaContido(array, 5));
    System.out.println(estaContido(array, 6));
    System.out.println(estaContido(array, 7));
    System.out.println(estaContido(array, 8));
    System.out.println(estaContido(array, 9));
  }
}
