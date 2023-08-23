# Integrantes:
# Gabriel Sebe Lucchesi Barbosa
# Guilherme Vedovelo de Britto Claro
# Luiz Fernando Oliveira Maciel

import time
import math
import copy
import sys

lowerbound = sys.maxsize


# Armazena uma loja
class Store:
    def __init__(self, id, x, y, shipsTo, disabled):
        self.id = id
        self.x = x
        self.y = y
        self.shipsTo = shipsTo
        self.disabled = disabled

    def __copy__(self):
        new_obj = Store(self.id, self.x, self.y, self.shipsTo, self.disabled)
        return new_obj


# Lê as informações em uma linha e retorna um objeto Store
def getInfoFromLine(line):
    arr = line.rstrip().split(" ")
    id = int(arr[0])
    x = int(arr[1])
    y = int(arr[2])
    shipsTo = []

    if len(arr) > 3:
        for i in range(3, len(arr)):
            shipsTo.append(int(arr[i]))

    if len(shipsTo) == 0:
        return Store(id, x, y, [], 0)
    else:
        return Store(id, x, y, shipsTo, 0)


# Lê todas as linhas de um arquivo e retorna uma lista com as lojas
def getStoresFromFile(fileName):
    f = open(fileName, "r")
    lines = f.readlines()

    stores = []
    for line in lines:
        stores.append(getInfoFromLine(line))
    return stores


def getLowerBound(stores, cost, current, valid):
    minDistance = sys.maxsize
    for i in valid:
        if i != current:
            distance = calcDistance(stores[current], stores[i])
            if distance < minDistance:
                minDistance = distance
    return cost + (minDistance / 10.0)


# Calcula a distância entre duas lojas
def calcDistance(obj1, obj2):
    return math.sqrt((obj2.x - obj1.x) ** 2 + (obj2.y - obj1.y) ** 2)


# Chamada inicial do algoritmo
def travel(stores):
    invalid = [items for store in stores for items in store.shipsTo]
    all = [store.id for store in stores]
    valid = [x for x in all if x not in invalid]
    path = []
    trunk = []
    gasCost = 0
    limitWeight = 4
    travelUtil(stores, valid, 0, path, limitWeight, trunk, gasCost)


# Algoritmo recursivo
# Parâmetros:
## stores: Lista que contém todas os objetos tipo Loja, contendo coordenadas x, y e id
## valid: Lista que contém, para cada iteração da recursividade, a lista de movimentos válidos que o caminhão pode escolher
## current: Variável que indica em qual loja o caminhão atualmente está
## path: Lista que guarda todas as lojas anteriores que o caminhão visitou
## cargo: Quantidade de pacotes máxima que o caminhão pode levar por vez
## trunk: Lista que guarda todos os pacotes que estão atualmente sendo transportados pelo caminhão
## gasCost: Variável que guarda o total de gasolina consumida pelo caminhão durante seu percurso
def travelUtil(stores, valid, current, path, cargo, trunk, gasCost):
    global lowerbound
    global iterations
    iterations += 1
    lb = 0

    path_copy = path[:]
    trunk_copy = trunk[:]
    gasCost_copy = gasCost
    cargo_copy = cargo
    stores_copy = [copy.copy(obj) for obj in stores]
    path_copy.append(current)
    valid_copy = valid[:]
    valid_copy.remove(current)

    for store in stores_copy:  # Recebimento de pacotes
        if store.id == current:
            for element in store.shipsTo:
                cargo_copy -= 1
                trunk_copy.append(element)
                valid_copy.append(element)

    if current in trunk_copy:  # Entrega de pacotes
        trunk_copy.remove(current)
        cargo_copy += 1

    for store in stores_copy:
        if (
            (cargo_copy - len(store.shipsTo) >= 0)
            or (cargo_copy - len(store.shipsTo) + 1 >= 0 and store.id in trunk_copy)
        ) and store.disabled == True:
            valid_copy.append(store.id)
            store.disabled = False

        if (
            (cargo_copy - len(store.shipsTo) < 0)
            and (
                (cargo_copy - len(store.shipsTo) + 1 < 0)
                or (store.id not in trunk_copy)
            )
        ) and store.id in valid_copy:
            valid_copy.remove(store.id)
            store.disabled = True

    if len(valid_copy) != 0:
        lb = getLowerBound(stores, gasCost_copy, current, valid_copy)

    if path_copy[len(path_copy) - 1] != 0:
        rough = calcDistance(
            stores_copy[path_copy[len(path_copy) - 2]],
            stores_copy[path_copy[len(path_copy) - 1]],
        )
        gasCost_copy += rough / (10 - (0.5 * len(trunk_copy)))

        if lb > lowerbound:
            return

    if len(valid_copy) == 0:
        path_copy.append(0)
        rough = calcDistance(
            stores_copy[path_copy[len(path_copy) - 2]],
            stores_copy[path_copy[len(path_copy) - 1]],
        )
        gasCost_copy += rough / (10 - (0.5 * len(trunk_copy)))
        with open("output.txt", "a") as file:
            file.write(str(gasCost_copy) + "\n")
            file.write(str(path_copy) + "\n")
        if gasCost_copy < lowerbound:
            lowerbound = gasCost_copy
        return

    for item in valid_copy:
        travelUtil(
            stores_copy,
            valid_copy,
            item,
            path_copy,
            cargo_copy,
            trunk_copy,
            gasCost_copy,
        )


iterations = 0


def main():
    open("output.txt", "w").close()
    stores = getStoresFromFile("lojas2.txt")
    stores = [store for store in stores]

    start = time.time()
    travel(stores)
    end = time.time()
    global iterations

    smallest_number = float("inf")
    smallest_number_list = []

    with open("output.txt", "r") as file:
        lines = file.readlines()
        for i in range(0, len(lines), 2):
            number = float(lines[i].strip())
            number_list = eval(lines[i + 1])

            if number < smallest_number:
                smallest_number = number
                smallest_number_list = number_list
    print(smallest_number_list)
    print(smallest_number)

    print("Número de iterações: ", iterations)
    print("Tempo de execução: ", end - start)


main()
