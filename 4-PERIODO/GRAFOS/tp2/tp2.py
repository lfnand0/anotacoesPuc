import random
import copy
import time
import sys
import argparse

sys.setrecursionlimit(100000)
start = time.time()

# Salva um grafo no diretório arq
def salvarGrafo(grafo, arq):
    with open(arq, 'w') as file:
        for i in range(len(grafo)):
            for j in range(len(grafo)):
                file.write(str(grafo[i][j]))
            file.write("\n")

# Gera um grafo direcionado simples aleatório de n vértices
# p: probabilidade de dois vértices aleatórios possuírem uma aresta
# Retorna a matriz de adjacência do grafo gerado
def grafoAleatorio(n, p):
    grafo = [[]]*n
    for i in range(n):
        grafo[i] = [0]*n
        for j in range(n):
            if (j != i):
                probability = random.random()
                if (probability < p):
                    grafo[i][j] = 1

    return grafo

# Busca em Largura
# Retorna True caso exista um caminho entre a origem e o destino
# Retorna False caso contrário
def buscaLargura(origem, destino, grafo, pai):
    visitado = [False] * len(grafo)
    fila = []
    fila.append(origem)
    visitado[origem] = True

    while fila:
        v = fila.pop(0)
        for u in range(len(grafo[v])):
            if (grafo[v][u] == 1 and not visitado[u]):
                fila.append(u)
                visitado[u] = True
                pai[u] = v

    return visitado[destino]

# Busca em Profundidade
# Encontra todos os caminhos de um vértice origem à um destino
# Recursivo, não retorna nada
# Armazena todos os caminhos encontrados na lista "caminhos", 
# que deve ser passada como parâmetro na chamada inicial
def buscaProfundidade(origem, destino, grafo, visitado, caminho, caminhos):
    visitado[origem] = True
    caminho.append(origem)

    if origem == destino:
        caminhos.append(copy.deepcopy(caminho))
    else:
        for i in range(len(grafo)):
            if (grafo[origem][i] == 1 and visitado[i] == False):
                buscaProfundidade(i, destino, grafo, visitado, caminho, caminhos)
    
    caminho.pop()
    visitado[origem] = False

# Checa se existe algum elemento de l1 em l2
def comp(l1, l2):
    for i in l1:
        if i in l2:
            return True

    return False

# Encontra um conjunto de caminhos disjuntos que possui o número
# máximo de caminhos disjuntos possíveis para o grafo
def acharCaminhos(origem, destino, grafo, n, cam_dis):
    visitado = [False] * len(grafo)
    caminho = []
    caminhos = []
      
    buscaProfundidade(origem, destino, grafo, visitado, caminho, caminhos)
    disjuntos = []
    for caminhoA in caminhos:
        disjuntos = [caminhoA]
        aDuplas = []
        for i in range(len(caminhoA[:-1])):
            aDuplas.append((caminhoA[i], caminhoA[i+1]))
        
        posA = caminhos.index(caminhoA)+1

        visitados = copy.deepcopy(aDuplas)
        for caminhoB in caminhos[posA:]:
            bDuplas = []
            
            for i in range(len(caminhoB[:-1])):
                bDuplas.append((caminhoB[i], caminhoB[i+1]))

            if comp(visitados, bDuplas) == False:
                disjuntos.append(caminhoB)
                visitados.extend(bDuplas)

        if len(disjuntos) == n:
            with open(cam_dis, 'w') as f:
                for i in disjuntos:
                    f.write(str(i) + "\n")
            return disjuntos


    print("acharCaminhos num: ", len(disjuntos))
    
    return []

# Executa o método de Edmonds-Karp para encontrar o fluxo-máximo do grafo
# Considerando a capacidade de cada aresta como 1, o fluxo-máximo é igual
# ao número máximo de caminhos disjuntos. Ao fim da função, passamos para 
# o método acharCaminho um subgrafo com apenas as arestas que possuem algum 
# fluxo passando por elas, o que reduz a complexidade do código em um grau 
# de magnitude
def caminhosDisjuntos(origem, destino, g, cam_dis):
    grafo = copy.deepcopy(g)
    pai = [-1] * len(grafo)
    fluxo_maximo = 0
    while (buscaLargura(origem, destino, grafo, pai)):
        fluxo_caminho = float("Inf")
        v = destino
        while (v != origem):
            fluxo_caminho = min(fluxo_caminho, grafo[pai[v]][v])
            v = pai[v]

        fluxo_maximo += fluxo_caminho
        v = destino

        while (v != origem):
            u = pai[v]
            grafo[u][v] -= fluxo_caminho
            grafo[v][u] += fluxo_caminho
            v = pai[v]

    dif = difMatriz(g, grafo)

    acharCaminhos(origem, destino, dif, fluxo_maximo, cam_dis)
    
    return fluxo_maximo
        
# Lê um arquivo e retorna a matriz de adjacência
def getGrafo(arq):
    data = []
    file = open(arq, "r")

    data = [l for l in file.readlines()]
    for i in range(len(data)):
        data[i] = [eval(k) for k in data[i][:-1]]

    file.close()
    return data

# Imprime um grafo no console
def printGrafo(grafo):
    for i in grafo:
        for j in i:
            print(j, end=" ")

        print("")

# Compara dois grafos, mantendo uma aresta
def difMatriz(grafo, fluxo):
    g = copy.deepcopy(grafo)
    for i in range(len(g)):
        for j in range(len(g[i])):
            if (fluxo[i][j] != 0):
                g[i][j] = 0
    
    return g

# Gera um grafo direciona cíclico de n vértices
def gerarGrafoCiclico(n):
    grafo = []
    for i in range(n):
        grafo.append([0] * n)
        grafo[i][(i+1)%n] = 1

    return grafo

# Gera um grafo completo de n vértices
def gerarGrafoCompleto(n):
    return grafoAleatorio(n, 1)

# NÚMERO DE VÉRTICES
v = 10

n = len(sys.argv)
if (n > 0):
    v = sys.argv[0]
    # if (n > 1):

# Parsing dos argumentos inline
# UTILIZAÇÃO

# -prob [float]: Probabilidade que dois vértices tenham uma aresta em comum 
# (Utilizado na geração de grafos aleatórios)
# Caso não seja utilizado a probabilidade será 0.3
# Exemplo: -prob 0.1

# -arq [string]: Diretório de um arquivo txt com a matriz de adjacência de um grafo
# Exemplo: -arq "./grafos cíclicos/50.txt"

# -ver [int]: Número de vértices a ser usado na geração de grafo
# Caso não seja utilizado o número de vértices será 10
# Exemplo: -ver 100

# -ori [int]: Vértice de origem
# Caso não seja utilizado, o vértice de origem será 0
# Exemplo: -ori 1

# -des [int]: Vértice de destino
# Caso não seja utilizado, o vértice de destino será n - 1
# Exemplo: -des 9

# -cam [string]: Diretório para salvar os caminhos disjuntos encontrados
# Caso não seja utilizado, os caminhos serão salvos em "./disjuntos.txt"
# Exemplo: -cam "./out/caminhos_disjuntos.txt"

# -w [string]: Diretório para salvar o grafo gerado
# Caso não seja utilizado o grafo gerado não será salvo
# Exemplo: -w "./grafos simples/50.txt"

# -ciclo: Gera um grafo cíclico

# -completo: Gera um grafo completo
parser = argparse.ArgumentParser()
parser.add_argument("-prob", "--probabilidade", help="Probabilidade de dois vértices quaisquer serem conectados por uma aresta")
parser.add_argument("-arq", "--arquivo", help="Diretório para um grafo")
parser.add_argument("-ver", "--vertices", help="Número de vértices")
parser.add_argument("-ori", "--origem", help="Vértice de origem")
parser.add_argument("-des", "--destino", help="Vértice de destino")
parser.add_argument("-cam", "--cam_dir", help="Diretório para salvar os caminhos disjuntos encontrados")
parser.add_argument("-w", "--salvar_dest", help="Diretório para salvar")
parser.add_argument("-ciclo", action='store', nargs='*')
parser.add_argument("-completo", action='store', nargs='*')
args = parser.parse_args()

v = 10
p = 0.3
grafo = []
cam_dir = "./disjuntos.txt"
origem = 0
destino = v - 1

if (args.vertices != None):
    v = int(args.vertices)

if (args.probabilidade != None):
    p = float(args.probabilidade)

if (args.ciclo != None or args.completo != None):
    if (args.ciclo != None):
        grafo = gerarGrafoCiclico(v)
    else:
        grafo = gerarGrafoCompleto(v)
elif (args.arquivo != None):
    grafo = getGrafo(args.arquivo)
    v = len(grafo)
else:
    grafo = grafoAleatorio(v, p)

if (args.cam_dir != None):
    cam_dir = args.cam_dir

if (args.salvar_dest != None):
    salvarGrafo(grafo, args.salvar_dest)

if (args.origem != None):
    origem = int(args.origem)
    if origem < 0:
        print("Erro: vértice de origem inválido. Use um vértice com índice maior ou igual a 0")
        origem = 0

if (args.destino != None):
    destino = int(args.destino)
    if destino > v - 1:
        print("Erro: vértice de destino inválido. Use um vértice com valor menor ou igual a ", v-1)
        destino = v - 1

numCaminhosDisjuntos = caminhosDisjuntos(origem, destino, grafo, cam_dir)
print("Número de caminhos: ", numCaminhosDisjuntos)

end = time.time()
print("Tempo de execucação: ", (end - start) * 10**3, "ms")
with open(cam_dir, "a") as f:
    f.write("Número de caminhos: " + str(numCaminhosDisjuntos) + "\n")
    f.write("Tempo de execucação: " + str((end - start) * 10**3) +  "ms\n")
