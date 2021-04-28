#include <stdio.h>

float polegadasParaCentimetros(float pol)
{
  float cm = pol * 2.54;
  return cm;
}

float centimetrosParaPolegadas(float cm)
{
  float pol = cm / 2.54;
  return pol;
}

float fahrenheitParaCelsius(float f)
{
  float c = (f - 32) / 1.8;
  return c;
}

float celsiusParaFahrenheit(float c)
{
  float f = (c * 1.8) + 32;
  return f;
}

int main()
{
  float n;
  printf("Digite um valor para n: ");
  scanf("%f", &n);
  printf("%.2f centímetros = %.2f polegadas\n", n, centimetrosParaPolegadas(n));
  printf("%.2f polegadas = %.2f centímetros\n", n, polegadasParaCentimetros(n));
  printf("%.2fºC = %.2fºF\n", n, celsiusParaFahrenheit(n));
  printf("%.2fºF = %.2fºC\n", n, fahrenheitParaCelsius(n));
}