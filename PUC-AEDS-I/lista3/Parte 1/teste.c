/*Faça um programa que receba a idade de oito pessoas, calcule e mostre:
a) a quantidade de pessoas em cada faixa etária;
b) a porcentagem de pessoas na primeira faixa etária com relação ao total de pessoas;
c) a porcentagem de pessoas na última faixa etária com relação ao total de pessoas.
(tabela no livro, página 146, exercício 3)*/

#include <stdio.h>
#include <locale.h>
#include <math.h>
#include <limits.h>

int main()
{
    setlocale(LC_ALL,"english");
    
    //data input
    int age[8];
    
    printf("Type the age of 8 people consecutively. For each time you enter an age, press enter. \n");
    scanf("%d", &age[0]);
    scanf("%d", &age[1]);
    scanf("%d", &age[2]);
    scanf("%d", &age[3]);
    scanf("%d", &age[4]);
    scanf("%d", &age[5]);
    scanf("%d", &age[6]);
    scanf("%d", &age[7]);
    
    //processing data
    int i = 0;
    int ageRange1, ageRange2, ageRange3, ageRange4, ageRange5;
    ageRange1 = ageRange2 = ageRange3 = ageRange4 = ageRange5 = 0;

    while (i < 8) {
      if (age[i] <= 15) {
      ageRange1++;
      }
      if ((age[i] > 15) && (age[i] <= 30)) {
        ageRange2++;
      }
      if ((age[i] > 30) && (age[i] <= 45)) {
        ageRange3++;
      }
      if ((age[i] > 45) && (age[i] <= 60)) {
        ageRange4++;
      }
      if (age[i] > 60) {
        ageRange5++;
      }
      i++;
    }
    

    float percentageAgeRange1;
    float percentageAgeRange5;

    percentageAgeRange1 = 100*(ageRange1/8.0);
    percentageAgeRange5 = 100*(ageRange5/8.0);

    //data output
    printf("There are %d people younger than 15 years.\n", ageRange1);
    printf("There are %d people older than 16 and younger than 30 years.\n", ageRange2);
    printf("There are %d people older than 31 and younger than 45 years.\n", ageRange3);
    printf("There are %d people older than 46 and younger than 60 years.\n", ageRange4);
    printf("There are %d people older than 60.\n", ageRange5);

    printf("The percentage of people younger than 15 years is equal to %.2f%%\n", percentageAgeRange1);
    printf("The percentage of people older than 60 years is equal to %.2f%%\n", percentageAgeRange5);    


    return 0;
}