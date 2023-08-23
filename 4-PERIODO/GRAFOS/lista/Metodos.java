public int grauSaida() {
  Vertice v = this;
  int counter = 0;
  while ((v = v.prox) != null) counter++;

  return counter;
}

public int grauEntrada() {
  Vertice v = this;
  int counter = 0;
  while ((v = v.ant) != null) counter++;

  return counter;
}
