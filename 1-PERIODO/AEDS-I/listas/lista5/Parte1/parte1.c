#include <stdio.h>
#include <math.h>

void soma(float a, float b)
{
  printf("A soma de %.2f e %.2f é %.2f.\n", a, b, a + b);
}

void subtracao(float a, float b)
{
  printf("A subtração de %.2f e %.2f é %.2f.\n", a, b, a - b);
}

void multiplicacao(float a, float b)
{
  printf("%.2f vezes %.2f é %.2f.\n", a, b, a * b);
}

void divisao(float a, float b)
{
  printf("%.2f dividido por %.2f é %.2f.\n", a, b, a / b);
}

void raiz(float a)
{
  printf("A raíz quadrada de %.2f é %.2f.\n", a, sqrt(a));
}

void potencia(float a, float b)
{
  printf("%.2lf elevado a %.2lf é %.2lf.\n", a, b, pow(a, b));
}

void seno(float a)
{
  printf("O seno de %.2f é %.2f.\n", a, sin(a));
}

void cosseno(float a)
{
  printf("O cosseno de %.2f é %.2f.\n", a, cos(a));
}

void hipotenusa(float cateto1, float cateto2)
{
  float hipo = cateto1 * cateto1 + cateto2 * cateto2;
  printf("A hipotenusa do triângulo de catetos %.2f e %.2f é %.2f.\n", cateto1, cateto2, sqrt(hipo));
}

void tangente(float a)
{
  printf("A tangente de %.2f é %.2f.\n", a, tan(a));
}

void logaritmo(float a, float b)
{
  float Logaritmo = log(a) / log(b); // isso é a mesma coisa que log de a na base b
  printf("O log de %.2f na base %.2f é %.2f.\n", a, b, Logaritmo);
}

void area(float a, float b)
{
  printf("A área do retângulo de base %.2f e altura %.2f é %.2f.\n", a, b, a * b);
}

void areaCircunferencia(float a)
{
  float pi = 355.0/113.0; // aproximação de pi
  printf("A área da circunferência de raio %.2f é %.2f.\n", a, 2 * a * pi);
}

void fatorial(int a)
{
  int inicial = a, Fatorial = 1; // usado no printf final
  if (a < 0)
  {
    printf("O valor é negativo, e, portanto, seu fatorial é indefinido.\n");
  }
  else if (a == 0)
  {
    printf("%d! é igual a %d.\n", a, Fatorial);
  }
  while (a > 1)
  {
    Fatorial = Fatorial * a;
    a -= 1;
  }
  printf("%d! é igual a %d.\n", inicial, Fatorial);
}

int main()
{
  int instrucao = 1;
  while (instrucao != 0)
  {
    printf("\n----------CALCULADORA----------\n");
    printf("a) Soma\nb) Subtração\nc) Multiplicação\nd) Divisão\ne) Raiz "
           "Quadrada\nf) Potência\ng) Seno\nh) Cosseno\ni) Hipotenusa de um "
           "Triângulo Retângulo\nj) Tangente\nk) Logaritmo\nl) Área de um "
           "Retângulo\nm) Área de uma Circunferência\nn) Fatorial\n0) Sair\n");
    printf("Digite a letra da operação desejada(ou 0 para sair): ");
    char operacao;
    scanf(" %c", &operacao);
    printf("\n+++++++++++++++++++++++++++++++\n");
    // saltando uma linha para facilitar a leitura
    if (operacao == '0')
    {
      printf("Tchau :)\n");
      return 0;
    }
    else if (operacao == 97)
    { // 97 = 'a'
      float a, b;
      printf("Digite dois valores: ");
      scanf("%f %f", &a, &b);
      soma(a, b);
    }
    else if (operacao == 98)
    { // b
      float a, b;
      printf("Digite dois valores: ");
      scanf("%f %f", &a, &b);
      subtracao(a, b);
    }
    else if (operacao == 99)
    { // c
      float a, b;
      printf("Digite dois valores: ");
      scanf("%f %f", &a, &b);
      multiplicacao(a, b);
    }
    else if (operacao == 100)
    { // d
      float a, b;
      printf("Digite dois valores: ");
      scanf("%f %f", &a, &b);
      if (b == 0)
      {
        printf("O resultado é indefinido.\n");
      }
      else
      {
        divisao(a, b);
      }
    }
    else if (operacao == 101)
    { // e
      float a;
      printf("Digite um valor: ");
      scanf("%f", &a);
      raiz(a);
    }
    else if (operacao == 102)
    { // f
      double a, b;
      printf("Digite um valor, e em sequência a potência: ");
      scanf("%lf %lf", &a, &b);
      potencia(a, b);
    }
    else if (operacao == 103)
    { // g
      float a;
      printf("Digite um valor: ");
      scanf("%f", &a);
      seno(a);
    }
    else if (operacao == 104)
    { // h
      float a;
      printf("Digite um valor: ");
      scanf("%f", &a);
      cosseno(a);
    }
    else if (operacao == 105)
    { // i
      float cateto1, cateto2;
      printf("Digite o valor dos dois catetos: ");
      scanf("%f %f", &cateto1, &cateto2);
      hipotenusa(cateto1, cateto2);
    }
    else if (operacao == 106)
    { // j
      float a;
      printf("Digite um valor: ");
      scanf("%f", &a);
      tangente(a);
    }
    else if (operacao == 107)
    { // k
      float a, b;
      printf("Digite um valor e, em sequência, a base do logaritmo: ");
      scanf("%f %f", &a, &b);
      logaritmo(a, b);
    }
    else if (operacao == 108)
    { // l
      float base, altura;
      printf("Digite a base e a altura do retângulo: ");
      scanf("%f %f", &base, &altura);
      area(base, altura);
    }
    else if (operacao == 109)
    { // m
      float raio;
      printf("Digite o raio da circunferência: ");
      scanf("%f", &raio);
      areaCircunferencia(raio);
    }
    else if (operacao == 110)
    { // n
      int a;
      printf("Digite um valor: ");
      scanf("%d", &a);
      fatorial(a);
    }
    else
    {
      printf("ERRO: Código inválido.\n");
    }
  }
}
