# Desenvolvimento de Interfaces Web 1.2
## AULA 1 - Sintaxe da Linguagem CSS

### Tipos de Seletores:
    * O seletor indica um elemento HTML.
    * Identificador (id)
        * Indica um elemento HTML com um id específico
        * #[ID] {}
    * Classe (class)
        * Indica os elementos HTML de determinada class
        * .[CLASS] {}
    * Atributo
        * Indica os elementos HTML com atributos específicos
        * [ATTRIBUTE] {}
    * Pseudo-Classe
        * Indica estados ou situações de elementos HTML
        * :first-of-type {}
        * :last-of-type {}
        * :hover {}
        * :focus {} 
        * :visited
        * :link
        * :active
        * :nth-child(n) {}
        * :first-child {}
        * :last-child {}
        * :empty {}
        * :not() {}

### Combinação de seletores
    * A, B {} - Equivale a duas regras distintas A {} e B {}
    * AB {} - Elementos associados a A e B ao mesmo tempo. Uso com classes, IDs.
    * A B {} - Elementos associados a B, descendentes de elementos associados a A.
    * A > B {} - Elementos associados a B, filhos de elementos associados a A.
    * A + B {} - Elementos associados a B, próximo irmão de elementos associados a A.
    * A ~ B {} - Elementos associados a B, próximos irmão de elementos associados a A.

### Prioridade de Seletores CSS
    * A escolha de declaração CSS a ser aplicada, no caso de conflitos, obedece as seguintes regras:
        * Ordem de leitura
        * Especificidade
        * Importância
            * a palavra-chave !important faz a declaração prevalecer sobre as demais
    