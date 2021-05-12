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

- 
