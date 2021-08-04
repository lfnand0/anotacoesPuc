public class ex10 {
  public static void main(String[] args) {
    int x = funcaoA(3);
    System.out.println("Valor: " + x);
  }

  public static int funcaoA (int n) {
    int x = 1000;
    for (int i = 0; i < n; i++) {
      x -= 3;
      for (int j = 0; j < n; i++) {
        x -= 2;
      }
    }

    return x;
  }
}
