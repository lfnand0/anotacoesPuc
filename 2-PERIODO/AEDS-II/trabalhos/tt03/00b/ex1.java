class ex1 {
  public static boolean estaContido(int[] arr, int x) {
    boolean resposta = false;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        resposta = true;
        i = arr.length;
      }
    }
    return resposta;
  }

  public static void main(String[] args) {
    int[] array = {8, 2, 7, 4, 6, 5, 3, 1};
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
