class copia {
  public static void main(String[]args) {
    Arq.openRead("exemplo.txt");
    String resposta = Arq.readAll();
    Arq.close();
   
    Arq.openWrite("exemplo_copia.txt");
    Arq.println(resposta);
    Arq.close();

  }
}
