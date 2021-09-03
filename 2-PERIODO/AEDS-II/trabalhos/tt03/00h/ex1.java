class ex1 {
  void mostrarIterativo() {
    for(int i = 0; i <= 3; i++) {
      MyIO.println(i);
    }
  }

  void mostrarRecursivo(int pos) {
    if (pos <= 3) {
      MyIO.println(i);
      mostrarRecursivo(pos + 1);
    }
  }
}
