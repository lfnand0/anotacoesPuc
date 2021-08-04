#include <stdio.h>
#include <string.h>

int ID_PACIENTE = 1, ID_MEDICO = 1, ID_CONSULTA = 1;

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

// int numID(int *id) {
//   *id += 1;
//   return *id;
// }

void cadastrarPaciente(struct PACIENTE *paciente) {
  int id = ID_PACIENTE - 1;
  paciente[id].COD_PACIENTE = ID_PACIENTE++;
  
  printf("\nPACIENTE %d\n", paciente[id].COD_PACIENTE);
  printf("Digite o nome do paciente: ");
  fgets(paciente[id].NOME, (sizeof(paciente[id].NOME)/sizeof(paciente[id].NOME[0])), stdin);
  paciente[id].NOME[strlen(paciente[id].NOME) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].NOME[strlen(paciente[id].NOME)] = 0;

  printf("Digite o endereço do paciente: ");
  fgets(paciente[id].ENDERECO, (sizeof(paciente[id].ENDERECO)/sizeof(paciente[id].ENDERECO[0])), stdin);
  paciente[id].ENDERECO[strlen(paciente[id].ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].ENDERECO[strlen(paciente[id].ENDERECO)] = 0;

  printf("Digite o telefone do paciente: ");
  fgets(paciente[id].TELEFONE, (sizeof(paciente[id].TELEFONE)/sizeof(paciente[id].TELEFONE[0])), stdin);
  paciente[id].TELEFONE[strlen(paciente[id].TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].TELEFONE[strlen(paciente[id].TELEFONE)] = 0;
  
}

void cadastrarMedico(struct MEDICO *medico) {
  int id = ID_MEDICO - 1;
  medico[id].COD_MEDICO = ID_MEDICO++;

  printf("\nMÉDICO %d\n", medico[id].COD_MEDICO);
  printf("Digite o nome do medico: ");
  fgets(medico[id].NOME, (sizeof(medico[id].NOME)/sizeof(medico[id].NOME[0])), stdin);
  medico[id].NOME[strlen(medico[id].NOME) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].NOME[strlen(medico[id].NOME)] = 0;

  printf("Digite o endereço do medico: ");
  fgets(medico[id].ENDERECO, (sizeof(medico[id].ENDERECO)/sizeof(medico[id].ENDERECO[0])), stdin);
  medico[id].ENDERECO[strlen(medico[id].ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].ENDERECO[strlen(medico[id].ENDERECO)] = 0;

  printf("Digite o telefone do medico: ");
  fgets(medico[id].TELEFONE, (sizeof(medico[id].TELEFONE)/sizeof(medico[id].TELEFONE[0])), stdin);
  medico[id].TELEFONE[strlen(medico[id].TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].TELEFONE[strlen(medico[id].TELEFONE)] = 0;
}

int main() {
  int numPacientes, numMedicos;
  
  numMedicos = 3;
  numPacientes = 5;

  struct MEDICO medico[numMedicos];
  struct PACIENTE paciente[numPacientes];  

  for (int i = 0; i < numPacientes; i++) {
    cadastrarPaciente(paciente);
  }
  for (int i = 0; i < numMedicos; i++) {
    cadastrarMedico(medico);
  }

  for (int i = 0; i < numPacientes; i++) {
    printf("\nPACIENTE %d\nID = %d\n", i+1, paciente[i].COD_PACIENTE);
    printf("NOME: %s\n", paciente[i].NOME);
    printf("ENDERECO: %s\n", paciente[i].ENDERECO);
    printf("TELEFONE: %s\n", paciente[i].TELEFONE);
  }
}