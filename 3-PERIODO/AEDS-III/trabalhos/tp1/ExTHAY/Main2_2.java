package dados;

import java.io.RandomAccessFile;
import java.util.Scanner;


import java.io.IOException;

 class Main2 {
    public static Scanner sc = new Scanner(System.in); 
    public static  void rar(RandomAccessFile arq){
        try{
        arq = new RandomAccessFile("dados/cliente.db", "rw");
        } catch (Exception e) {
        }
    }

    public static  void CriarConta(Scanner tec, RandomAccessFile arq) throws IOException {
        rar(arq);
        //create
            byte[] ba;
            Cliente c1;
            String nome = "";
            String cpf = "";
            String cidade = "";

            sc.nextLine();
            for(int x = 0; x != 1;){
                System.out.print("Por favor digite o nome:"); nome = sc.nextLine();
                if(nome.length() < 100){
                    x = 1;
                }else System.out.println("Por favor, abrevie o nome!");
            }
            for(int x = 0; x != 1;){
                System.out.print("Por favor digite o cpf do paciente->"); cpf = sc.nextLine();
                if((cpf.length() >= 1 && cpf.length() <= 999999999)){
                    x = 1;
                }else System.out.println("Por favor, digite um cpf válido!");
            }
            for(int x = 0; x != 1;){
                System.out.print("Por favor digite a cidade do cliente:"); cidade = sc.nextLine();
                if(cidade.length() < 30){
                    x = 1;
                }else System.out.println("Por favor, abrevie o nome da cidade!");
            }

            c1 = new Cliente(nome, cpf, cidade);
            c1.print();

            ba = c1.toByteArray();
            arq.seek(arq.length());
            arq.writeChar(' ');//escrita da lapide
            arq.writeInt(ba.length);//escrita do tamanho do arquivo
            arq.write(ba);

    }
    public static void dadosCliente(Scanner tec,RandomAccessFile arq) throws IOException {
        rar(arq);
        try {
            byte[] ba;
            Cliente c1;

            int idCliente;

            System.out.print("id do time: ");
            idCliente = sc.nextInt();

            char lapide;
            int tam = 0;
            int idDetectado = -1;

                int i = 4;

                while (idCliente != idDetectado && i < arq.length()) {
                    arq.seek(i);

                    lapide = arq.readChar();// Leitura da lapide 
                    i += 2;
                    arq.seek(i);
                    tam = arq.readInt();
                    i += 4;
                    
                    if (lapide == ' ') {
                        arq.seek(i);
                        idDetectado = arq.readInt();
                    }
                    i += tam;
                }

                if (idCliente == idDetectado) {
                    arq.seek(i - tam);
                    ba = new byte[tam];
                    arq.read(ba);
                    c1 = new Cliente();
                    c1.fromByteArray(ba);

                    c1.print();

                    //return c1

                } else {
                    System.out.println("Arquivo nao encontrado");
                }

            } catch (Exception e) {
                System.out.println("Arquivo nao encontrado (nenhum registro no arquivo)");
            }
}
public static void updateCliente( Scanner tec, RandomAccessFile arq) throws IOException {
    rar(arq);
    try {
        byte[] ba;
        Cliente c1;

        int idCliente;

        System.out.print("id do time: ");
        idCliente = sc.nextInt();

        char lapide;
        int tam = 0;
        int idDetectado = -1;

            int i = 4;

            while (idCliente != idDetectado && i < arq.length()) {
                arq.seek(i);

                lapide = arq.readChar();// Leitura da lapide 
                i += 2;
                arq.seek(i);
                tam = arq.readInt();
                i += 4;
                
                if (lapide == ' ') {
                    arq.seek(i);
                    idDetectado = arq.readInt();
                }
                i += tam;
            }

            if (idCliente == idDetectado) {
                //Criar nome cliente

                String nome = "";
                String cpf = "";
                String cidade = "";
                int transferencias = -1;
                float saldo = 0F;

                for(int x = 0; x != 1;){
                    System.out.print("Por favor digite o nome:"); nome = sc.nextLine();
                    if(nome.length() < 100){
                        x = 1;
                    }
                    else System.out.println("Por favor, abrevie o nome!");
                }
                for(int x = 0; x != 1;){
                    System.out.print("Por favor digite o cpf do paciente->"); cpf = sc.nextLine();
                    if((cpf.length() >= 1 && cpf.length() <= 999999999)){
                        x = 1;
                    }else System.out.println("Por favor, digite um cpf válido!");
                }
                for(int x = 0; x != 1;){
                    System.out.print("Por favor digite a cidade do cliente:"); cidade = sc.nextLine();
                    if(cidade.length() < 30){
                        x = 1;
                    }else System.out.println("Por favor, abrevie o nome da cidade!");
                }
                for(int x = 0; x != 1;){
                    System.out.print("Por favor digite as tranferencias realizadas:"); transferencias = sc.nextInt();
                }
                for(int x = 0; x != 1;){
                    System.out.print("Por favor digite seu saldo:"); saldo = sc.nextInt();
                }

                c1 = new Cliente(idCliente, nome, cpf, cidade, transferencias, saldo);
                ba = c1.toByteArray();

                //tentar colocar novo cliente no lugar do cliente antigo
                if (ba.length <= tam){
                    arq.seek(i - tam);
                    arq.write(ba);

                }
                //apagar cliente antigo e colocar o cliente novo no final do arquivo
                else{
                    arq.seek(i - (tam + 6));
                    arq.writeChar('*');
                    arq.seek(arq.length());
                    arq.writeChar(' ');
                    arq.writeInt(ba.length);
                    arq.write(ba);

                }
            } else {
                System.out.println("Arquivo nao encontrado");
            }

        }catch (Exception e) {
            System.out.println("Arquivo nao encontrado (nenhum registro no arquivo)");
        }
}
public static void Transferencia(Scanner tec, RandomAccessFile arq) throws IOException {
    rar(arq);
    try {
        byte[] ba;
        Cliente c1;
        Cliente c2;

        int idCliente;
        int idCliente2;
        int saldo=100;
        int qntTransferida=0;
        System.out.print("id do cliente 1: ");
        idCliente = sc.nextInt();
        System.out.print("id do cliente 2: ");
        idCliente2 = sc.nextInt();
        System.out.print("quantidade que quer transferir: ");
        qntTransferida = sc.nextInt();


        char lapide;
        int tam = 0;
        int idDetectado = -1;

            int i = 4;

            while (idCliente != idDetectado && i < arq.length()) {
                arq.seek(i);

                lapide = arq.readChar();// Leitura da lapide 
                i += 2;
                arq.seek(i);
                tam = arq.readInt();
                i += 4;
                
                if (lapide == ' ') {
                    arq.seek(i);
                    idDetectado = arq.readInt();
                }
                i += tam;
            }

            if (idCliente == idDetectado) {
                arq.seek(i - tam);
                ba = new byte[tam];
                arq.read(ba);
                c1 = new Cliente();
                c1.fromByteArray(ba);
                c1.saldoConta += qntTransferida;
                c1.print();

                //return c1

            } else {
                System.out.println("Arquivo nao encontrado");
            }

            while (idCliente2 != idDetectado && i < arq.length()) {
                arq.seek(i);

                lapide = arq.readChar();// Leitura da lapide 
                i += 2;
                arq.seek(i);
                tam = arq.readInt();
                i += 4;
                
                if (lapide == ' ') {
                    arq.seek(i);
                    idDetectado = arq.readInt();
                }
                i += tam;
            }

            if (idCliente2 == idDetectado) {
                arq.seek(i - tam);
                ba = new byte[tam];
                arq.read(ba);
                c2 = new Cliente();
                c2.fromByteArray(ba);
                c2.saldoConta -= qntTransferida;
                c2.print();

                //return c1

            } else {
                System.out.println("Arquivo nao encontrado");
            }
        } catch (Exception e) {
            System.out.println("Arquivo nao encontrado (nenhum registro no arquivo)");
        }
}
public static void deletarCliente( Scanner tec, RandomAccessFile arq) throws IOException { try {
    rar(arq);
    byte[] ba;
    Cliente c1;

    int idCliente;

    System.out.print("id do time: ");
    idCliente = sc.nextInt();

    char lapide;
    int tam = 0;
    int idDetectado = -1;

        int i = 4;

        while (idCliente != idDetectado && i < arq.length()) {
            arq.seek(i);

            lapide = arq.readChar();// Leitura da lapide 
            i += 2;
            arq.seek(i);
            tam = arq.readInt();
            i += 4;
            
            if (lapide == ' ') {
                arq.seek(i);
                idDetectado = arq.readInt();
            }
            i += tam;
        }

        if (idCliente == idDetectado) {
        arq.seek(i - (tam + 6));
        arq.writeChar('*');
        System.out.println("\nArquivo deletado:");

        arq.seek(i - tam);
        ba = new byte[tam];
        arq.read(ba);
        c1 = new Cliente();
        c1.fromByteArray(ba);
        c1.print();

    } else {
            System.out.println("Arquivo nao encontrado");
        }

    } catch (Exception e) {
        System.out.println("Arquivo nao encontrado (nenhum registro no arquivo)");
    }
    arq.close();
}
        //create
  

    public static void main (String[] args) throws Exception{
        RandomAccessFile arq = new RandomAccessFile("dados/cliente.db", "rw");
        int escolha=0;

        //MENU RECURSIVO COM OPCAO DE PARADA SE NECESSARIO
        do{
            System.out.println("\nMenu de opcoes:\n1 - Criar uma conta\n2 - Obter dados de um cliente\n"+
                            "3 - Alterar dados do cliente\n4 - Realizar uma Transferencia\n5 - Deletar\n0 - Sair do sistema");
            System.out.print("\nQual opção desejada:"); 
            escolha = sc.nextInt();
            sc.nextLine();
            switch(escolha){
                case 1:
                    CriarConta(sc,arq);
                break;

                case 2:
                    dadosCliente(sc,arq);
                break;

                case 3:
                    updateCliente(sc,arq);
                break;

                case 4:

                break;

                case 5:
                    deletarCliente(sc,arq);
                break;
                
                case 0:
                    System.out.println("\nTenha um otimo dia!");
                break;

                default:
                    System.out.println("\nPor favor, escolha uma opcao valida!");
                break;
            }
        }while(escolha != 0);
    }

}

