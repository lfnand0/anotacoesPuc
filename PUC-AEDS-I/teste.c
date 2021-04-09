#include <stdio.h>
#include <locale.h>
#include <math.h>
#include <limits.h>

int main()
{
  setlocale(LC_ALL,"english");

  char classLetter;
  int quantStudents;
  char presence;
  int quantAbsents = 0;
  double percentAbsents;
  int quantFivePlusAbsents;

  printf("Type in the letter corresponding to the class, and how many students there are in the class.\n");
  for (int i = 0; i < 2; i++) {
    scanf(" %c %d", &classLetter, &quantStudents);
    printf("Type now for each student: A if they were absent and P if they were present.\n");
    for (int j = 0; j < quantStudents; j++) {
      printf("- ");
      scanf(" %c", &presence);
      
      //checando se presence = A ou presence = P
      while(presence != 65 && presence != 80) {
        printf("ERROR: Invalid value. Type either A or P: ");
        scanf(" %c", &presence);
      }

      if (presence == 65) {
        quantAbsents++;
      }
    }
    percentAbsents = 100*((double) quantAbsents/(double) quantStudents);
    printf("The percentage of absents in the %c class is equal to %.2lf%%.\n", classLetter, percentAbsents);
    if (percentAbsents > 5) {
        quantFivePlusAbsents++;
    }
    quantAbsents = 0;
  }

  printf("Out of all classes, %d had more than 5 percent of absence.\n", quantFivePlusAbsents);



  return 0;
}