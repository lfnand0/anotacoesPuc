import java.io.*;

class TP01Q09 {
  public static void main(String[] args) throws Exception {
    int n = MyIO.readInt();
    RandomAccessFile raf = new RandomAccessFile("arq.txt", "rw");
    
    for (int i = 0; i < n; i++) {
      double num = MyIO.readDouble();
      // Lê os valores como double e os escreve no arquivo
      raf.writeDouble(num);
    }
    raf.close();

    raf = new RandomAccessFile("arq.txt", "r");
    
    for (int i = 0; i < n; i++) {
      raf.seek((n - 1 - i) * 8);
      // - i para irmos de trás para frente, - 1 pois precisamos acessar
      // o primeiro byte de cada double e * 8 pois um double possui 8 bytes
      double num = raf.readDouble();
      if (num % 1 == 0) {
        MyIO.println((int)num);
        // Como o pub.out printa os valores inteiros sem .0 no final, precisamos converter para int
        // Caso o valor seja um número real não-inteiro o resto da divisão por 1 não dá 0
      } else {
        MyIO.println(num);
      }
    }
    raf.close();
  }
}
