import random
import copy
import time
import sys
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures

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
def acharCaminhos(origem, destino, grafo, n):
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
            return disjuntos
    
    return []

# Executa o método de Edmonds-Karp para encontrar o fluxo-máximo do grafo
# Considerando a capacidade de cada aresta como 1, o fluxo-máximo é igual
# ao número máximo de caminhos disjuntos. Ao fim da função, passamos para 
# o método acharCaminho um subgrafo com apenas as arestas que possuem algum 
# fluxo passando por elas, o que reduz a complexidade do código em um grau 
# de magnitude
def caminhosDisjuntos(origem, destino, g):
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

    acharCaminhos(origem, destino, dif, fluxo_maximo)
    
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

origem = 0
destino = v - 1

num_vertices = []
tempo_exec = []
for i in range(10, 1000, 10):
    num_vertices.append(i)
    startTime = time.time()
    grafo = grafoAleatorio(i, 0.5)
    caminhosDisjuntos(origem, destino, grafo)
    endTime = time.time()
    tempo_exec.append((endTime - startTime) * 10**3) # ms

with open("vertices.txt", "w") as file:
    for i in num_vertices:
        file.write(str(i) + '\n')

with open("tempo_exec.txt", "w") as file:
    for i in tempo_exec:
        file.write(str(i) + '\n')

plt.scatter(num_vertices, tempo_exec)
plt.savefig("complexidade.png")

x = np.array(num_vertices).reshape((-1, 1))
y = np.array(tempo_exec)

transformer = PolynomialFeatures(degree=2, include_bias=False)
transformer.fit(x)

x_ = transformer.transform(x)
model = LinearRegression().fit(x_, y)

r_sq = model.score(x_, y)
print("R^2: ", r_sq)

print("Coeficientes: ", model.coef_)


end = time.time()
print("Tempo de execucação: ", (end - start) * 10**3, "ms")
