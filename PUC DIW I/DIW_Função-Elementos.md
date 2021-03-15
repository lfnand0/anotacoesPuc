# Desenvolvimento de Interfaces Web 1.1
## AULA 4 - Tipos de Elementos quanto a Função

### Resumo:
    1. Metadados
        * Informações sobre a página
    2. Textuais
        * Conteúdo de texto das páginas
    3. Multimídia
        * Recursos como imagens, áudio e vídeo
    4. Tabelas
        * Estruturar dados em tabela
    5. Estruturas
        * Separação e organização do conteúdo
    6. Formulários
        * Elementos para entrada de dados pelo usuário
    7. Scripting
        * Conteúdo dinâmico de aplicações Web
    8. Integração
        * Conteúdo externo ou multimídia avançada

### Elementos Inline e Elementos Block
* Inline:
    * São dispostos em linha seguindo o fluxo padrão
    * Exemplos: img, span, a, button, input, label
* Block:
    * Iniciam uma nova linha não se dispondo a frente daquilo que o precede.
    * Exemplos: div, h1, ..., h6, p, form, canvas, table, section

### 1. Metadados:
    * title: define o título do documento
    * style: define códigos de formatação no padrão CSS
    * link: definem ligações com outros arquivos como: CSS, scripts, etc.
    * meta: as meta tags trazem informações sobre o documento tais como codificação de caracteres, descrição, palavras-chave, autor, etc.
        * Meta tags:
            * charset: especifica a codificação de caracteres utilizada no documento HTML (UTF-8; Latin1(antigo))
            * http-equiv: orientam o navegador sobre como processar a página e podem ser:
                - content-type: descreve o tipo de conteúdo (MIME) do corpo da página
                    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                - expires: define quando o documento deve ser considerado expirado
                    <meta http-equiv="expires" content="Mon, 22 jul 2006 11:12:01 GMT" />
                - refresh: define um intervalo de tempo para atualização do documento. Utilizado para recarga de tempos em tempos, ou para redirecionamento de páginas
                    <meta http-equiv="refresh" content="15,url=http://www.site.com" />
                - cache-control: definem o controle de salvamento da página no cliente ou no servidor de proxy:
                    * public: os dados da página podem ser armazenados de forma compartilhada, isto é, será utilizado por diferentes usuários de um mesmo browser.
                    * private: é o contrário de public, o cache é armazenado para um específico usuário
                    * no-cache: a página não é armazenada em cache.
                    * no-store: é feito um cache temporário, a página não é arquivada.
            * name: permitem definir palavras-chave associadas ao documento com o objetivo de indexá-lo. Esta informação é utilizada por máquinas de busca como o Google e o Bing.
                - DUBLIN CORE é um padrão de indexação muito utilizado, embora possamos utilizar outros padrões. Neste, são especificadas tags como:
                    * author;
                        <meta name="author" content="Luiz" />
                    * description;
                    * keywords;
                    * copyright;
                    * outras tags podem ser encontradas em https://dublincore.org



### 2. Textuais:
    * <h1> - <h6>: título (diminui de tamanho de acordo com a numeração)
    * <p>: parágrafo
    * <br>: quebra de linha
    * <a href="">: hiperlinks
    * <em>: itálico
    * <strong>: negrito
    * <small>: comentários laterais
    * <cite>: citações
    * <abbr>: abreviaturas
    * <data>: dados interpretados pelo computador
    * <time>: dado de data e hora interpretados pelo computador
    * <code>: código de computador
    * <i>: voz alternativa
    * <b>: palavras-chave

    * Listas:
        * <ol>: lista ordenada (1. ;2. ;3. ;)
        * <ul>: lista não ordenada (* ;* ;* ;)
        * <dl>: lista de definições 

### 3. Multimídia:
    * <img src="">: elemento do tipo Inline que coloca uma imagem na tela

### 4. Tabelas:
    * <table border="">: especifíca a aparência de uma tabela
    * <caption>: título
    * <tr>: table row (linha)
    * <th>: table header (cabeçalho)
    * <td>: table data cell (célula)

### 5. Estruturas:
    * <div>
    * <header>
    * <nav>
    * <section>
    * <article>
    * <aside>
    * <footer>

### 6. Formulários:
    * <form>
    * <input>
    * Exemplo:
<body>
    <form name="form_login" actin="do_login.html" method="POST">
        Usuário: <input type="text" name="usuario" value=""></br>
        Senha: <input type="password" name="senha" value=""></br>
        <input type="submit" value="Ok">
    </form>    
</body>

### 7. Scripting
    * Incluem códigos de scripts que tornam as páginas mais dinâmicas
    * Obs: os scripts podem estar em outros arquivos ou na própria página
    * <script>
    * Exemplo:
<!-- Arquivo externo -->
<script src="arquivo.js"></script>
<!-- Script interno -->
<script>
    alert('Seja bem vindo ao nosso site')
</script>

### 8. Integração
    * Conteúdos de outros sites como Youtube, Google Maps, entre outros podem ser anexados em uma página
    * <iframe>
    * <embed> e <object> também podem ser utilizados para isso
    * Exemplo:
<iframe width="560" height="315" src="https://www.youtube.com/embed/rdcu)ytxjKY" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" frameborder="0" allowfullscreen></iframe>