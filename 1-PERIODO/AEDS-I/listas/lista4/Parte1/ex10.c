#include <stdio.h>

int main(){
    const int num = 8;
    int i;
    for (i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", num, i, num * i);
    }
}
