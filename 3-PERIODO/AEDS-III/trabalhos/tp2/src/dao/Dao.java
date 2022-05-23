package dao;

import java.io.*;
import java.text.*;
import java.util.*;

import manager.*;

/**
 * CLASSE DAO
 * 
 * Segunda camada da execução do programa, responsável
 * por organizar e armazenar temporariamente os dados,
 * receber ordens do App.java,validar inputs e por fim
 * realizar chamadas ao Manager
 * 
 * Não realiza operações diretamente no arquivo
 * 
 */
public class Dao {
  static Scanner sc = new Scanner(System.in);

  protected int idConta;
  protected String nomePessoa;
  protected String cpf;
  protected String cidade;
  protected int transferenciasRealizadas;
  protected float saldoConta;
  protected Manager manager = new Manager("../db/bank.db");
  protected ManagerIndex manIndex = new ManagerIndex("../db/bank.db");

  /* CONSTRUTORES */

  /**
   * Construtor vazio, gera um objeto com parâmetros
   * inválidos
   * 
   */
  public Dao() {
    this.idConta = -1;
    this.nomePessoa = "";
    this.cpf = "";
    this.cidade = "";
    this.transferenciasRealizadas = 0;
    this.saldoConta = 0.00F;
  }

  /**
   * Construtor que gera uma classe e a popula com o
   * registro equivalente ao ID passado como parâmetro
   * 
   * @param id: ID do registro a ser clonado
   */
  public Dao(int id) {
    this();
    Dao conta = Dao.read(id);
    this.clone(conta);
  }

  /**
   * Construtor comum
   * 
   * @param nome:   Nome a ser atribuido
   * @param cpf:    CPF a ser atribuido
   * @param cidade: Cidade a ser atribuida
   */
  public Dao(String nome, String cpf, String cidade) {
    this.idConta = manager.getMaxId(true);
    this.nomePessoa = nome;
    this.cpf = cpf;
    this.cidade = cidade;
    this.transferenciasRealizadas = 0;
    this.saldoConta = 0.00F;
  }

  /* GETTERS E SETTERS */

  public int getId() {
    return this.idConta;
  }

  public String getNomePessoa() {
    return this.nomePessoa;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getCidade() {
    return this.cidade;
  }

  public int getTransferenciasRealizadas() {
    return this.transferenciasRealizadas;
  }

  public float getSaldoConta() {
    return this.saldoConta;
  }

  public void setNomePessoa(String nomePessoa) {
    this.nomePessoa = nomePessoa;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public void setTransferenciasRealizadas(int transferenciasRealizadas) {
    this.transferenciasRealizadas = transferenciasRealizadas;
  }

  public void setSaldoConta(float saldoConta) {
    this.saldoConta = saldoConta;
  }

  /* CRUD */

  /**
   * CREATE: Função para criar uma conta nova
   * 
   * Gera um array de bytes com as informações
   * atribuídas ao objeto (toByteArray()),
   * e as adiciona ao fim do arquivo
   * (manager.appendToFile())
   * 
   * @return int: ID da conta criada
   */
  public int create() {
    try {
      if (manager.appendToFile(toByteArray())) {
        manIndex.readDb();
        return this.idConta;
      }
    } catch (Exception e) {
    }

    return -1;
  }

  /**
   * READ: Leitura de registros
   * 
   * Busca no arquivo o registro com o ID
   * recebido como parâmetro (Manager.read(id)),
   * e o retorno como um objeto DAO
   * 
   * @param id: ID do registro a ser retornado
   * @return Dao: Registro formatado como objeto
   */
  public static Dao read(int id) {
    Dao conta = new Dao();

    conta = Manager.read(ManagerIndex.findIdPointer(id));

    return conta;
  }

  /**
   * UPDATE: Atualização de registros
   * 
   * O usuário receberá um prompt para
   * selecionar os campos que deseja
   * atualizar, que por sua vez serão
   * salvos como um objeto Dao, que é
   * convertido para um array de bytes
   * (toByteArray()) e passado para a
   * função manager.update() juntamente
   * ao ID do registro para que possa
   * ser adicionado ao arquivo.
   * 
   * 
   * @return boolean: retorna false caso
   *         a atualização não dê certo, e true
   *         caso seja bem-sucedida.
   */
  public boolean update() {
    if (ManagerIndex.findIdPointer(this.idConta) == -1) {
      return false;
    }

    String nomePessoaNovo = this.nomePessoa;
    String cpfNovo = this.cpf;
    String cidadeNovo = this.cidade;
    int transferenciasRealizadasNovo = this.transferenciasRealizadas;
    float saldoContaNovo = this.saldoConta;

    boolean retorno = false;
    int choiceUpdate = 0;
    int changed = 0;

    while (choiceUpdate != 6) {
      System.out.println("\n1. Atualizar nome;");
      System.out.println("2. Atualizar CPF;");
      System.out.println("3. Atualizar cidade;");
      System.out.println("4. Atualizar número de transferências realizadas;");
      System.out.println("5. Atualizar saldo;");

      if (choiceUpdate == 0) {
        System.out.println("6. Sair;");
      } else {
        System.out.println("6. Confirmar alterações;");
      }
      System.out.print("\nEscolha uma opção: ");

      choiceUpdate = sc.nextInt();

      while (choiceUpdate < 1 || choiceUpdate > 6) {
        System.out.print("Digite um valor de 1 a 6: ");
        choiceUpdate = sc.nextInt();
      }

      sc.nextLine();

      if (choiceUpdate != 6) {
        changed++;
      }

      switch (choiceUpdate) {
        case 1:
          System.out.print("Digite o novo nome: ");
          nomePessoaNovo = sc.nextLine();
          break;
        case 2:
          System.out.print("Digite o novo CPF: ");
          cpfNovo = sc.nextLine();
          break;
        case 3:
          System.out.print("Digite a nova cidade: ");
          cidadeNovo = sc.nextLine();
          break;
        case 4:
          System.out.print("Digite o novo número de transferências realizadas: ");
          transferenciasRealizadasNovo = sc.nextInt();
          sc.nextLine();
          break;
        case 5:
          System.out.print("Digite o novo saldo: ");
          saldoContaNovo = sc.nextFloat();
          sc.nextLine();
          break;
      }
    }

    if (changed != 0) {
      this.nomePessoa = (nomePessoaNovo != this.nomePessoa) ? nomePessoaNovo : this.nomePessoa;
      this.cpf = (cpfNovo != this.cpf) ? cpfNovo : this.cpf;
      this.cidade = (cidadeNovo != this.cidade) ? cidadeNovo : this.cidade;
      this.transferenciasRealizadas = (transferenciasRealizadasNovo != this.transferenciasRealizadas)
          ? transferenciasRealizadasNovo
          : this.transferenciasRealizadas;
      this.saldoConta = (saldoContaNovo != this.saldoConta) ? saldoContaNovo : this.saldoConta;

      try {
        retorno = manager.update(toByteArray(), ManagerIndex.findIdPointer(this.idConta));
        manIndex.readDb();
      } catch (Exception e) {
      }

      System.out.println("Conta atualizada com sucesso!");

    } else {
      retorno = true;
    }

    return retorno;
  }

  /**
   * DELETE: Apaga um registro do arquivo
   * 
   * Função auxiliar que passa o ID de um
   * registro a ser deletado para a função
   * manager.delete()
   * 
   * @param id: ID de um registro a ser
   *            deletado
   * 
   * @return boolean: true caso operação
   *         seja bem-sucedida, false caso contrário
   */
  public boolean delete(int id) {
    boolean retorno = manager.delete(ManagerIndex.findIdPointer(id));
    manIndex.readDb();
    return retorno;
  }

  /**
   * TRANSFER: Transfere um valor do objeto
   * ao registro cujo ID é recebido como parâmetro
   * 
   * Realiza checagem se o saldo da conta remetente
   * é suficiente para a transferência
   * 
   * @param id:    ID da conta destinatária
   * @param valor: Valor a ser transferido
   * @return boolean: true ou false caso a
   *         transferência tenha sido bem-sucedida
   *         ou não
   */
  public boolean transfer(int id, float valor) {
    Dao conta = new Dao(id);
    boolean retorno = false;

    if (this.saldoConta - valor >= 0) {
      this.saldoConta -= valor;
      this.transferenciasRealizadas += 1;
      conta.setSaldoConta(conta.getSaldoConta() + valor);

      try {
        byte[] ba = this.toByteArray();
        manager.update(ba, ManagerIndex.findIdPointer(this.idConta)); // Conta 1

        ba = conta.toByteArray();
        manager.update(ba, ManagerIndex.findIdPointer(conta.getId()));
        manIndex.readDb();
      } catch (Exception e) {
      }

      retorno = true;
    }

    return retorno;
  }

  public static int[] search(String path, String key) {
    // String namePath = "../db/nameList.db";
    RandomAccessFile arq;

    // int retorno[];

    try {
      arq = new RandomAccessFile(path, "rw");
      arq.seek(0);
      for (long pos = 0; pos < arq.length(); pos = arq.getFilePointer()) {
        String aux = arq.readUTF();
        int numIds = arq.readInt();
        if (aux.equals(key)) {
          int retorno[] = new int[numIds];
          for (int i = 0; i < numIds; i++) {
            retorno[i] = arq.readInt();
          }
          arq.close();
          return retorno;
        }
      }

      arq.close();
    } catch (Exception e) {}
    return null;
  }
  
  

  /**
   * Função auxiliar que imprime os atributos
   * do objeto formatadamente
   * 
   */
  public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.00");

    return "\n ID.............: " + this.idConta +
        "\n Nome do Titular: " + this.nomePessoa +
        "\n CPF............: " + this.cpf +
        "\n Cidade.........: " + this.cidade +
        "\n Transferencias.: " + this.transferenciasRealizadas +
        "\n Saldo..........: R$ " + df.format(this.saldoConta);
  }

  /**
   * Converte o objeto à um array de bytes
   * 
   * @return byte[]: Array de bytes contendo
   *         os atributos do objeto
   * @throws IOException: necessário para os métodos de
   *                      escrita (write) da classe DataOutputStream
   */
  private byte[] toByteArray() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);

    dos.writeInt(this.idConta);
    dos.writeUTF(this.nomePessoa);
    dos.writeUTF(this.cpf);
    dos.writeUTF(this.cidade);
    dos.writeInt(this.transferenciasRealizadas);
    dos.writeFloat(this.saldoConta);

    dos.close();
    return baos.toByteArray();
  }

  /**
   * Lê um array de bytes e atribui
   * seu conteúdo ao objeto
   * 
   * @param ba: Byte Array (array de bytes)
   * @throws IOException: necessário para os métodos
   *                      de leitura (read) da classe DataInputStream
   */
  public void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);

    this.idConta = dis.readInt();
    this.nomePessoa = dis.readUTF();
    this.cpf = dis.readUTF();
    this.cidade = dis.readUTF();
    this.transferenciasRealizadas = dis.readInt();
    this.saldoConta = dis.readFloat();
  }

  /**
   * Iguala os atributos de um objeto DAO
   * à outro
   * 
   * @param conta: objeto cujos atributos serão
   *               passados ao objeto fonte
   */
  private void clone(Dao conta) {
    this.idConta = conta.getId();
    this.nomePessoa = conta.getNomePessoa();
    this.cpf = conta.getCpf();
    this.cidade = conta.getCidade();
    this.transferenciasRealizadas = conta.getTransferenciasRealizadas();
    this.saldoConta = conta.getSaldoConta();
  }

  /**
   * Checa se existe um registro no arquivo cujo
   * ID é igual ao recebido no parâmetro
   * 
   * @param id: ID a ser checado
   * @return boolean: true caso o ID seja válidado,
   *         false caso contrário
   */
  public static boolean idIsValid(int id) {
    boolean returns = false;

    if (ManagerIndex.findIdPointer(id) != -1)
      returns = true;

    return returns;
  }
}
