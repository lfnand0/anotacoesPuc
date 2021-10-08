import java.util.*;
import java.io.*;

class Pergunta_14 {



  public static int[] sort(int[] arr, int n, int m) {
    int length = arr.length;
    if (length != n + m) {
      return arr;
    } else {
      for (int i = n + 1; i < length; i++) {
        int temp = arr[i];
        int j = i - 1;
        while ((j > - 1) && (arr[j] > temp)) {
          arr[j + 1] = arr[j];
          j--;
        }
        arr[j + 1] = temp;
      }

      return arr;
    }
  }




}
