import random
import time
import sys

sys.setrecursionlimit(16000)


from collections import defaultdict


class Grafo:
  
    def __init__(self,vertices):

        self.V= vertices
         
        self.grafo = defaultdict(list)
         
        self.Time = 0

    def AddAresta(self,u,v):
        self.grafo[u].append(v)
        self.grafo[v].append(u)

    def SCCUtil(self,u, low, disc, stackMember, st):
 
        disc[u] = self.Time
        low[u] = self.Time
        self.Time += 1
        stackMember[u] = True
        st.append(u)

        for v in self.grafo[u]:
             
            if disc[v] == -1 :
             
                self.SCCUtil(v, low, disc, stackMember, st)
 
                low[u] = min(low[u], low[v])
                         
            elif stackMember[v] == True:
 

                low[u] = min(low[u], disc[v])
 
        w = -1 
        if low[u] == disc[u]:
            while w != u:
                w = st.pop()
                print (w, end=" ")
                stackMember[w] = False
                 
            print()
             
     
    def SCC(self):

        disc = [-1] * (self.V)
        low = [-1] * (self.V)
        stackMember = [False] * (self.V)
        st =[]
         
        for i in range(self.V):
            if disc[i] == -1:
                self.SCCUtil(i, low, disc, stackMember, st)
 
    def rmvEdge(self, u, v):
        for index, key in enumerate(self.grafo[u]):
            if key == v:
                self.grafo[u].pop(index)
        for index, key in enumerate(self.grafo[v]):
            if key == u:
                self.grafo[v].pop(index)

    def DFSCount(self, v, visited):
        count = 1
        visited[v] = True
        for i in self.grafo[v]:
            if visited[i] == False:
                count = count + self.DFSCount(i, visited)        
        return count
 
    def isValidNextEdge(self, u, v):

        if len(self.grafo[u]) == 1:
            return True
        else:
 
            visited =[False]*(self.V)
            count1 = self.DFSCount(u, visited)

            self.rmvEdge(u, v)
            visited =[False]*(self.V)
            count2 = self.DFSCount(u, visited)
 

            self.AddAresta(u,v)
 
            return False if count1 > count2 else True
 

    def printEulerUtil(self, u):
        for v in self.grafo[u]:
            if self.isValidNextEdge(u, v):
                # print("%d-%d " %(u,v)),
                self.rmvEdge(u, v)
                self.printEulerUtil(v)
 
 
     

    def printEulerTour(self):
        u = 0
        for i in range(self.V):
            if len(self.grafo[i]) %2 != 0 :
                u = i
                break
        print ("\n")
        self.printEulerUtil(u)


    # def gerarGrafoAleatorio(n):

    def bridgeUtil(self,u, visited, parent, low, disc):
 
        # Mark the current node as visited and print it
        visited[u]= True
 
        # Initialize discovery time and low value
        disc[u] = self.Time
        low[u] = self.Time
        self.Time += 1
 
        #Recur for all the vertices adjacent to this vertex
        for v in self.grafo[u]:
            # If v is not visited yet, then make it a child of u
            # in DFS tree and recur for it
            if visited[v] == False :
                parent[v] = u
                self.bridgeUtil(v, visited, parent, low, disc)
 
                # Check if the subtree rooted with v has a connection to
                # one of the ancestors of u
                low[u] = min(low[u], low[v])
 
 

                if low[v] > disc[u]:
                    print ("%d %d" %(u,v))
     
                     
            elif v != parent[u]: # Update low value of u for parent function calls.
                low[u] = min(low[u], disc[v])
 

    def bridge(self):

        visited = [False] * (self.V)
        disc = [float("Inf")] * (self.V)
        low = [float("Inf")] * (self.V)
        parent = [-1] * (self.V)
 
        for i in range(self.V):
            if visited[i] == False:
                self.bridgeUtil(i, visited, parent, low, disc)


    def randomGrafo(self):

        n = self.V

        array = []


        for x in range(0, n - 1):
            repetitions = random.randint(1, n - 2)
            for y in range(0, repetitions):
                point = random.randint(x+1, n - 1)
                if point not in array:
                    self.AddAresta(x, point)
                    array.append(point)
            array.clear()



start_time = time.time()


g1 = Grafo(100)

g1.randomGrafo()
print("PÓS RANDOMGRAPH() ", time.time() - start_time)
g1.bridge()
print("PÓS BRIDGE() ", time.time() - start_time)
g1.printEulerTour()
print("PÓS PRINTEULERTOUR() ", time.time() - start_time)
end_time = time.time()
final_time = end_time - start_time
print(final_time)


