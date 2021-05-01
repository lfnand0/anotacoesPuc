# CSS Viewport e Media Queries

## Viewport
* A Viewport é a área visível do usuário de uma página web.
* A janela de visualização varia de acordo com o dispositivo e será menor em um smartphone do que na tela do desktop.
* Antes de tablets e smartphones, as páginas da Web eram projetadas apenas para telas de computador, e era comum que as páginas tivessem um design estático e um tamanho fixo.
* O tamanho da viewport pode ser definido por uma tag meta e tem algumas propriedades:
  ```html
    <meta name="viewport" content="width=X,Y,Z">
  ```
  - X = Valor fixo em PX ou device-width;
  - Y = initial-scale = 1
  - Z = minimum-scale / maximum-scale / user-scalable
  - Ex:
  ```html
    <meta name="viewport" content="width=device-width, initial-scale=1">
  ```
* Introdução de tamanhos relativos que podem ser usados em CSS:
  - Viewport width (vw)
  - Viewport height (vh)
  - Altura ou largura mínima da viewport (vmin)
  - Altura ou largura máxima da viewport (vmax)
* Uma mesma aplicação em várias telas
  - E se for necessário adaptar os tamanhos para vários tipos de dispositivos?
    * 0-480: Smaller smartphones;
    * 481-768: Tablets & larger smartphones;
    * 769-1279: Laptops, larger tablets in landscape, and small desktops;
    * 1280+: Larger desktops and monitors;

## Media Queries
* É possível criar seletores CSS que irão operar somente em um determinado tamanho de tela, ou mesmo somente quando o documento estiver em modo impressão. Também é possível descobrir se um smartphone está deitado (paisagem) ou em pé (retrato).
* A sintaxe:
  ```css
  @media screen and (max-width: 768px) {
    #contents{ width: 60%; }
    #sidebar{ width: 40%; }
  }
  ```
  - Ex:
    * Neste exemplo, a cor de fundo será:
      - Vermelha em dispositivos com width de 1001px a 1400px;
      - Azul em dispositivos com width de 501px a 1000px;
      - Branco em dispositivos com width de 240px a 500px.
  ```css
  @media screen and (min-width: 1001px) and (max-width:1400px) {
    body {
      background-color: red; 
    }
  }
  @media screen and (min-width: 501px) and (max-width:1000px) {
    body {
      background-color: blue;
    }
  }
  @media screen and (min-width: 240px) and (max-width:500px) {
    body {
      background-color: white;
    }
  }
  ```
  
  - Medias possíveis:
    * all
    * print
    * screen
    * speech
    * braile
    * projection
    * Condicionais:
      - and
      - not
* O importante é saber quais são os breakpoints por dispositivo que serão necessários criar. Porque em smartphones e tablets um pixel não é um pixel!
* Em monitores 1px = 1px, mas em dispositivos com telas pequenas a RESOLUÇÃO LÓGICA é diferente da RESOLUÇÃO FÍSICA (hardware).
* Sendo assim, cada dispositivo tem uma "razão de pixel", que deve ser utilizada para se encontrar a resolução lógica. Aquela que será usada como breakpoint da media query
* Encontrando o breakpoint para um dispositivo específico:
  - resolução lógica = resolução física/razão do pixel do dispositivo
  - Ex:
    * Apple iPhone 11 Pro Max
      - Resolução física (physical resolution): 1242 x 2688
      - Razão do pixel (device pixel ratio): 3
      - Resolução lógica (logical resolution): (1242 / 3) x (2688 / 3) = 414 x 896
    * Samsung S10
      - Resolução física (physical resolution): 1440 x 3040
      - Razão do pixel (device pixel ratio): 4
      - Resolução lógica (logical resolution): (1440 / 4) x (3040 / 4) = 360 x 760
  - Valores comuns:
    * 320 (Phone - portrait)
    * 480 (Phone - landscape + portrait)
    * 600 (Small tablet - portrait)
    * 768 (Large tablet - portrait)
    * 800 (Phone + Small tablet - landscape)
    * 1024 (Large tablet - landscape)
    * 1280 (Desktop)
    * 1440 (Wide screen desktop)
