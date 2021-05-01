# Layout Flex e Grid - Parte 1

## Entendendo o Flex e o Grid
* São estruturas CSS que trabalham contensão de elementos baseados em posição, tamanho e alinhamento;
* Hoje são a recomendação para construção de layouts responsivos;
* As duas técnicas podem trabalhar em conjunto;

## Layout Flex
* Mais indicado para alinhar componentes em uma única dimensão, seja ela em linha ou coluna;
* Não precisamos nos preocupar com a quantidade de itens pois os espaços são calculados automaticamente;
* Não permite interação entre linha e coluna (por exemplo operações de mesclagem de divs);
* Exemplo:
```css
.header {
  background: #727272;
  display: flex; /* Ativando o layout flex */
  flex-wrap: wrap;  /* Definindo o que acontece quando não houver mas espaços para alocar os itens */
  justify-content: space-between; /* Espaçamento entre itens */
  align-items; /* Alinhamento */
  padding: 20px;
}
```
* Mão na Massa
  - Codificar um exemplo de Layout Flex segundo o wireframe explicitado no PDF "003-Layout_Flex_Grid.pdf" no Canvas.

-------------------------------------------------
# Layout Flex e Grid - Parte 2

## Grid Layout
* Indicado para layouts mais complexos onde os elementos tem interação entre linha e coluna;
* É mais complexo de ser implementado pois é necessário explicitar o fracionamento das divisões (linha/coluna);
* Exemplos:
  - Grid Layout:
```css
.grid1 {
  display: grid; /* Ativando o Grid Layout */
  grid-template-columns: repeat(3, 1fr); /* Definindo colunas e o fracionamento */
  max-width: 800px; /* Definindo o tamanho máximo da viewport que será usado */
  margin: 0 auto; /* Margens */
  grid-gap: 20px; /* Espaçamento entre itens */
}
```

  - Grid Layout com Sobreposição:
    * HTML:
```html
<div class="container">
  <div class="a">A</div>
  <div class="b">B</div>
  <div class="c">C</div>
  <div class="d">D</div>
  <div class="e">E</div>
  <div class="f">F</div>
</div>
```
    * CSS:
```css
.container {
  display: grid;
  grid-gap: 10px;
  grid=template-columns: repeat(3, 100px);
}

.a {
  grid-column: 1/3;
  grid-row: 1;
}

.b {
  grid-column: 3;
  grid-row: 1/3;
}

.c {
  grid-column: 1;
  grid-row: 2/4;
}
```

* Mão na Massa
  - Codificar um exemplo de Grid Layout segundo o wireframe 2 explicitado no PDF "003-Layout_Flex_Grid.pdf" no Canvas.

-------------------------------------------------
# Layout Flex e Grid - Parte 2

## Grid Layout + Media Query
* Para garantir uma maior consonância com o modelo de mobile é necessário ainda:
  - Diminuir marca;
  - Esconder menu;
  - Criar ícone para chamar o menu em tela cheia;
  - Estilizar menu com o overlay;
  - Botão de fechar menu;

* Mão na Massa
  - Codificar um menu no formato mobile.

* Alternativas de Alinhamento
```html
<div class="container">
  <div class="box a">A</div>
  <div class="box b">B</div>
  <div class="box c">C</div>
  <div class="box d">D</div>
  <div class="box e">E</div>
  <div class="box f">F</div>
</div>
```

  - FLOAT:
```css
.container {
}

.box {
  float: left;
  margin: 5px;
  width: 100px;
}
```

  - FLEX:
```css
.container {
  display: flex;
  flex-wrap: wrap;
}

.box {
  flex-basis: 100px;
  margin: 5px;
}
```

  - GRID:
```css
.container{
  display: grid;
  grid-gap: 10px;
  grid-template-columns: repeat(auto-fit, 100px);
}

.box {
}
```

* Tipos de Arranjos Possíveis com Grid Layout:
  - https://design.xwiki.org/xwiki/bin/view/Proposal/Skin10x/LayoutVariations



