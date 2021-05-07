# Google Sheets

## Introdução
* Olá, nesse vídeo eu explicarei resumidamente como utilizar o Google Sheets. Esse vídeo é parte de uma série que possui como foco ajudar o processo de digitalização de pequenos negócios, e o Sheets é uma ferramenta excepcional principalmente pra parte administrativa e financeira.

## Abrindo o Site


## Criando uma planilha
* Diversos modelos, porém iremos utilizar um exemplo já feito, de uma tabela com os lucros de uma empresa fictícia:
* TOPO:
  * Logo: retorna à página inicial
  * Nome: ao clicar, podemos alterar o nome da planilha
  * Estrela: podemos favoritá-la, para que ela fique destacada na página inicial
  * Painel de atividades:
    * Leitores;
    * Tendência de visualizações;
    * // de comentários;
    * Histórico de compartilhamento;
    * Configurações de privacidade.
  * Histórico de comentários
    * Mostrará todos os comentários presentes na página.
  * Compartilhar:
    * Adicionar pessoas específicas
      * Engrenagem: algumas opções a mais 
    * Em baixo:
      * Mudar o link: podemos alterar, também, as opções de edição do arquivo para as pessoas que receberem o link
      * Copiar o link.

* BAIXO:
  * Adicionar páginas;
    * Ao clicar, será gerada outra página
    * Exemplo simples, digitar teste e voltar para a paǵina 1
    * Podemos clicar no triângulo, e entre essas várias opções podemos apagar essa página 
  * Todas as páginas;
  * Página;

## Funcionalidades básicas
### Diversas opções, então começaremos pela funcionalidade mais fundamental:
* Colunas, linhas e células
  * Colunas: a, b, c, etc
  * Linhas: números
  * Células: cada retângulo desses
  * Selecionando colunas e tabelas:
    * Clicando nelas
  * Selecionando celulas:
    * Clicando duas vezes, podemos editá-las
    * Para confirmar a edição, apertamos a tecla ENTER;
    * Para cancelar a edição, apertamos a tecla ESC;
  * Nome das células:
    * Dado pela coluna que ela se encontra, seguido pela linha.
    * EXEMPLO:
      * Primeira célula: A1
      * Lado direito: B1
      * Caixa de nome no topo esquerdo
  * Selecionando múltiplas células:
    * Muito útil pra, por exemplo, a criação de fórmulas
    * Clicando, segurando e arrastando

* Opções básicas:
  * DA ESQUERDA PRA DIREITA (as mais importantes):
    * Desfazer e refazer;
    * Imprimir;
    * Zoom;
    * Formatar:
      * Colunas B, C, E;
    * Texto:
      * Fonte;
      * Tamanho da fonte;
      * Negrito;
      * Itálico;
      * Tachado;
      * Cor do texto;
    * Célula:
      * Cor da célula;
      * Borda;
      * Mesclar células;
        * Opção normalmente desabilitada, demonstrar um exemplo;
    * Ajustes de texto:
      * Várias opções de alinhamento;
    * Inserimento:
      * Inserir link;
      * Inserir comentário;
      * Inserir gráfico;
    * Filtragem;
    * Funções;

* Explicando a planilha de exemplo:
  * Cabeçalho e a parte do lucro total mesclados
  * Cor de preenchimento;
  * Formatação automática
  * Texto alinhado

* Usando fórmulas:
  * Fórmulas usadas:
    * Cálculo do percentual de lucro, do lucro e do lucro total
    * Exemplificar alterando um dos valores
  * Como que eu fiz isso?
    * O Google Sheets possui várias fórmulas já definidas, além de nos dar a oportunidade de realizar operações básicas de matemática (soma, subtracao, etc)
    * Clicando na célula E6, podemos ver =DIVIDE(C6;B6). O que isso significa?
      * Toda fórmula no Google Sheets é inicializada com = na frente
      * Depois disso temos o DIVIDE, uma das fórmulas padrões do sheets, (tem várias, deixar na desc uma lista delas)
        * DIVIDE possui como parâmetros as células C6 e B6, separadas por ;, e ela vai dividir C6 por B6
        * Ao clicarmos na caixa, as células ficam marcadas
        * Outra coisa interessante é que, como a célula usada está formatada como porcentagem, ela já multiplica esse valor por 100 automaticamente
          * Tirar a formatação para exemplificar
    * Clicando na célula F6
      * Pegando o valor da célula D6 (quantidade vendida) e multiplicando pela subtração do p. de venda pelo de compra.
    * Clicando na célula F11
      * Somando os valores da célula F6 até F10
      * Reescrevendo usando uma das fórmulas padrões que é a SUM (soma em inglês)
        * Mudar para =SUM(F6:F10)
        * Repare que, diferente do cálculo de percentual, os valores estão separados por :, ou seja, todas as células entre F6 e F10 serão somados, se a gente colocasse ; o valor da célula F6 apenas seria somado ao de F10

* Criando um cabeçalho
  * Pra isso, vou criar outra página;
  * Retângulo vazio em cima
  * Selecionar uma área razoável;
  * Mesclar;
  * Mudar a cor;
  * Texto: "Lucro: Mês de Maio"
  * Mudar o tamanho da fonte;
  * Mudar a fonte;
  * Colocar em negrito;
  * Alinhar texto;

* Finalização
  * É claro que ainda existem diversas funcionalidades que não foram cobertas aqui neste vídeo, já que nosso intuito com esse video é realmente fazer algo bem prático e resumido, então eu aconselho colocar a mão na massa e experimentar com a plataforma, o que ajudaria muito na concretização desse aprendizado.
  * Muito obrigado por assistir o vídeo, lembrando que na descrição aí em baixo tem um link com todas as fórmulas padrões do Sheets caso você queira aprendê-las, se o vídeo te ajudou por favor deixe um like e comente algo positivo, e se você tem alguma crítica a fazer, qualquer que seja, por favor comente também, nós apreciamos muito sua opinião, e até mais.

## Importando e exportando arquivos
