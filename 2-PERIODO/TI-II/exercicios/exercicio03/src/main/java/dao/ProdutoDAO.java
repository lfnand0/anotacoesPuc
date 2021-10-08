package dao;

import model.Produto;

import java.sql.*;

public class ProdutoDAO {
  private Connection conexao;

  public int getMaxId() {
    int[] ids = null;
    int maxId = 0;

    try {
      Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = st.executeQuery("SELECT * FROM produtos");
      if (rs.next()) {
        rs.last();
        ids = new int[rs.getRow()];
        rs.beforeFirst();

        for (int i = 0; rs.next(); i++) {
          ids[i] = rs.getInt("id");

          if (ids[i] > maxId) {
            maxId = ids[i];
          }
        }
      }
      st.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    return maxId;
  }

  public ProdutoDAO() {
    conexao = null;
  }

  public boolean conectar() {
    String driverName = "org.postgresql.Driver";
    String serverName = "localhost";
    String mydatabase = "integracao-eclipse";
    int porta = 5432;
    String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
    String username = "ti2cc";
    String password = "ti@cc";
    boolean status = false;

    try {
      Class.forName(driverName);
      conexao = DriverManager.getConnection(url, username, password);
      status = (conexao == null);
      System.out.println("Conexão efetuada com o postgres!");
    } catch (ClassNotFoundException e) {
      System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
    } catch (SQLException e) {
      System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
    }

    return status;
  }

  public boolean close() {
    boolean status = false;

    try {
      conexao.close();
      status = true;
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
    return status;
  }

  public void add(Produto p) {
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("INSERT INTO produtos (id, descricao, preco, quantidade, data_fab, data_val) " + "VALUES ("
          + p.getId() + ", '" + p.getDescricao() + "', '" + p.getPreco() + "', '" + p.getQuant() + "', '"
          + p.getDataFabricacao() + "', '" + p.getDataValidade() + "');");
      st.close();
    } catch (SQLException u) {
      throw new RuntimeException(u);
    }
  }

  public Produto get(int id) {
    Produto produto = new Produto();
    try {
      Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = st
          .executeQuery("SELECT id, descricao, preco, quantidade, data_fab, data_val FROM produtos WHERE id = " + id);
      rs.next();
      produto = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("preco"), rs.getInt("quantidade"),
          rs.getString("data_fab"), rs.getString("data_val"));
      st.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return produto;
  }

  public void update(Produto p) {
    try {
      Statement st = conexao.createStatement();
      String sql = "UPDATE produtos SET descricao = '" + p.getDescricao() + "', preco = '" + p.getPreco()
          + "', quantidade = '" + p.getQuant() + "', data_fab = '" + p.getDataFabricacao() + "', data_val = '"
          + p.getDataValidade() + "'" + " WHERE id = " + p.getId();
      st.executeUpdate(sql);
      st.close();
    } catch (SQLException u) {
      throw new RuntimeException(u);
    }
  }

  public void remove(Produto p) {
    try {
      Statement st = conexao.createStatement();
      st.executeUpdate("DELETE FROM produtos WHERE id = " + p.getId());
      st.close();
    } catch (SQLException u) {
      throw new RuntimeException(u);
    }
  }

  public Produto[] getAll() {
    Produto produto[] = new Produto[1000];
    try {
      Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet rs = st.executeQuery("SELECT * FROM produtos");
      if (rs.next()) {
        rs.last();
        produto = new Produto[rs.getRow()];
        rs.beforeFirst();

        for (int i = 0; rs.next(); i++) {
          produto[i] = new Produto(rs.getInt("id"), rs.getString("descricao"), rs.getFloat("preco"),
              rs.getInt("quantidade"), rs.getString("data_fab"), rs.getString("data_val"));
        }
      }
      st.close();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return produto;
  }
}