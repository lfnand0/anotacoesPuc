package manager;

import java.io.*;
import java.text.*;
import dao.*;

public class Manager {
  protected String dbFilePath;
  protected int header;

  public Manager(String dbFilePath) throws FileNotFoundException {
    this.dbFilePath = dbFilePath;
    File db = new File(dbFilePath);
    if (db.exists() && !db.isDirectory()) {
      getHeaderData();
    }
    this.header = 0;
  }

  private void getHeaderData() {
    try {
      RandomAccessFile arq = new RandomAccessFile(dbFilePath, "r");
      arq.seek(0);
      this.header = arq.readInt();
      arq.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void createNewAccount(Dao dao) {
    getHeaderData();
  }
  public void read(Dao dao) {
    
  }
  public void update(Dao dao) {
    
  }
  public void delete(Dao dao) {
    
  }
}
