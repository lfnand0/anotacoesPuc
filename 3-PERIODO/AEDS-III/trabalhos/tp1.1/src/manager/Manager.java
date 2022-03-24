package manager;

import java.io.*;

public class Manager {
  private String dbPath = "";

  public Manager(String dbPath) {
    this.dbPath = dbPath;
  }

  private boolean dbExists() {
    boolean exists = false;
    System.out.println("dbExists");

    RandomAccessFile arq;
    try {
      arq = new RandomAccessFile(dbPath, "rw");
      arq.close();
    } catch (Exception e) {
      System.out.println("randomaccessfile error: " + e);
    }

    File f = new File(dbPath);
    if (f.exists() && !f.isDirectory()) {
      exists = true;
    }

    return exists;
  }

  /*
   * Get Max id
   * - Movimenta o ponteiro pro inicio do arquivo
   * - Le e retrona o maior id
   * - Ou soma +1 e o atualiza e o retorna
   */
  public int getMaxId(boolean update) {
    RandomAccessFile arq;
    int maxId = 0;

    dbExists();
    try {
      arq = new RandomAccessFile(dbPath, "rw");

      arq.seek(0);
      maxId = arq.length() == 0 ? 0 : arq.readInt();
      if (update) {
        arq.seek(0);
        maxId++;
        arq.writeInt(maxId);
      }

      arq.close();
    } catch (Exception e) {
      System.out.println(e);
    }

    return maxId;
  }

  public int getMaxId() {
    return getMaxId(false);
  }

  public long findIdPointer(int id) {
    long returns = -1;
    try {
      RandomAccessFile arq = new RandomAccessFile(dbPath, "rw");

      arq.seek(0);
      int maxId = arq.readInt();
      if (id <= maxId) {
        for (int i = id; i > 1; i--) {
          arq.readBoolean(); // Lápide
          int tam = arq.readInt(); // Tamanho do arr
          arq.seek(arq.getFilePointer() + tam);
        }

        boolean lapide = arq.readBoolean();

        if (!lapide) {
          returns = arq.getFilePointer() - 1;
        }
      }

      arq.close();
    } catch (Exception e) {
    }

    return returns;
  }

  /*
   * Create
   * - Movimento o ponteiro pro final do arquivo
   * - Insere a lapide
   * - Insere o tamanho do arquivo
   * - Insere dados do arquivo
   */
  public boolean appendToFile(byte[] arr) {
    RandomAccessFile arq;
    try {
      arq = new RandomAccessFile(dbPath, "rw");
      arq.seek(arq.length());
      arq.writeBoolean(true);
      arq.writeInt(arr.length);
      arq.write(arr);
      arq.close();
    } catch (Exception e) {
    }
    return true;
  }

  /*public byte [] read(int id){
    byte[] ba;
    RandomAccessFile arq;

    try{
      arq = new RandomAccessFile(dbPath, "rw");
      arq.seek(findIdPointer(id));
      ba = new byte[arq.readInt()];
      arq.read(ba);
      arq.close();
    } catch (Exception e) {
    }

    return ba;
  }*/
}