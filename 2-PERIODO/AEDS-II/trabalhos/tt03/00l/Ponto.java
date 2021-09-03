class Ponto {
  private double x;
  private double y;
  private int id;
  private static int nextID = 0;
  
  public Ponto() {
    this.x = 0;
    this.y = 0;
    this.id = this.nextID;
    Ponto.nextID += 1;
  }

  public Ponto(double x, double y) {
    this.x = x;
    this.y = y;
    this.id = this.nextID;
    Ponto.nextID += 1;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int x) {
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public int getID() {
    return this.id;
  }

  public static int getNextID() {
    return Ponto.nextID;
  }

  public double dist(Ponto px) {
    return Math.sqrt(Math.pow((px.getX() - this.x),2) + Math.pow((px.getY() - this.y),2));
  }

  public double dist(double x, double y) {
    return Math.sqrt(Math.pow((x - this.x),2) + Math.pow((y - this.y),2));
  }
  
  public static double dist(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
  }

  public static boolean isTriangulo(Ponto pa, Ponto pb, Ponto pc) {
    double a, b, c;
    a = Ponto.dist(pb.getX(), pc.getX(), pb.getY(), pc.getY());
    b = Ponto.dist(pa.getX(), pc.getX(), pa.getY(), pc.getY());
    c = Ponto.dist(pb.getX(), pa.getX(), pb.getY(), pa.getY());
    
    boolean resp = true;
    if (a + b < c || a + c < b || b + c < a) {
      resp = false;
    }
    return resp;    
  }

  public double getAreaRetangulo(Ponto px) {
    double x = px.getX(), y = px.getY();
    double base = x - this.x;
    double altura = y - this.y;
    double area = base * altura;
    if (area < 0) {
      area *= -1;
    }

    return area;
  }
}

class LixaoPonto {
  public static void main(String[] args) {
    Ponto p1 = new Ponto(4,3);
    Ponto p2 = new Ponto(8,5);
    Ponto p3 = new Ponto(9.2,10);

    System.out.println("Distancia p1 entre p2:" + p1.dist(p2));
    System.out.println("Distancia p1 entre e (5,2):" + p1.dist(5,2));
    System.out.println("Distancia (4,3) entre e (5,2):" + Ponto.dist(4,3,5,2));
    System.out.println("P1, P2, P3 sao triangulo:" + Ponto.isTriangulo(p1,p2,p3));
    System.out.println("Area retangulo:" + p1.getAreaRetangulo(p2));
    System.out.println("ID de P1:" + p1.getID());
    System.out.println("ID de P2:" + p2.getID());
    System.out.println("ID de P1:" + p1.getID());
    System.out.println("Next ID:" + Ponto.getNextID());
  }
}
