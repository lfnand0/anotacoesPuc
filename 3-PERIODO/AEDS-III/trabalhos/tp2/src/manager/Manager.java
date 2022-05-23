package manager;

import java.io.*;

import dao.*;

/**
 * CLASSE MANAGER
 * 
 * Nível mais baixo de execução, realiza operações
 * diretamente no arquivo, como pesquisa,
 * alteração, adição e remoção de registros, etc.
 * 
 * Recebe ordens da DAO
 * 
 */
public class Manager {
  /**
   * dbPath: diretório onde a base de dados será armazenada
   */
  private String dbPath = "";
  // protected ManagerIndex manIndex = new ManagerIndex();

  /**
   * Construtor básico
   * 
   * @param dbPath: diretório da base de dados, que é salvo
   *                como um atributo no objeto
   */
  public Manager(String dbPath) {
    this.dbPath = dbPath;
  }

  /**
   * Função auxiliar que checa se o arquivo da base de dados
   * está presente no dbPath, e caso não esteja, o cria.
   * 
   * @param dbPath: Diretório da base de dados
   * @return boolean: true ou false caso a operação seja
   *         bem-sucedida ou não
   */
  public static boolean dbExists(String dbPath) {
    boolean exists = false;
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

  /**
   * Função que encontra o maior ID presente no cabeçalho do
   * arquivo
   * 
   * @param update: caso seja true, reescreve o valor do cabeçalho,
   *                adicionando +1 a ele
   * @return int: retorna o valor do maior ID do arquivo
   */
  public int getMaxId(boolean update) {
    int maxId = 0;
    RandomAccessFile arq;

    dbExists(dbPath);

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
    }
    return maxId;
  }

  /**
   * Adiciona um array de bytes ao fim do arquivo
   * 
   * @param ba: Array de bytes a ser adicionado ao arquivo
   * @return boolean: true ou false caso a operação seja
   *         bem-sucedida
   */
  public boolean appendToFile(byte[] ba) {
    RandomAccessFile arq;

    try {
      arq = new RandomAccessFile(dbPath, "rw");
      arq.seek(arq.length());
      arq.writeBoolean(true);
      arq.writeInt(ba.length);
      arq.write(ba);
      arq.close();
    } catch (Exception e) {
    }

    return true;
  }

  /**
   * Função para gerar um objeto DAO a partir
   * do registro cujo ID seja equivalente ao
   * recebido como parâmetro
   * 
   * @param id: ID do registro a ser lido
   * @return Dao: retorna um objeto inválido caso o ID
   *         seja inválido, ou um objeto contendo os atributos
   *         coletados do registro
   */
  public static Dao read(long pos) {
    byte[] ba;
    RandomAccessFile arq;
    Dao conta = new Dao();
    String dbPath = "../db/bank.db";

    try {
      arq = new RandomAccessFile(dbPath, "rw");
      if (pos < arq.length()) {
        arq.seek(pos + 1);
        int tam = arq.readInt();
        ba = new byte[tam];
        arq.read(ba);
        conta.fromByteArray(ba);

        arq.close();
      }

    } catch (Exception e) {
      System.out.println(e);
    }

    return conta;
  }

  /**
   * Função de atualização de registros
   * 
   * Caso o novo array de bytes possua um tamanho maior que o
   * do seu registro original, alteramos a lápide do original
   * para false e adicionamos o registro atualizado ao fim do
   * arquivo; Caso possua um tamanho menor ou igual ao registro
   * original, sobrescrevemos o registro com o novo array de
   * bytes
   * 
   * @param ba: Novo array de bytes
   * @param id: ID do registro a ser atualizado
   * @return boolean: true ou false caso a operação seja
   *         bem-sucedida
   */
  public boolean update(byte[] ba, long pos) {
    RandomAccessFile arq;

    if (ba.length == 0 || pos < 0) {
      return false;
    }

    try {
      arq = new RandomAccessFile(dbPath, "rw");
      arq.seek(pos + 1);
      int tam = arq.readInt();

      if (ba.length <= tam) {
        arq.write(ba);
      } else {
        delete(pos);
        appendToFile(ba);
      }
    } catch (Exception e) {
      System.out.println(e);
    }

    return true;
  }

  /**
   * Altera a lápide de um registro para false
   * 
   * @param id: ID do registro a ser deletado
   * @return boolean: true ou false caso a operação seja
   *         bem-sucedida
   */
  public boolean delete(long pos) {
    RandomAccessFile arq;
    boolean tf = false;

    try {
      arq = new RandomAccessFile(dbPath, "rw");
      // pos = pos - 1;

      if (pos > 0) {
        arq.seek(pos);
        arq.writeBoolean(false);
        tf = true;
      }

      arq.close();
    } catch (Exception e) {
    }
    return tf;
  }

}
