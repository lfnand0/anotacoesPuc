package manager;

import java.io.*;

public class ManagerIndex {
  private String dbPath = "";
  private String indexPath = "";

  public ManagerIndex(String dbPath) {
    this.dbPath = dbPath;
    this.indexPath = "../db/bankIndex.db";
  }

  public void test() {
    RandomAccessFile arq;
    try {
      arq = new RandomAccessFile(indexPath, "rw");
      arq.setLength(0);
    } catch (Exception e) {
    }
  }

  public void readDb() {
    RandomAccessFile dbArq, indexArq;

    if (Manager.dbExists(dbPath)) {
      try {
        dbArq = new RandomAccessFile(dbPath, "rw");
        indexArq = new RandomAccessFile(indexPath, "rw");
        indexArq.setLength(0);
        dbArq.seek(0);
        indexArq.seek(0);
        dbArq.readInt();

        for (long pos = dbArq.getFilePointer(); pos < dbArq.length(); pos = dbArq.getFilePointer()) {
          boolean lapide = dbArq.readBoolean();
          int tam = dbArq.readInt();

          if (lapide) {
            int id = dbArq.readInt();
            indexArq.writeInt(id);
            indexArq.writeLong(pos);
          }

          if (pos + tam + 5 <= dbArq.length()) {
            dbArq.seek(pos + tam + 5);
          }
        }
        dbArq.close();
        indexArq.close();
        sortArq();
        ManagerInvertedList.generateLists();
      } catch (Exception e) {
      }
    }
  }

  public void sort(int idArr[], long posArr[], int size) {
    for (int i = 0; i < size; i++) {
      int menor = i;
      for (int j = i + 1; j < size; j++) {
        if (idArr[j] < idArr[menor]) {
          menor = j;
        }
      }

      if (menor != i) {
        int tmpId = idArr[i];
        idArr[i] = idArr[menor];
        idArr[menor] = tmpId;

        long tmpPos = posArr[i];
        posArr[i] = posArr[menor];
        posArr[menor] = tmpPos;
      }
    }
  }

  public void sortArq() {
    RandomAccessFile arq;
    try {
      arq = new RandomAccessFile(indexPath, "rw");
      arq.seek(0);

      int tam = ((int) (arq.length())) / 12;
      int idArr[] = new int[tam];
      long posArr[] = new long[tam];

      int i = 0;
      for (long pos = arq.getFilePointer(); pos < arq.length(); pos = arq.getFilePointer()) {
        idArr[i] = arq.readInt();
        posArr[i++] = arq.readLong();
      }

      sort(idArr, posArr, tam);

      arq.seek(0);
      for (int j = 0; j < i; j++) {
        arq.writeInt(idArr[j]);
        arq.writeLong(posArr[j]);
      }

      arq.close();
    } catch (Exception e) {
    }
  }

  public static long findIdPointer(int id) {
    RandomAccessFile arq;
    String dbPath = "../db/bankIndex.db";
    long returns = -1;
    int idAux;

    try {
      arq = new RandomAccessFile(dbPath, "rw");
      arq.seek(0);

      if (arq.readInt() <= id) {
        arq.seek(0);

        int low = 0;
        int high = ((int) (arq.length() / 12)) - 1;

        while (low < high) {
          int mid = low + (high - low) / 2;

          arq.seek(mid * 12);
          idAux = arq.readInt();
          if (idAux < id) {
            low = mid + 1;
          } else if (idAux > id) {
            high = mid - 1;
          } else {
            returns = arq.readLong();
            low = high;
          }
        }
      }

      arq.close();
    } catch (Exception e) {
    }

    return returns;
  }
}