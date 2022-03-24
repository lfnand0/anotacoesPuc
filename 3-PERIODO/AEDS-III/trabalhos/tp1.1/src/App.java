import java.util.*;
import dao.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    static Dao conta;

    public static void bankInterface() {
        int choice = 0;

        System.out.println("-----Conta Bancária-----");

        System.out.println("1. Criar uma conta bancária;");
        System.out.println("2. Realizar uma transferência;");
        System.out.println("3. Ler um registro;");
        System.out.println("4. Atualizar um registro;");
        System.out.println("5. Deletar um registro;");
        System.out.println("6. Sair;");

        System.out.print("Escolha uma opção: ");
        choice = sc.nextInt();

        while (choice < 1 || choice > 6) {
            System.out.println("Escolha um valor de 1 a 6: ");
            choice = sc.nextInt();
        }

        switch (choice) {
            case 1:
                System.out.print("\nDigite o nome: ");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.print("Digite o cpf: ");
                int cpf = sc.nextInt();

                System.out.print("Digite a cidade: ");
                sc.nextLine();
                String cidade = sc.nextLine();

                conta = new Dao(nome, cpf, cidade);

                System.out.println("Seu ID é " + conta.create());
                System.out.println(conta.toString());
            break;

            case 2:
            break;

            case 3:
            break;

            case 4:
            break;

            case 5:
            break;

            case 6:

        }

        sc.close();
    }

    public static void main(String[] args) throws Exception {
        bankInterface();
    }
}
