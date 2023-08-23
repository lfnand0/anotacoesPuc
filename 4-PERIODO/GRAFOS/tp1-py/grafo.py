import random
import time
from collections import defaultdict

class Grafo:
    # Formato: 
    # { 
    #   0 : [1, 2],
    #   1 : [3, 4],
    #   2 : [0],
    #   3 : [1, 4],
    #   4 : [1, 3]
    # }
    def __init__(self, n : int) :
        self.adj = defaultdict(list)
        self.n = n
    
    def AddAresta(self, src : int, dst : int) :
        self.adj[src].append(dst)
        self.adj[dst].append(src)

    def PrintLista(self) :
        for x in self.adj.items() :
            print(x)

            
        

def main() :
    vertices = 10

    g = Grafo(vertices)


