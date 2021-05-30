#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void inputString(char v[])
{
  printf("Input: ");
  fgets(v, 256, stdin);
  v[strlen(v) - 1] = '\0'; // retirando o \n do fim da string
  v[strlen(v)] = 0;
}

void juntarEOrdenarVetores(int length1, int length2, int v1[length1], int v2[length2])
{
  int *vResultante;
  vResultante = (int *)malloc((length1 + length2) * sizeof(int));

  int pos1 = 0, pos2 = 0;
  for (int i = 0; i < length1 + length2; i++)
  {
    if (pos1 == length1)
    {
      vResultante[i] = v2[pos2++];
    }
    else if (pos2 == length2)
    {
      vResultante[i] = v1[pos1++];
    }
    else
    {
      if (v1[pos1] < v2[pos2])
      {
        vResultante[i] = v1[pos1++];
      }
      else
      {
        vResultante[i] = v2[pos2++];
      }
    }
    printf("vResultante[%d] = %d\n", i, vResultante[i]);
  }
  free(vResultante);
}

int main()
{
  int v1[] = {1, 3, 5, 7, 9, 10}, length1 = sizeof(v1) / sizeof(v1[0]);
  int v2[] = {4, 9, 10, 123}, length2 = sizeof(v2) / sizeof(v2[0]);
  juntarEOrdenarVetores(length1, length2, v1, v2);
}