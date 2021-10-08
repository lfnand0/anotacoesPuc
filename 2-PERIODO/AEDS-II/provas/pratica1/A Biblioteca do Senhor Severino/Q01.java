import java.io.*;

class Q01 {
  public static String[] sort(String[] arr, int length) {
    for (int i = 0; i < length; i++) {
      for (int j = 1; j < length - i; j++) {
        int a = Integer.parseInt(arr[j - 1].trim());
        int b = Integer.parseInt(arr[j].trim());
        if (a > b) {
          String temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) throws Exception {
    String linha = "";
    String[] codigos = new String[1000];
    int pos = 0;

    InputStreamReader isr = new InputStreamReader(new FileInputStream("./pub.in"));
    BufferedReader br = new BufferedReader(isr);

    while ((linha = br.readLine()) != null) {
      if (linha.length() < 4) {
        int num = Integer.parseInt(linha);
        String[] auxArr = new String[1000];

        for (int i = 0; i < num; i++) {
          auxArr[i] = br.readLine();
        }

        auxArr = sort(auxArr, num);
        for (int i = 0; i < num; i++) {
          codigos[pos] = auxArr[i];
          pos++;
        }
      }
    }

    for (int i = 0; i < pos; i++) {
      MyIO.println(codigos[i]);
    }

    br.close();
  }
}
