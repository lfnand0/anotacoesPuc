class retangulo {
  private double base;
  private double altura;

  public retangulo() {
    this.base = 0;
    this.altura = 0;
  }

  public retangulo (int base, int altura) {
    this.base = base;
    this.altura = altura;
  }

  public double getArea() {
    return this.base * this.altura;
  }

  public double getPerimetro() {
    return (this.base * 2) + (this.altura * 2);
  }

  public double getDiagonal() {
    return Math.sqrt((this.base * this.base) + (this.altura * this.base));
  }
}

class lixao{
  public static void main(String[] args) {
    retangulo ret1 = new retangulo();
    retangulo ret2 = new retangulo(5, 2);

    MyIO.println(ret1.getArea());
    MyIO.println(ret1.getPerimetro());
    MyIO.println(ret1.getDiagonal());
    
    MyIO.println(ret2.getArea());
    MyIO.println(ret2.getPerimetro());
    MyIO.println(ret2.getDiagonal());
  }
}
