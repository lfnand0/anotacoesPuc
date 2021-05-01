# Desenvolvimento de Interfaces Web 1.1
## AULA 2 - Tecnologias HTML e CSS

### O que é HTML
* Hypertext Markup Language - linguagem de marcação baseada em tags (ou marcas), utilizada para produção de documentos ou páginas Web, no formato de hipertextos, que são interpretados pelos Navegadores
* Os hipertextos são documentos que utilizam hiperlinks para outros documentos relacionados (daí o nome web)
* OBSERVAÇÃO: 
    * A linguagem HTML foi inicialmente uma aplicação do padrão SGML (Standard Generalized Markup Language), utilizado para definir linguagens de marcação. Na versão 5, isto foi abandonado

### O que é CSS
* Cascade Style Sheets - Folha de estilos em cascata
* Serve para estilizar os elementos HTML, alterando, por exemplo, a cor dos textos e do background, alterando tamanhos, etc.

### Estrutura do Documento HTML: 

<!--
<!DOCTYPE html> ---- Versão HTML
<html lang="en">                --------------------------------|
    <head>                      ----------------|               |    
        <meta name="atributo" content="outro atributo">     | Cabeçalho     |
        <title>Nome do Site</title>                     |               |
    </head>                     ----------------|               |   Documento  
    <body>                      -------------------|            |
        <h1>Título</h1>                            | Corpo      |
        <p>Parágrafo</p>                           |            |
    </body>                     -------------------|            |
</html>                         --------------------------------|
    |
    |
  Elementos: <tag> conteúdo </tag>
-->

### Interação HTML e CSS:
#### HTML

<pre><code>
<html>
    <head>
        <title>Site</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Page</h1>
        <p>Hello World!</p>
    </body>
</html>
</code></pre>

#### CSS (nesse caso o arquivo se chamaria style.css, assim como especificado na linha 32)
body {                      (Muda as seguintes características dentro de <body>)
    background-color: yellow;
    color: blue;
    font-family: Arial;
    font-size: 20px;
}
h1 {                        (Essa regra sobrepõe a regra de cor do bloco acima)
    color: red;             (Muda o conteúdo dentro de <h1> pra cor vermelha)
}

### Dinâmica de carga e processamento

LOAD HTML -> PARSE HTML -> CREATE DOM TREE -> DISPLAY 
              |                    ^
              v                    |
             LOAD CSS ------> PARSE CSS

* OBSERVAÇÃO: parse = interpreta; load = interpreta;