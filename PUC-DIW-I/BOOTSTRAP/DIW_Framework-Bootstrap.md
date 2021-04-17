# Framework Bootstrap

## O que é uma framework?
* É uma abstração que une códigos comuns entre vários projetos de software provendo uma funcionalidade genérica.

## Bootstrap
* É um framework web com código-fonte aberto para desenvolvimento de componentes de interface e front-end para sites e aplicações web usando HTML, CSS e JavaScript, baseado em modelos de design para a tipografia, melhorando a experiência do usuário em um site amigável e responsivo.
* O Bootstrap foi originalmente desenvolvido para o Twitter.
* É, também, um dos projetos mais bem avaliados no GitHub.

## Grid
### Como o Bootstrap trabalha a responsividade?
* O Bootstrap usa um sistema de Grid invisível dividido em 12 colunas para realizar a compactação dos componentes em resoluções menores.

### Construindo um Grid
* Para que um sistema de grid responsivo funcione ele precisa ser construído dentro de um container:
```html
<div class="container">
    <div class="row"></div>
        <div class="col-6 col-sm-12">Coluna 1 com 50%</div>
        <!-- uma row possui 12 colunas, por isso col-6 -->
        <div class="col-6 col-sm-12">Coluna 2 com 50%</div>
        <!-- col-sm-12 significa que, quando a resolução for 576px, a coluna irá ocupar 12 colunas -->
        <!--
            .col-       : auto 
            .col-sm-    : 540px
            .col-md-    : 720px
            .col-lg-    : 960px
            .col-xl-    : 1140px

         -->
    </div>
    <div class="row"></div>
        <div class="col-4">Coluna 4 com 33.3%%</div>
        <div class="col-4">Coluna 5 com 33.3%%</div>
        <div class="col-4">Coluna 6 com 33.3%%</div>
    </div>
</div>


```