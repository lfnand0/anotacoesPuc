package ex2;
/* 

Repita o exercício acima considerando que os elementos do array estão ordenados de forma crescente. Uma sugestão seria começar a pesquisa pelo meio do

*/

public class ex2 {
  public static void main(String[] args) {
    int[] a = { 1, 3, 5, 7, 9, 11 };
    System.out.println(contemValor(a, 7));
    System.out.println(contemValor(a, 2));
    System.out.println(contemValor(a, 4));
    System.out.println(contemValor(a, 5));
  }

  public static Boolean contemValor(int[] arrayNums, int x) {
    int metadeDoArray = arrayNums.length / 2;

    if (arrayNums[metadeDoArray] < x) {
      for (int i = metadeDoArray; i < arrayNums.length; i++) {
        if (arrayNums[i] == x) {
          return true;
        } else if (arrayNums[i] > x) {
          return false;
        }
      }

      return false;

    } else if (arrayNums[metadeDoArray] > x) {
      for (int i = metadeDoArray; i >= 0; i--) {
        if (arrayNums[i] == x) {
          return true;
        } else if (arrayNums[i] < x) {
          return false;
        }
      }

      return false;

    } else {
      return true;
    }
  }
}
