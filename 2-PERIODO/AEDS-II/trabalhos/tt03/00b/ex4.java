class ex3 {
  public static String maiorEMenor(int[] arr) {
    int maior, menor;
    maior = menor = arr[0];
    for (int i = 1; i < arr.length; i++) { 
      // Esse é o método mais eficiente de encontrar o maior e menor valor
      // em um array desordenado
      if (maior < arr[i]) { 
        maior = arr[i];
      }
      if (menor > arr[i]) {
        menor = arr[i];
      }
    }
    String resposta = "Maior: " + maior + ", Menor: " + menor;
    return resposta;
  }

  public static void main(String[] args) {
    int[] array = {8, 2, 7, 5, 4, 6, 1, 3};
    System.out.println(maiorEMenor(array));
  }
}
