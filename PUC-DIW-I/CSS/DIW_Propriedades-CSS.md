# Desenvolvimento de Interfaces Web 1.2
## PARTE 2 - Propriedades da Linguagem CSS

### Conceitos Importantes:
* Valores e Unidades: permitem especificar comprimentos, tamanhos e cores em propriedades
* Tipos de Elementos: Como os elementos são dispostos no fluxo do documento HTML

### Propriedades CSS: 
* Display - como o elemento HTML é apresentado na página
* Tipografia - parte que define cor, tamanho, espaçamento e forma do texto
* Backgrounds - permite estilizar o fundo de um elemento com cores e imagens
* Box Model - define o tamanho e o comportamento de elementos HTML em geral
* Posicionamento - permite posicionar os elementos HTML na página
* Transformações - permite alterar elementos HTML
* Transições define transições de elementos entre estados
* Animations - permite animar a aplicação de outras propriedades

### Valores e Unidades:
#### Comprimento e Tamanho: 
    * in (polegadas)                1in = 2,54cm = 25,4mm = 72pt = 6pc
    * cm (centímetros)
    * mm (milímetros)
    * pt (pontos)
        * Padrão em tipografia, usado em impressoras
    * pc (paicas)
    * em (tamanho da fonte)
        * Por exemplos, 1.2em é o mesmo que 120%. Muito utilizado para margens.
    * px (pixels)
    * % (percentual)

#### Cores:
    * #RRGGBB
        * Hexadecimal p/ vermelho, verde e azul, que perite valores que variam de 0 (00) a 255 (FF)
        * Ex: #FF88CC
    * #RGB
        * Encurtamento para valores repetidos
        * Ex: #F8C é o mesmo que #FF88CC
    * rgb(rrr, ggg, bbb)
        * Especifica os valores de 0 a 255
        * Ex: verde puro rgb(0, 255, 0)
    * Palavras chaves
        * Palavras baseadas nas cores originais do Windows VGA
        * Ex: aqua, black, blue, fuchsia, gray, green, lime, maroon, navy, olive, purple, red, silver, teal, white, yellow, etc.
    
### Tipos de Elementos do HTML
* Elementos Inline
    * Elementos que são dispostos em linha seguindo o fluxo padrão, e normalmente possuem apenas dados ou outros elementos inline.
    * Ex: ```<img>, <span>, <a>, <button>, <input>, <label>```
* Elementos block-level
    * São elementos que iniciam uma nova linha não se dispondo a frente daquilo que o precede.
    * Ex: ```<div>, <h1>...<h6>, <p>, <form>, <canvas>, <table>, <section>```
* IMPORTANTE:
    * O CSS pode transformar um elemento inline em um block-level com a propriedade display. Exemplos:
        * Transformando elementos <span> em containers.
        span: {display: block; }
        * Centralização de imagem <img>.
        img {display: block; margin: 0 auto; }

### Propriedades CSS:
#### Display:
    * display: none
        * O elemento não será exibido.
    * display: block
        * O elemento é renderizado como um element de bloco, mesmo que ele seja um elemento inline como um hyperlink
    * display: inline
        * O elemento será renderizado como um elemento inline, mesmo que ele seja um elemento de bloco como o list item (<li>).
    * display: inline-block
        * O elemento será renderizado como um bloco, porém em linha com os demais elementos.

#### Tipografia:
    * font-family: define o tipo de letra (fonte) empregada no texto
        * font-family: arial, helvetica, sans-serif
    * font-size: especifica o tamanho da letra
        * font-size: xx-small | x-small | small | medium | large | x-large | xx-large | smaller | larger | 10px | 80%
    * font-style: define o estilo da fonte
        * font-style: normal | italic | oblique
    * font-weight: indica a largura dos caracteres
        * font-weight: normal | bold | bolder | lighter | 100 | 200
    * font-variant: indica se os caracteres minúsculos devem ser mostrados como maiúsculas
        * font-variant: normal | small-caps
    * line-height: define a altura da linha
        * line-height: normal | 1.6 | 80% | 200%
    * color: altera a cor do texto
        * color: [cor]
    * text-align: define o alinhamento do texto
        * text-align: left | right | center | justify
    * text-shadow: define se o texto terá sombra
        * text-shadow: none | x e y [cor]
    * text-decoration: define como o texto será decorado
        * text-decoration-line: none | underline | overline | line-through
        * text-decoration-style: solid | wavy | dashed
        * text-decoration-color: [cor]
    * letter-spacing | word-spacing: espaçamento entre letras e entre palavras em um bloco de texto
        * letter-spacing: normal | 2px | 0.1em
    * text-transform: define se o texto deve vir em maiúscula, minúscula ou capitaliado
        * text-transform: none | capitalize | uppercase | lowercase

#### Backgrounds:
    * background-color: cor de fundo do elemento
        * background-color: yellow
    * background-image: imagem ou gradiente de fundo do elemento
        * background-image: url(http://imagens.com/fundo.jpg);
        * background-image: linear-gradient (red, blue);
    * background-repeat: indica como repetir a imagem no fundo caso essa seja menor que o elemento
        * background-repeat: no-repeat | repeat | repeat-x | repeat-y | space | round
    * background-position: posição inicial do fundo em relação ao elemento HTML
        * background-position: top | left | center | right | bottom

#### Box Model:
    * height e width
        * tamanho básico do elemento
    * margin
        * espaçamento ao redor do elemento
    * border
        * borda em torno do elemento
    * padding
        * espaçamento entre a borda e o conteúdo
    * background - permite controlar:
        * cor de fundo do elemento
        * imagem como fundo
    * PROPRIEDADES DERIVADAS DO BOX MODEL:
        * margens
            * margin-top, margin-left, margin-right, margin-bottom
        * padding
            * padding-top, padding-left, padding-right, padding-bottom
        * bordas
            * border-top, border-left, border-right, border-bottom
        * Forma de aplicação de tamanhos:
            * 1 valor: Aplica-se a todas as propriedades (top, right, bottom, left);
                * border: 10px;
            * 2 valores: O primeiro se aplica a top e bottom e o segundo se aplica a right e left;
                * border: 5px 20px;
            * 3 valores: O primeiro se aplica a top, o segundo a left e right e o terceiro a bottom;
                * border: 5px 20px 10px;
            * 4 valores: Se aplicam na ordem horária (top, right, bottom, left);
                * border: 5px 20px 10px 20px;

#### Posicionamento
    * position: static
        * valor: padrão para os elementos
        * o elemento é considerado como não posicionado.
        * o elemento segue o fluxo de renderização da página normalmente
        * não é afetado pelas propriedades: top, bottom, left, right, e z-index
    * position: relative
        * o elemento segue o fluxo de renderização da página normalmente
        * o elemento é considerado como posicionado
        * é afetado pelas propriedades: top, bottom, left, right, e z-index
        * estabelece como ponto zero o canto superior esquerdo
    * position: fixed
        * o elemento NÃO segue o fluxo de renderização da página
        * o elemento é considerado como posicionado
        * é afetado pelas propriedades: top, bottom, left, right e z-index
        * o elemento se mantém fixo na posição estabelecida sem refletir à rolagem da tela
    * position: absolute
        * o elemento NÃO segue o fluxo de renderização da página
        * o elemento é considerado como posicionado
        * é afetado pelas propriedades: top, bottom, left, right e z-index
        * estabelece como ponto zero o canto superior esquerdo do objeto pai

    * PROPRIEDADE Z-INDEX
        * Define a ordem do elemento no eixo z, permitindo colocar um elemento sobre ou abaixo de outro
            * z-index: auto
            * z-index: 1
            * z-index: -1

#### Transformações
* O CSS permite realizar alterações de forma, tamanho e posicionamento dos elementos, tais como translação, rotação, escala e inclinação
    * transform: realiza uma alteração em um elemento HTML
        * transform: [função]
    * Funções possíveis
        * translate (x, y) - translada o elemento no eixo X e Y
        * translateX (x) - translada o elemento no eixo X
        * translateY (y) - translada o elemento no eixo Y
        * scale (x, y) - aumenta a largura (x) e altura (y) do elemento
        * scaleX (x) - aumenta a largura do elemento
        * scaleY (y) - aumenta a altura do elemento
        * rotate (n) - rotaciona o elemento em n graus
        * skew (x, y) - inclinação do elemento nos eixos X e Y

#### Transições
* As transições definem como uma mudança de um elemento da página vai ser conduzida pelo Browser gerando um efeito ou animação. As transições são aplicadas na regra CSS inicial do elemento.
    * transition: controla a mudança de estado de um elemento
        * transition: [property] [duration] [timing-function] [delay]
        * transition: width 1s easy-in-out 0.5s
    * transition-property: identifica a propriedade para a qual a transição se aplica
        * transition-property: width
    * transition-duration: define o tempo para concluir a transição
        * transition-delay: 0.5s
    * transition-time-function: define a dinâmica de passagem de tempo da transição
        * transition-time-function: linear | step-end | steps (x, end) | easy | easy-in | easy-out | easy-in-out

#### Animações
* O recurso de animações permite criar efeitos animados em elementos de uma página.
    * @keyframes: controla a mudança de estado de um elemento. Exemplos:
```css
        @keyframes nome_sequencia {
            from: { background-color: red; }
            to: { background-color: yellow; }
        }
        @keyframes nome_sequencia2 {
            0% { background-color: blue; }
            50% { background-color: red; }
            100% { background-color: red; }
        }
```
    * animation-name: identifica a animação a ser aplicada, definida pela diretiva @keyframes
        * animation-name: nome_sequencia
* A relação a seguir apresenta as propriedades possíveis para definição de uma animação
    * animation-duration - define o tempo para concluir a animação
        * animation-duration: 1s
    * animation-delay - define o atraso para o início da animação
        * animation-delay: 0.5s
    * animation-iteration-count - define quantas vezes a animação deve ser executada
        * animation-iteration-count: n | infinite
    * animation-direction: define a dinâmica de passagem de tempo da animação
        * animation-direction: normal | reverse | alternate | alternate-reverse
    * animation-timing-function: define a dinâmica de passagem tempo da animação
        * animation-timing-function: linear | ease | ease-in | ease-out | ease-in-out | cubic-bezier (n, n, n)
    * animation-fill-mode: define a dinâmica de passagem de tempo da animação
        * animation-fill-mode: none | forwards | backwards | both
        