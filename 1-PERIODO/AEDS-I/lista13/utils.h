#include <iostream>
#include <stdlib.h>
#include <fstream>
#include <string.h>
#include <stdio.h>

int dado(int max, int min){
  // return min + (std::rand() % max);
  if (max < min) {
    int temp = max;
    max = min;
    min = temp;
  }
  if (max != min) {
    return (std::rand() % (max - min + 1) + min);
  } else {
    return -1;
  }
  
  // return std::rand();
}