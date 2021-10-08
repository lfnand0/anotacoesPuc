class Q02 {
  public static int calcular(int e1, int e2, int e3, int x) {
    int retorno = 0;
    if (e1 - e2 <= x) {
      retorno = e2;
    } else {
      retorno = e3;
    }

    return retorno;
  }

  public static void main(String[] args) {
    int e1 = MyIO.readInt();
    int e2 = MyIO.readInt();
    int e3 = MyIO.readInt();
    int x = MyIO.readInt();

    MyIO.println(calcular(e1, e2, e3, x));
  }
}
