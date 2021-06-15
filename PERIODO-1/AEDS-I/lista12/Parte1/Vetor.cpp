#include "Vetor.h"
using namespace std;

Vetor::Vetor()
{
  v = new int[TAMANHO];
  for (int i = 0; i < TAMANHO; i++)
  {
    v[i] = 0;
  }
  numElementos = 0;
}

int Vetor::obtemTamanho()
{
  return numElementos;
}

void Vetor::insereNoFinal(int novoElemento)
{
  v[numElementos] = novoElemento;
  numElementos++;
}

int Vetor::posicaoDe(int elemento)
{
  for (int i = 0; i < numElementos; i++)
  {
    if (v[i] == elemento)
    {
      return i;
    }
  }
  return -1;
}

void Vetor::alteraEm(int pos, int novoValor)
{
  if (pos > numElementos)
  {
    // return -1; void não pode retornar um valor
    v[pos] = -1;
  }
  else
  {
    v[pos] = novoValor;
  }
}

int Vetor::elementoEm(int pos)
{
  if (pos > numElementos)
  {
    return -1;
  }
  else
  {
    return v[pos];
  }
}

void Vetor::reverte()
{
  for (int i = 0; i < numElementos / 2; i++)
  {
    int temp = v[i];
    v[i] = v[i + 1];
    v[i + 1] = temp;
  }
};
void Vetor::imprime()
{
  for (int i = 0; i < numElementos; i++)
  {
    printf("%d ", v[i]);
  }
  printf("\n");
};

int main(int argc, char *argv[])
{
  Vetor *v = new Vetor();
  v->insereNoFinal(10);
  v->insereNoFinal(8);
  v->insereNoFinal(16);
  v->insereNoFinal(7);
  v->insereNoFinal(5);
  v->insereNoFinal(13);
  v->imprime();
  v->alteraEm(3, 19);
  v->alteraEm(15, 9);
  int i;
  for (i = 0; i < v->obtemTamanho(); i++)
    cout << "Elemento na posicao " << i << ": " << v->elementoEm(i) << "\n";
  v->reverte();
  v->imprime();
}