import random
import bisect
import copy
import numpy as np

def isConexo():
    data = []
    file = open("grafo.txt", "r")
    # Transformar data em um grafo não direcionado

    data = [l.split(' ') for l in file.readlines()]
    for i in range(len(data)):
        data[i] = [eval(k) for k in data[i]]
    
    for i in range(len(data)):
        for j in range(1, len(data[i])):
            if (data[i][0] not in data[data[i][j]]):
                data[data[i][j]].append(data[i][0])

def grafoAleatorio(n, p):
    grafo = [[]]*n
    with open("grafo.txt", "w") as file:
        for i in range(n):
            grafo[i] = [0]*n
            # grafo[i].append(i)
            for j in range(n):
                if (j != i):
                    probability = random.random()
                    if (probability < p):
                        file.write("1")
                        grafo[i][j] = 1
                    else:
                        file.write("0")
                else:
                    file.write("0")
                        
            
            file.write("\n")

    return grafo

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

def comp(l1, l2):
    for i in l1:
        if i in l2:
            return True

    return False

def acharCaminhos(origem, destino, grafo, n):
    visitado = [False] * len(grafo)
    caminho = []
    caminhos = []
    # buscaProfundidade(origem, destino, grafo, visitado, caminho)   
    buscaProfundidade(origem, destino, grafo, visitado, caminho, caminhos)
    
    for caminhoA in caminhos:
        disjuntos = [caminhoA]
        aDuplas = []
        for i in range(len(caminhoA[:-1])):
            aDuplas.append((caminhoA[i], caminhoA[i+1]))
        
        #print("a: ", aDuplas)

        posA = caminhos.index(caminhoA)+1
        #print(posA)

        visitados = copy.deepcopy(aDuplas)
        for caminhoB in caminhos[posA:]:
            bDuplas = []
            #print("b: ", caminhoB)
            for i in range(len(caminhoB[:-1])):
                bDuplas.append((caminhoB[i], caminhoB[i+1]))

            if comp(visitados, bDuplas) == False:
                disjuntos.append(caminhoB)
                visitados.extend(bDuplas)

        if len(disjuntos) == n:
            with open('disjuntos.txt', 'w') as f:
                for i in disjuntos:
                    f.write(str(i) + "\n")
            return disjuntos


    print("acharCaminhos num: ", len(disjuntos))
    

    return []


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
    # printGrafo(grafo)
    # print("^^ residual ----")
    # printGrafo(dif)
    # print("dif ^^^ ----")
    # printGrafo(np.array(grafo).T.tolist())
    # print("^^ transpose ----")

    # acharCaminhos(origem, destino, np.array(grafo).T.tolist(), fluxo_maximo)
    acharCaminhos(origem, destino, dif, fluxo_maximo)
    

    return fluxo_maximo
        
def getGrafo(arq):
    data = []
    file = open(arq, "r")

    data = [l for l in file.readlines()]
    for i in range(len(data)):
        data[i] = [eval(k) for k in data[i][:-1]]

    file.close()
    return data

def printGrafo(grafo):
    for i in grafo:
        for j in i:
            print(j, end=" ")

        print("")

def listaParaMatrizAdj(grafo):
    n = len(grafo)
    matriz = [[0 for j in range(n)]
                 for i in range(n)]
    for i in range(n):
        for j in grafo[i]:
            if (i != j):
                matriz[i][j] = 1
    return matriz

def difMatriz(grafo, fluxo):
    g = copy.deepcopy(grafo)
    for i in range(len(g)):
        for j in range(len(g[i])):
            if (fluxo[i][j] != 0):
                g[i][j] = 0
    
    return g

# NÚMERO DE VÉRTICES
n = 1000

grafo = grafoAleatorio(n, 0.5)
#grafo = getGrafo("grafo.txt")

print("Número de caminhos: ", caminhosDisjuntos(0, n - 1, grafo))
