#include <stdio.h>

void primos() {
	int numPrimos = 0, primo = 100;
	printf("Três primeiros números primos acima de 100: \n");
	while (numPrimos < 3) {
		int divisores = 0;
		if (primo % 2 == 0) {
			primo++;
		} else {
			for (int i = primo; i > 0; i -= 2) {
				if (primo % i == 0)
					divisores++;
			}
			if (divisores == 2) {
				printf("%d, ", primo);
				numPrimos++;
			}
			primo++;
		}
	}
}

int main() {
	primos();
}
