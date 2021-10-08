import java.util.Scanner;

public class Sequencia
{
  public static String sequencia ()
  {
    Scanner sc = new Scanner(System.in);
    String x = "";
    String q = "";
    int estado = 1;
    String input = sc.nextLine();
    while ((input.charAt(0) == '0' || input.charAt(0) == '1') && input.length() == 1){
        x += input;
   if (estado == 1){
       if (input.charAt(0) == '1'){
       estado++; // Muda para o estado 2
       }
       q += '0';
       System.out.println("Estado " + estado);
   }
   else if (estado == 2){
       if (input.charAt(0) == '1'){
       estado++; // Muda para o estado 3
       
       }
       else{
       estado = 1; // Volta para o estado 1
       }
       q += '0';
       System.out.println("Estado " + estado);
   }
   else if (estado == 3){
       if (input.charAt(0) == '0'){
       estado++;
       }
       System.out.println("Estado " + estado);
       
       if (estado == 4) {
           // Sequência encontrada
           q += '1';
       System.out.println("Sequência detectada: 110");
           estado = 1; // Ao chegar no estado 4, volta para o estado 1;
       } else {
           q += '0';
       }
   }
   
   input = sc.nextLine();
      }
    System.out.println("x: " + x);
    System.out.println("q: " + q);
     
    sc.close();
    return q;
  }
  public static void main (String[]args){
    String q = sequencia();
  }
}
