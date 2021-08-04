package ex3;

public class ex3 {
  public static void main(String[] args) {

  }

  public static void maiorEMenor(int[] array) {
    int maior = array[0];
    int menor = array[0];
    for (int num : array) {
      if (maior > num) {
        maior = num;
      }
      if (menor < num) {
        menor = num;
      }
    }

    System.out.printf("Maior: %d", maior);
    System.out.printf("Menor: %d", menor);
  }
}
