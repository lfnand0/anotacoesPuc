#include <stdio.h>

void polegadasParaCentimetros(float pol, float *cm)
{
  *cm = pol * 2.54;
}

void centimetrosParaPolegadas(float cm, float *pol)
{
  *pol = cm / 2.54;
}

void fahrenheitParaCelsius(float f, float *c)
{
  *c = (f - 32) / 1.8;
}

void celsiusParaFahrenheit(float c, float *f)
{
  *f = (c * 1.8) + 32;
}

int main()
{
  float n, cm, pol, f, c;
  printf("Digite um valor para n: ");
  scanf("%f", &n);
  centimetrosParaPolegadas(n, &pol);
  polegadasParaCentimetros(n, &cm);
  celsiusParaFahrenheit(n, &f);
  fahrenheitParaCelsius(n, &c);
  printf("%.2f centímetros = %.2f polegadas\n", n, pol);
  printf("%.2f polegadas = %.2f centímetros\n", n, cm);
  printf("%.2fºC = %.2fºF\n", n, f);
  printf("%.2fºF = %.2fºC\n", n, c);
}