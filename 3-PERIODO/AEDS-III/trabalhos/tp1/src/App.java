import java.util.*;

import dao.*;

/**
 * CLASSE APP
 * 
 * Classe de maior nível da aplicação, responsável pela interface
 * e pela coleta do input do usuário
 * 
 * Comunica-se com a DAO
 * 
 */
public class App {
    static Scanner sc = new Scanner(System.in);
    static Dao conta;

    /**
     * Função responsável por gerar a interface do app,
     * para que o usuário escolha a opção desejada
     * 
     * Cada opção chamará a(s) função(ões) responsável(is)
     * pela operação na classe DAO
     * 
     * 
     * @return int: O retorno é utilizado na execução principal
     *         (main) para que o aplicativo apenas pare de executar
     *         quando o valor de int choice = 6
     */
    public static int bankInterface() {
        int choice = 0;

        System.out.println("\n-----Conta Bancária-----");

        System.out.println("1. Criar uma conta bancária;");
        System.out.println("2. Realizar uma transferência;");
        System.out.println("3. Ler um registro;");
        System.out.println("4. Atualizar um registro;");
        System.out.println("5. Deletar um registro;");
        System.out.println("6. Sair;");

        System.out.print("\nEscolha uma opção: ");
        choice = sc.nextInt();
        while (choice < 1 || choice > 6) {
            System.out.print("Digite um valor de 1 a 6: ");
            choice = sc.nextInt();
        }

        int id;
        switch (choice) {
            case 1:
                System.out.print("\nDigite o nome: ");
                sc.nextLine();
                String nome = sc.nextLine();

                System.out.print("Digite o cpf: ");
                String cpf = sc.nextLine();

                System.out.print("Digite a cidade: ");
                String cidade = sc.nextLine();

                conta = new Dao(nome, cpf, cidade);
                id = conta.create();

                if (id != -1) {
                    System.out.print("\n CONTA CRIADA COM SUCESSO");
                    System.out.println(conta.toString());
                } else {
                    System.out.println("Houve um ERRO ao tentar criar sua conta");
                }
                break;

            case 2:
                System.out.print("\nDigite o ID da sua conta: ");
                int idA = sc.nextInt();

                if (!Dao.idIsValid(idA)) {
                    System.out.print("ID inválido.");
                    break;
                }

                conta = new Dao(idA);
                System.out.println(conta);

                System.out.print("\nDigite o ID da conta que receberá: ");
                int idB = sc.nextInt();

                while (idB == idA) {
                    System.out.print("Selecione um ID diferente do seu: ");
                    idB = sc.nextInt();
                }

                if (!Dao.idIsValid(idB)) {
                    System.out.print("ID inválido.");
                    break;
                }

                System.out.print("Digite o valor a ser transferido: ");
                float valor = sc.nextFloat();

                if (conta.transfer(idB, valor)) {
                    System.out.println(
                            "\nTransferência bem-sucedida (Seu novo saldo é de " + conta.getSaldoConta() + ").");
                } else {
                    System.out.println("\nID não encontrado ou saldo insuficiente");
                }
                break;

            case 3:
                System.out.print("\nDigite o ID da conta que deseja buscar: ");
                id = sc.nextInt();

                while (id <= 0) {
                    System.out.print("Digite um ID válido (maior que 0): ");
                    id = sc.nextInt();
                }

                if (!Dao.idIsValid(id)) {
                    System.out.println("Conta não encontrada.");
                    break;
                }
                conta = new Dao(id);

                if (conta.getId() != -1) {
                    System.out.println(conta);
                } else {
                    System.out.println("Erro ao atualizar.");
                }

                break;

            case 4:
                System.out.print("\nDigite o ID da conta a ser atualizada: ");
                id = sc.nextInt();

                if (!Dao.idIsValid(id)) {
                    System.out.println("ID inválido.");
                    break;
                }

                conta = new Dao(id);
                System.out.println(conta);

                if (!conta.update()) {
                    System.out.println("Erro ao atualizar conta.");
                }

                break;

            case 5:
                System.out.print("\nDigite o ID da conta a ser deletada: ");
                id = sc.nextInt();

                while (id <= 0) {
                    System.out.print("Digite um ID válido (maior que 0): ");
                    id = sc.nextInt();
                }

                conta = new Dao();

                if (conta.delete(id)) {
                    System.out.println("A conta de ID " + id + " foi deletada com sucesso");
                } else {
                    System.out.println("Erro ao deletar conta de ID " + id);
                }
                break;

            case 6:
                System.out.println("Até mais!");
                break;
        }

        return choice;
    }

    public static void main(String[] args) throws Exception {
        while (bankInterface() != 6) {
        }

        sc.close();
    }
}