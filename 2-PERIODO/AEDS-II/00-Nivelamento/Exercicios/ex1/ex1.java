package ex1;
/* 

Faça um método que receba um array de inteiros e um número inteiro x e retorne um valor booleano informando se o elemento x está contido no array.

*/

public class ex1 {
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6};
    System.out.println(contemValor(a, 10));
    System.out.println(contemValor(a, 2));
    System.out.println(contemValor(a, 0));
    System.out.println(contemValor(a, 6));
  }

  public static Boolean contemValor(int[] arrayNums, int x) {
    for (int num : arrayNums) {
      if (num == x) {
        return true;
      }
    }
    return false;
  }

}
