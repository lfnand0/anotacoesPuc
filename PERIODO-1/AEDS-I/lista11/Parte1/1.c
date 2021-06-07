#include <stdio.h>

struct PACIENTE {
  int COD_PACIENTE;
  char NOME[128];
  char ENDERECO[256];
  char TELEFONE[11];
};

struct MEDICO {
  int COD_MEDICO;
  char NOME[128];
  char ENDERECO[256];
  char TELEFONE[11];
};

struct CONSULTA {
  int NUM_CONSULTA;
  char DIA_SEMANA[128];
  char hora[5];
  int COD_MEDICO;
  int COD_PACIENTE;
};

int main() {

}