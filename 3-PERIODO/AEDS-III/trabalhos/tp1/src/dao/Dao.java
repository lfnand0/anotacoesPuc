package dao;

import java.io.*;
import java.text.*;

public class Dao {
    protected int idConta;
    protected String nomePessoa;
    protected int cpf;
    protected String cidade;
    protected int transferenciasRealizadas;
    protected float saldoConta;

    /* NULL Constructor */
    public Dao(){
        this.idConta = -1;
        this.nomePessoa = "";
        this.cpf = -1;
        this.cidade = "";
        this.transferenciasRealizadas = 0;
        this.saldoConta = 0.00F;
    }

    /* Constructor */
    public Dao (String nome, int cpf, String cidade){
        this.idConta = getMaxId();
        this.nomePessoa = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.transferenciasRealizadas = 0;
        this.saldoConta = 0.00F;       
    }
    
    /* Get max id */
    private int getMaxId(){
        RandomAccessFile arq;
        int maxId = 0;

        try {
            arq = new RandomAccessFile("../../db/bankS.db", "rw");
            /* 
            - Vai para o posicao 0 do arquivo
            - Le o maior id e associa ele +1 a idConta
            - Volta e atualiza o maior id
            */
            arq.seek(0);
            maxId = arq.readInt() + 1;
            arq.writeInt(maxId);
            arq.seek(0);
            arq.close();
        } catch (Exception e) {}

        return maxId;
    }

    /* Create account */
    public int create (Dao object){ 
        RandomAccessFile arq;
        byte[] ba;

        try {
            arq.writeBoolean(true);
            ba = toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);
            arq.close();
        } catch (Exception e) {}
    
        return this.idConta;
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
