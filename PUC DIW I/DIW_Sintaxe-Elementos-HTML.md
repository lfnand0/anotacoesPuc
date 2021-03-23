# Desenvolvimento de Interfaces Web 1.1
## AULA 3 - Sintaxe dos Elementos HTML

### Elementos:
* São a estrutura básica do documento HTML, marcados por meio de tags que são delimitadas pelos símbolos <>. Veja o exemplo:
            <body> conteúdo </body>

* Toda página deve estar contida dentro de um elemento HTML.
            <html> conteúdo </html>

* Os nomes dos elementos nas tags NÃO são sensíveis ao case(maiúsculo ou minúsculo)
#### Os elementos podem se apresentar em quatro formatos:
* Elementos com elementos filhos
            <html> <head></head> <body></body> </html>
* Elementos com texto
            <title> PUC Minas Web Site </title>
* Elementos vazios
            <meta name="author" content="Luiz"> ou <br>
* Elementos de conteúdo misto (texto e elementos filhos)
            <p> Documento <span lang="en">Web</span> </p>

### Atributos:
* OS atributos podem ser incluídos em elementos HTML
* Um atributo não se repete em um elemento
* São definidos pelo par nome/valor
            <input disabled name="Nome_Usuario" value="lfnando">
* Recomenda-se utilizar aspas duplas
* Os atributos alteram o funcionamento dos elementos do HTML
* Cada elemento possui um conjunto próprio de atributos
* Os atributos possuem valores livres ou pré-definidos

### DOCTYPE
* O DOCTYPE indica ao browser qual a versão do HTML está sendo utilizada no documento, alternando entre quirks mode e strict mode
* HTML5: <!DOCTYPE html>
* HTML 4.01: <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
* XHTML 1.0: <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
* História de uso:
    * 1991: HTML 1
    * 1995: HTML 2
    * 1996: CSS 1; JavaScript
    * 1997: HTML 3.2
    * 1998/9: CSS 2; HTML 4.01
    * 2000: XHTML 1.0
    * 2005: Ajax
    * 2009: HTML 5

### Cabeçalho:
* Primeira parte do arquivo HTML, representada pela tag <head>, que inclui informações sobre o documento (metadados), referências a scripts, folhas de estilo (CSS) que complementam o documento,

### Corpo:
* Segunda parte do arquivo HTML, representada pela tag <body>, que inclui todo o conteúdo da página exibido ao usuário pelo Navegador. É composto por textos, links, imagens, vídeos, tabelas, formulários.