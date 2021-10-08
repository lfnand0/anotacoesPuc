package model;

import java.io.Serializable;

public class Produto implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String DESCRICAO_PADRAO = "Novo Produto";
  public static final int MAX_ESTOQUE = 1000;
  private int id;
  private String descricao;
  private float preco;
  private int quantidade;
  private String dataFabricacao;
  private String dataValidade;

  public Produto() {
    id = -1;
    descricao = DESCRICAO_PADRAO;
    preco = 0.01F;
    quantidade = 0;
    dataFabricacao = "00/00/0000";
    dataValidade = "00/00/0000";
  }

  public Produto(int id, String descricao, float preco, int quantidade, String fabricacao, String v) {
    setId(id);
    setDescricao(descricao);
    setPreco(preco);
    setQuant(quantidade);
    setDataFabricacao(fabricacao);
    setDataValidade(v);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    if (descricao.length() >= 3)
      this.descricao = descricao;
  }

  public float getPreco() {
    return preco;
  }

  public void setPreco(float preco) {
    if (preco > 0)
      this.preco = preco;
  }

  public int getQuant() {
    return quantidade;
  }

  public void setQuant(int quantidade) {
    if (quantidade >= 0 && quantidade <= MAX_ESTOQUE)
      this.quantidade = quantidade;
  }

  public String getDataValidade() {
    return dataValidade;
  }

  public String getDataFabricacao() {
    return dataFabricacao;
  }

  public void setDataFabricacao(String dataFabricacao) {
    this.dataFabricacao = dataFabricacao;
  }

  public void setDataValidade(String dataValidade) {
    this.dataValidade = dataValidade;
  }

  @Override
  public String toString() {
    return "Produto: " + descricao + "   Preço: R$" + preco + "   Quant.: " + quantidade + "   Fabricação: "
        + dataFabricacao + "   Data de Validade: " + dataValidade;
  }

  @Override
  public boolean equals(Object obj) {
    return (this.getId() == ((Produto) obj).getId());
  }
}
