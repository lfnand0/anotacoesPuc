package manager;

import java.io.*;

class InvertedList {
  String str[];
  int ids[][];
  int numIds[];
  int numStrs = 0;

  public InvertedList(int maxId) {
    this.str = new String[maxId + 1];
    this.ids = new int[maxId + 1][maxId + 1];
    this.numIds = new int[maxId + 1];
  }

  public void insert(String s, int id) {
    boolean found = false;
    for (int i = 0; i < numStrs; i++) {
      if (s.equals(str[i])) {
        found = true;
        ids[i][numIds[i]++] = id;
      }
    }

    if (!found) {
      str[numStrs] = s;
      ids[numStrs][numIds[numStrs++]++] = id;
    }
  }

  public void sort() {
    // Ordenar strings
    for (int i = 0; i < numStrs; i++) {
      int menor = i;
      for (int j = i + 1; j < numStrs; j++) {
        if (str[j].compareTo(str[menor]) < 0) {
          menor = j;
        }
      }

      if (menor != i) {
        String strTemp = str[i];
        str[i] = str[menor];
        str[menor] = strTemp;

        int numIdsTemp = numIds[i];
        numIds[i] = numIds[menor];
        numIds[menor] = numIdsTemp;

        int idsTemp[] = ids[i];
        ids[i] = ids[menor];
        ids[menor] = idsTemp;
      }
    }

    // Ordenar ids
    for (int i = 0; i < numStrs; i++) {
      for (int j = 0; j < numIds[i]; j++) {
        int menor = j;
        for (int k = j + 1; k < numIds[i]; k++) {
          if (ids[i][menor] > ids[i][k]) {
            menor = k;
          }
        }

        if (menor != j) {
          int temp = ids[i][j];
          ids[i][j] = ids[i][menor];
          ids[i][menor] = temp;
        }
      }
    }
  }

  public void writeToFile(String path) {
    sort();
    RandomAccessFile arq;
    try {
      arq = new RandomAccessFile(path, "rw");
      arq.setLength(0);
      arq.seek(0);

      for (int i = 0; i < numStrs; i++) {
        arq.writeUTF(str[i]);
        arq.writeInt(numIds[i]);

        for (int j = 0; j < numIds[i]; j++) {
          arq.writeInt(ids[i][j]);
        }
      }
    } catch (Exception e) {
    }
  }
}

public class ManagerInvertedList {
  public static void generateLists() {
    RandomAccessFile dbArq;
    String dbPath = "../db/bank.db";
    String namePath = "../db/nameList.db";
    String cityPath = "../db/cityList.db";

    if (Manager.dbExists(dbPath)) {
      try {
        dbArq = new RandomAccessFile(dbPath, "rw");
        dbArq.seek(0);
        int maxId = dbArq.readInt();

        InvertedList nameList = new InvertedList(maxId);
        InvertedList cityList = new InvertedList(maxId);

        for (long pos = dbArq.getFilePointer(); pos < dbArq.length(); pos = dbArq.getFilePointer()) {

          boolean lapide = dbArq.readBoolean();
          int tam = dbArq.readInt();

          if (lapide) {
            int id = dbArq.readInt();
            String name = dbArq.readUTF();

            dbArq.readUTF(); // cpf
            String city = dbArq.readUTF();

            nameList.insert(name, id);
            cityList.insert(city, id);
          }

          if (pos + tam + 5 <= dbArq.length()) {
            dbArq.seek(pos + tam + 5);
          }

        }

        nameList.writeToFile(namePath);
        cityList.writeToFile(cityPath);

        dbArq.close();
      } catch (Exception e) {
      }
    }
  }
}
