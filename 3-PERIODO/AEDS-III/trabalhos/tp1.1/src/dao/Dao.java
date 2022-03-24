package dao;

import java.io.*;
import java.text.*;

import manager.*;

public class Dao {
  protected int idConta;
  protected String nomePessoa;
  protected int cpf;
  protected String cidade;
  protected int transferenciasRealizadas;
  protected float saldoConta;
  protected Manager manager = new Manager("db/bank.db");

  /* NULL Constructor */
  public Dao() {    
    this.idConta = -1;
    this.nomePessoa = "";
    this.cpf = -1;
    this.cidade = "";
    this.transferenciasRealizadas = 0;
    this.saldoConta = 0.00F;
  }

  /* Constructors */ 
  public Dao(int idConta, String nome, int cpf, String cidade) {
    this(idConta, nome, cpf, cidade, 0, 0.00F);
  }

  public Dao(int idConta, String nome, int cpf, String cidade, int transferenciasRealizadas, float saldoConta) {
    this.idConta = idConta;
    this.nomePessoa = nome;
    this.cpf = cpf;
    this.cidade = cidade;
    this.transferenciasRealizadas = transferenciasRealizadas;
    this.saldoConta = saldoConta;
  }

  public Dao(String nome, int cpf, String cidade) {
    this.idConta = manager.getMaxId(true);
    this.nomePessoa = nome;
    this.cpf = cpf;
    this.cidade = cidade;
    this.transferenciasRealizadas = 0;
    this.saldoConta = 0.00F;;
  }  

  public int create() {
    try {
      if(manager.appendToFile(toByteArray())){
        return this.idConta;
      }
    } catch (Exception e) {
    }

    return -1;
  }

  public void read(int id){
    try {
      
      


      fromByteArray();


    } catch (Exception e) {
    }
    //return object;
  }

  /* PRINT */
  public String toString() {
    DecimalFormat df = new DecimalFormat("#,##0.00");

    return "\n ID.............: " + this.idConta +
        "\n Nome do Titular: " + this.nomePessoa +
        "\n CPF............: " + this.cpf +
        "\n Cidade.........: " + this.cidade +
        "\n Transferencias.: " + this.transferenciasRealizadas +
        "\n Saldo..........: R$ " + df.format(this.saldoConta);
  }

  /* Write on file */
  private byte[] toByteArray() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);

    dos.writeInt(this.idConta);
    dos.writeUTF(this.nomePessoa);
    dos.writeInt(this.cpf);
    dos.writeUTF(this.cidade);
    dos.writeInt(this.transferenciasRealizadas);
    dos.writeFloat(this.saldoConta);

    return baos.toByteArray();
  }

  /* Read form file */
  private void fromByteArray(byte[] ba) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);

    idConta = dis.readInt();
    nomePessoa = dis.readUTF();
    cpf = dis.readInt();
    cidade = dis.readUTF();
    transferenciasRealizadas = dis.readInt();
    saldoConta = dis.readFloat();
  }
}
