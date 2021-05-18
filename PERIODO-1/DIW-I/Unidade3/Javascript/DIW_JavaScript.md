# Javascript

## Uso

- O Javascript é uma linguagem de programação usada para tornar as páginas web interativas. Enquanto HTML estrutura o conteúdo e CSS formata a página, JS cria comportamentos, isto é, define como cada elemento da página (botões, imagens, campos de formulário, etc.) responderá às ações do usuário.
- É uma linguagem de scripts - geralmente usada para manipulação, personalização ou automação de recursos já existentes.
- É uma implementação ou produto da ECMAScript.
- É usada no navegador dentro de um elemento `<script></script>` (mas existem alterntivas). Os trechos de código são encaixados dentro desse elemento e ativados quando o usuário interage com os outros elementos da página.

## Variáveis

- Uma variável é um recurso em uma linguagem de programação que os permite armazenar informações que poderão ser usadas mais tarde. Por exemplo, quando o programa faz algum cálculo e precisa guardar temporariamente o resultado; ou quando o usuário informa seu nome que precisará ser usado mais tarde.
- Uma variável, em JavaScript, é um espaço temporário para armazenamento de informações que poderão ser usadas mais tarde pelos scripts.
- Podemos criar variáveis usando as instruções let e var:
  - let (recomendada): a variável só existe dentro do bloco (escopo) em que foi declarada. Esse bloco é delimitado pelos caracteres { e }.
  - var: a variável é global, ou seja, pode ser vista em qualquer ponto do script - e é exatamente esse o problema, de termos acesso a informação em locais em que não deveria ser possível, ou de precisarmos manter o controle para que as variáveis, criadas em scripts diferentes, não usem o mesmo nome.
- Podemos criar constantes utilizando const.
- As variáveis podem armazenar valores de diversos tipos.
  - Cada tipo de dado é representado de uma forma diferente nos computadores e isso determina quais valores podem ser armazenados. Ex:

```js
let nome = "Marcos";
let idade = 50;
let casado = true;
```

## Tipos de Dados

- Number;
  - Números inteiros ou reais.
- BigInt;
  - Números inteiros com muitos dígitos.
- String;
  - Podem ser delimitadas por aspas simples (' ') ou aspas duplas.
  - Também existe a template string, que é delimitada pela crase (` `) e possui duas diferencas das strings convencionais:
    - Pode conter várias linhas do código;
    - Permite interpolação de expressões (feita utilizando ${});
- Boolean;
  - true ou false.
- Uma variável que não tem o seu tipo ainda definido, isto é, que não recebeu nenhum valor, será do tipo undefined;

## Operadores aritméticos e de concatenação

- Atribuição: (=);
- Inversão de sinal: (-a);
- Pré ou pós-decremento: (--a ou a--);
- Pré ou pós-incremento: (++a ou a++);
- Adição: (+);
  - Pode ser utilizado em operações com strings, como a concatenação.
- Subtração: (-);
- Multiplicação: (\*);
- Divisão: (/);
- Resto da divisão: (%);
- Exponenciação: (\*\*);

## Operadores relacionais e lógicos

- Relacionais:

  - Igual (==);
  - Estritamente igual (===);
    - Diferente do igual (==), o estritamente igual compara também o tipo;
  - Maior que (>);
  - Maior ou igual a (>=);
  - Menor que (<);
  - Menor ou igual a (<=);
  - Diferente (!=);

- Operadores lógicos:
  - Conjunção (AND): (&&);
  - Disjunção (OR): (||);
  - Negação (NOT): (!);

## Controle do fluxo de execução

- Estruturas condicionais:
  - if (condicao) {
    codigo;
    } else if (condicao 2) {
    codigo 2;
    } else {
    codigo 3;
    };
  - switch (expressão) {
    case valor1:
    instrucoes
    break;
    [case valor2;
    instrucoes
    [break;]
    [case valor3;
    instrucoes
    [break;]
    [...]]]
    [default:
    instrucoes]
    }

## Estruturas de repetição

- while (condicao) {};
- do {} while (condicao);
- for (atribuicao inicial; condicao; passo) {};

## Funções

- function nome() {};
- Para executar essa função, digitamos: nome();
- Uma função pode também ter parâmetros e retornar algum valor:
  - function nome(parametros) {
    instrucoes;
    return valor;
    };
    nome(parametro);
- Podemos também usar uma função como parte de uma expressão. Exemplo:
  - let variavel = function(parametros) { instrucoes; return valor; };
- Ou, podemos escrevê-la como uma "função seta" (ou arrow function) da seguinte forma:
  - let variavel = (parametros) => valor;

## Vetores

- A posição dos vetores começa em 0. Exemplo:
  - let frutas = {'Laranja', 'Maçã', 'Banana' };
  - frutas[0] == 'Laranja';
  - frutas[1] == 'Maçã';
  - frutas[2] == 'Banana';
- Para encontrarmos o tamanho de um vetor, usamos a propriedade chamada length da seguinte forma:
  - vetor.length;
- Outras propriedades do Javascript que podem ser usadas com vetores são:
  - vetor.sort();
    - Ordena os elementos do vetor;
  - vetor.pop();
    - Remove o último elemento do vetor;
  - vetor.push(valor);
    - Insere um valor no fim do vetor;
  - vetor.shift();
    - Remove o primeiro elemento do vetor;
  - vetor.unshift();
    - Insere um valor no início do vetor;

## Objetos

- Os objetos em Javascript são estruturas que nos permitem representar as coisas do mundo: sejam elas reais ou abstratas. Um objeto, por exemplo, pode descrever uma pessoa, um veículo ou um evento;
- Para isso, um objeto é descrito por meio de suas propriedades. Cada propriedade é descrita por meio de duas informações: o nome da propriedade, chamado de CHAVE, e o VALOR dessa propriedade.
- Podemos declarar um objeto em Javascript dessa forma:
  let pessoa = {
    nome: 'Luiz',
    idade: 17,
    estudante: true
  }
- Podemos também criar (ou alterar o valor) uma nova propriedade simplesmente atribuindo valor à uma nova chave:
  pessoa.casado = false;
  pessoa.estudante = false;
-
