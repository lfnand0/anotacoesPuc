#include <stdio.h>
#include <string.h>

struct PACIENTE {
  int COD_PACIENTE;
  char NOME[128];
  char ENDERECO[512];
  char TELEFONE[11];
};

struct MEDICO {
  int COD_MEDICO;
  char NOME[128];
  char ENDERECO[512];
  char TELEFONE[11];
};

struct CONSULTA {
  int NUM_CONSULTA;
  char DIA_SEMANA[128];
  char hora[5];
  int COD_MEDICO;
  int COD_PACIENTE;
};

int numID(int *id) {
  *id += 1;
  return *id;
}

void cadastrarPaciente(struct PACIENTE *paciente, int *id) {
  paciente->COD_PACIENTE = numID(id);
  /* int COD_PACIENTE;
  char NOME[128];
  char ENDERECO[256];
  char TELEFONE[11]; */
  printf("Digite o nome do paciente: ");
  fgets(paciente->NOME, (sizeof(paciente->NOME)/sizeof(paciente->NOME[0])), stdin);
  paciente->NOME[strlen(paciente->NOME) - 1] = '\0'; // retirando o \n do fim da string
  paciente->NOME[strlen(paciente->NOME)] = 0;

  printf("Digite o endereço do paciente: ");
  fgets(paciente->ENDERECO, (sizeof(paciente->ENDERECO)/sizeof(paciente->ENDERECO[0])), stdin);
  paciente->ENDERECO[strlen(paciente->ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  paciente->ENDERECO[strlen(paciente->ENDERECO)] = 0;

  printf("Digite o telefone do paciente: ");
  fgets(paciente->TELEFONE, (sizeof(paciente->TELEFONE)/sizeof(paciente->TELEFONE[0])), stdin);
  paciente->TELEFONE[strlen(paciente->TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  paciente->TELEFONE[strlen(paciente->TELEFONE)] = 0;
  
}

void cadastrarMedico(struct MEDICO *medico, int *id) {
  medico->COD_MEDICO = numID(id);

  printf("Digite o nome do medico: ");
  fgets(medico->NOME, (sizeof(medico->NOME)/sizeof(medico->NOME[0])), stdin);
  medico->NOME[strlen(medico->NOME) - 1] = '\0'; // retirando o \n do fim da string
  medico->NOME[strlen(medico->NOME)] = 0;

  printf("Digite o endereço do medico: ");
  fgets(medico->ENDERECO, (sizeof(medico->ENDERECO)/sizeof(medico->ENDERECO[0])), stdin);
  medico->ENDERECO[strlen(medico->ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  medico->ENDERECO[strlen(medico->ENDERECO)] = 0;

  printf("Digite o telefone do medico: ");
  fgets(medico->TELEFONE, (sizeof(medico->TELEFONE)/sizeof(medico->TELEFONE[0])), stdin);
  medico->TELEFONE[strlen(medico->TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  medico->TELEFONE[strlen(medico->TELEFONE)] = 0;
  
}


int main() {
  int numPacientes, numMedicos;
  printf("Digite o número de pacientes: ");
  scanf("%d", &numPacientes);
  printf("Digite o número de médicos: ");
  scanf("%d%*c", &numMedicos);

  struct MEDICO medicos[numMedicos];
  struct PACIENTE pacientes[numPacientes];

  int x = 1;
  int *id;
  id = &x;
  

  for (int i = 0; i < numPacientes; i++) {
    cadastrarPaciente(&pacientes[i], id);
  }
  for (int i = 0; i < numPacientes; i++) {
    cadastrarPaciente(&pacientes[i], id);
  }
  cadastrarMedico(&medicos[0], id); //
}