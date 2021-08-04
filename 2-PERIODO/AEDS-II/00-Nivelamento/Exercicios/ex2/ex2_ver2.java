package ex2;

public class ex2_ver2 {
  public static void main(String[] args) {
    int[] a = { 1, 3, 5, 7, 9, 11, 15 };
    System.out.println(contemValor(a, 7));
    System.out.println(contemValor(a, 1));
    System.out.println(contemValor(a, 15));
    System.out.println(contemValor(a, 16));
  }

  public static Boolean contemValor(int[] arrayNums, int x) {
    
    if (arrayNums.length == 1) {
      return (x == arrayNums[0]);
    }

    int posMax = arrayNums.length - 1;
    int posMin = 0;
    while (posMin <= posMax) {
      int i = (posMin + posMax) / 2;
      // System.out.printf("posMin = %d, posMax = %d, i = %d, array[i] = %d\n", posMin, posMax, i, arrayNums[i]);
      if (arrayNums[i] < x) {
        posMin = i + 1;
      } else if (arrayNums[i] > x) {
        posMax = i - 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
