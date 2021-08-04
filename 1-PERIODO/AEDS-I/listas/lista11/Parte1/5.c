#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ID_PACIENTE = 1, ID_MEDICO = 1, ID_CONSULTA = 1;

struct PACIENTE
{
  int COD_PACIENTE;
  char NOME[128];
  char ENDERECO[512];
  char TELEFONE[11];
};

struct MEDICO
{
  int COD_MEDICO;
  char NOME[128];
  char ENDERECO[512];
  char TELEFONE[11];
};

struct CONSULTA
{
  int NUM_CONSULTA;
  char DIA_SEMANA[4];
  char HORA[6];
  int COD_MEDICO;
  int COD_PACIENTE;
};

// int numID(int *id) {
//   *id += 1;
//   return *id;
// }

void cadastrarPaciente(struct PACIENTE *paciente)
{
  int id = ID_PACIENTE - 1;
  paciente[id].COD_PACIENTE = ID_PACIENTE++;

  printf("\nPACIENTE %d\n", paciente[id].COD_PACIENTE);
  printf("Digite o nome do paciente: ");
  fgets(paciente[id].NOME, (sizeof(paciente[id].NOME) / sizeof(paciente[id].NOME[0])), stdin);
  paciente[id].NOME[strlen(paciente[id].NOME) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].NOME[strlen(paciente[id].NOME)] = 0;

  printf("Digite o endereço do paciente: ");
  fgets(paciente[id].ENDERECO, (sizeof(paciente[id].ENDERECO) / sizeof(paciente[id].ENDERECO[0])), stdin);
  paciente[id].ENDERECO[strlen(paciente[id].ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].ENDERECO[strlen(paciente[id].ENDERECO)] = 0;

  printf("Digite o telefone do paciente: ");
  fgets(paciente[id].TELEFONE, (sizeof(paciente[id].TELEFONE) / sizeof(paciente[id].TELEFONE[0])), stdin);
  paciente[id].TELEFONE[strlen(paciente[id].TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  paciente[id].TELEFONE[strlen(paciente[id].TELEFONE)] = 0;
}

void cadastrarMedico(struct MEDICO *medico)
{
  int id = ID_MEDICO - 1;
  printf("id medico = %d\n", id);
  medico[id].COD_MEDICO = ID_MEDICO++;

  printf("\nMÉDICO %d\n", medico[id].COD_MEDICO);
  printf("Digite o nome do medico: ");
  fgets(medico[id].NOME, (sizeof(medico[id].NOME) / sizeof(medico[id].NOME[0])), stdin);
  medico[id].NOME[strlen(medico[id].NOME) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].NOME[strlen(medico[id].NOME)] = 0;

  printf("Digite o endereço do medico: ");
  fgets(medico[id].ENDERECO, (sizeof(medico[id].ENDERECO) / sizeof(medico[id].ENDERECO[0])), stdin);
  medico[id].ENDERECO[strlen(medico[id].ENDERECO) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].ENDERECO[strlen(medico[id].ENDERECO)] = 0;

  printf("Digite o telefone do medico: ");
  fgets(medico[id].TELEFONE, (sizeof(medico[id].TELEFONE) / sizeof(medico[id].TELEFONE[0])), stdin);
  medico[id].TELEFONE[strlen(medico[id].TELEFONE) - 1] = '\0'; // retirando o \n do fim da string
  medico[id].TELEFONE[strlen(medico[id].TELEFONE)] = 0;
}

void cadastrarConsulta(struct CONSULTA *consulta)
{
  printf("\n-----PROGRAMA DE CADASTRO DE CONSULTAS-----\n");
  int id = ID_CONSULTA, indice = ID_CONSULTA - 1;

  int diaSemana;
  printf("Digite \n1. Segunda\n2. Terça\n3. Quarta\n4. Quinta\n5. Sexta \npara o dia da consulta: ");
  scanf("%d", &diaSemana);
  while (diaSemana < 1 || diaSemana > 5)
  {
    printf("Erro: Digite um valor entre 1 e 5 para o dia da semana: ");
    scanf("%d", &diaSemana);
  }

  char diaSemanaString[4];
  char dias_array[5][4] = {
      "SEG",
      "TER",
      "QUA",
      "QUI",
      "SEX"};
  strcpy(diaSemanaString, dias_array[diaSemana - 1]);

  int idPaciente, idMedico;
  printf("\nDigite o ID do paciente: ");
  scanf("%d", &idPaciente);
  while (idPaciente <= 0 || idPaciente >= ID_PACIENTE)
  {
    printf("Erro: digite um ID cadastrado (IDs cadastrados:");
    for (int i = 1; i < ID_PACIENTE; i++)
    {
      printf(" %d", i);
    }
    printf(")\n");
    scanf("%d", &idPaciente);
  }

  printf("\nDigite o ID do médico: ");
  scanf("%d", &idMedico);
  while (idMedico <= 0 || idMedico >= ID_MEDICO)
  {
    printf("Erro: digite um ID cadastrado (IDs cadastrados:");
    for (int i = 1; i < ID_MEDICO; i++)
    {
      printf(" %d", i);
    }
    printf(")\n");
    scanf("%d", &idMedico);
  }

  int quantidadeConsultasMedico = 1;
  for (int i = 0; i < indice; i++)
  {
    if (idMedico == consulta[i].COD_MEDICO &&
        strcmp(consulta[i].DIA_SEMANA, diaSemanaString) == 0)
    {
      quantidadeConsultasMedico++;
    }
  }
  if (quantidadeConsultasMedico > 2)
  {
    printf("Desculpe, esse médico já tem duas consultas nesse dia e não poderá te atender.\n");
    return;
  }
  else
  {
    char horario[6], hora[3], min[3];
    int horaInt, minInt;
    printf("\nDigite o horário da consulta (no formato HH:MM) : ");
    scanf("%s", horario);
    horario[5] = hora[2] = min[2] = '\0';

    hora[0] = horario[0];
    hora[1] = horario[1];
    min[0] = horario[3];
    min[1] = horario[4];
    horaInt = atoi(hora);
    minInt = atoi(min);
    while ((horaInt < 0 || horaInt >= 24) || (minInt < 0 || minInt >= 60) || (horario[2] != ':'))
    {
      printf("Erro: horário inválido. Por favor, redigite-o no formato HH:MM : ");
      scanf("%s", horario);
      horario[5] = hora[2] = min[2] = '\0';

      hora[0] = horario[0];
      hora[1] = horario[1];
      min[0] = horario[3];
      min[1] = horario[4];
      horaInt = atoi(hora);
      minInt = atoi(min);
    }

    consulta[indice].NUM_CONSULTA = id;
    consulta[indice].COD_MEDICO = idMedico;
    consulta[indice].COD_PACIENTE = idPaciente;
    strcpy(consulta[indice].DIA_SEMANA, diaSemanaString);
    strcpy(consulta[indice].HORA, horario);
    ID_CONSULTA++;
  }
}

void pesquisarConsulta(char nome[], char dia[], struct MEDICO *medico, struct CONSULTA *consulta)
{
  char dias_array[5][4] = {
      "SEG",
      "TER",
      "QUA",
      "QUI",
      "SEX"};

  int checarDia = 0, diaSemana;
  for (int i = 0; i < 5; i++)
  {
    if (strcmp(dia, dias_array[i]) == 0)
    {
      checarDia++;
      diaSemana = i;
    }
  }

  if (checarDia == 0)
  {
    printf("\nErro: o dia da semana escolhido é inválido.\n");
    printf("Digite \n1. Segunda\n2. Terça\n3. Quarta\n4. Quinta\n5. Sexta \npara o dia da consulta: ");
    scanf("%d", &diaSemana);
    while (diaSemana < 1 || diaSemana > 5)
    {
      printf("Erro: Digite um valor entre 1 e 5 para o dia da semana: ");
      scanf("%d", &diaSemana);
    }
    diaSemana--;
    strcpy(dia, dias_array[diaSemana]);
  }

  int idMedico = 0;
  for (int i = 1; i < ID_MEDICO; i++)
  {
    if (strcmp(nome, medico[i].NOME) == 0)
    {
      idMedico = medico[i].COD_MEDICO;
    }
  }
  if (idMedico == 0)
  {
    printf("\nErro: não existe nenhum médico com o nome '%s'.\n", nome);
  }
  else
  {
    int contConsultas = 0;
    for (int i = 0; i < ID_CONSULTA - 1; i++)
    {
      if (idMedico == consulta[i].COD_MEDICO && strcmp(dia, consulta[i].DIA_SEMANA) == 0)
      {
        contConsultas++;
      }
    }
    char dias_array_completo[5][30] = {
      "Segunda",
      "Terça",
      "Quarta",
      "Quinta",
      "Sexta"
    };
    printf("\nO médico %s possui %d consulta(s) na %s.\n", nome, contConsultas, dias_array_completo[diaSemana]);
  }
}

void consultasNoDia(char dia[], struct CONSULTA *consulta, struct MEDICO *medico) {
  char dias_array[5][4] = {
      "SEG",
      "TER",
      "QUA",
      "QUI",
      "SEX"};

  int checarDia = 0, diaSemana;
  char diaFix[3];
  for (int i = 0; i < 5; i++)
  {
    if (strcmp(dia, dias_array[i]) == 0)
    {
      checarDia++;
      diaSemana = i;
    }
  }

  if (checarDia == 0)
  {
    printf("\nErro: o dia da semana escolhido é inválido.\n");
    printf("Digite \n1. Segunda\n2. Terça\n3. Quarta\n4. Quinta\n5. Sexta \npara o dia da consulta: ");
    scanf("%d", &diaSemana);
    while (diaSemana < 1 || diaSemana > 5)
    {
      printf("Erro: Digite um valor entre 1 e 5 para o dia da semana: ");
      scanf("%d", &diaSemana);
    }
    diaSemana--;
    strcpy(diaFix, dias_array[diaSemana]);
  } else {
    strcpy(diaFix, dia);
  }

  char dias_array_completo[5][30] = {
      "segunda",
      "terça",
      "quarta",
      "quinta",
      "sexta"
    };
  printf("\n----------CONSULTAS (%s)----------", diaFix);
  int indice = ID_CONSULTA - 1, existeConsulta = 0;
  for (int i = 0; i < indice; i++) {
    if (strcmp(diaFix, consulta[i].DIA_SEMANA) == 0) {
      existeConsulta++;
      printf("\nConsulta %d\n", consulta[i].NUM_CONSULTA);
      printf("Dia da semana: %s\n", consulta[i].DIA_SEMANA);
      printf("Horário: %s\n", consulta[i].HORA);
      printf("Código do médico: %d\n", consulta[i].COD_MEDICO);
      printf("Código do paciente: %d\n", consulta[i].COD_PACIENTE);
      int idMedico = consulta[i].COD_MEDICO - 1;
      printf("Nome do médico: %s\n", medico[idMedico].NOME);
    }
  }

  

  if (existeConsulta == 0) {
    printf("\nNão há nenhuma consulta na %s-feira.\n", dias_array_completo[diaSemana]);
  }
  printf("-----------------------------------\n");
}

int main()
{
  int numPacientes, numMedicos;

  numMedicos = 1;
  numPacientes = 2;

  struct MEDICO medico[numMedicos];
  struct PACIENTE paciente[numPacientes];

  int numConsultas = numMedicos * 10; // cada médico pode realizar duas consultas por dia durante a semana, totalizando no máximo 10 consultas semanais
  struct CONSULTA consulta[numConsultas];

  for (int i = 0; i < numPacientes; i++)
  {
    cadastrarPaciente(paciente);
  }
  for (int i = 0; i < numMedicos; i++)
  {
    cadastrarMedico(medico);
  }

  cadastrarConsulta(consulta);
  cadastrarConsulta(consulta);

  /* printf("\n----------CONSULTAS----------");
  for (int i = 0; i < ID_CONSULTA - 1; i++)
  {
    printf("\nConsulta %d\n", consulta[i].NUM_CONSULTA);
    printf("Dia da semana: %s\n", consulta[i].DIA_SEMANA);
    printf("Horário: %s\n", consulta[i].HORA);
    printf("Código do médico: %d\n", consulta[i].COD_MEDICO);
    printf("Código do paciente: %d\n", consulta[i].COD_PACIENTE);
  }
  printf("-----------------------------\n"); */

  // pesquisarConsulta(nome, dia, array completo de médicos, array completo de consultas);
  // pesquisarConsulta("m1", "SEG", medico, consulta);

  consultasNoDia("SEG", consulta, medico);
  consultasNoDia("terça", consulta, medico);
}