#include "Vetor.h"
using namespace std;

Vetor::Vetor()
{
  TAMANHO = 10;
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
  if (numElementos >= TAMANHO)
  {
    TAMANHO = numElementos * 2;
    v = (int *)realloc(v, TAMANHO * sizeof(int));
  }
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

void Vetor::retirarElemento(int elemento) {
  for (int i = 0; i < numElementos; i++) {
    if (v[i] == elemento) {
      numElementos--;
      for (int j = i; j < numElementos; j++) {
        v[i] = v[i + 1];
      }
      v[numElementos + 1] = 0;
    }
  }

  if (numElementos == TAMANHO/2) {
    v = (int *)realloc(v, numElementos * sizeof(int));
  }
};

void Vetor::reverte()
{
  for (int i = 0; i < numElementos / 2; i++)
  {
    int temp = v[i];
    v[i] = v[numElementos - 1 - i];
    v[numElementos - 1 - i] = temp;
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
  v->insereNoFinal(10);
  v->insereNoFinal(8);
  v->insereNoFinal(16);
  v->insereNoFinal(7);
  v->insereNoFinal(5);
  v->insereNoFinal(13);
  v->insereNoFinal(10);
  v->insereNoFinal(8);
  v->insereNoFinal(16);
  v->insereNoFinal(7);
  v->insereNoFinal(5);
  v->retirarElemento(5);
  v->retirarElemento(13);
  v->retirarElemento(10);
  v->retirarElemento(8);
  v->retirarElemento(7);
  v->insereNoFinal(13);
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