# Integrantes:
# Gabriel Sebe Lucchesi Barbosa
# Guilherme Vedovelo de Britto Claro
# Luiz Fernando Oliveira Maciel

import pygame
import math

background_color = (0,0,0)  
store_number = -1

trunk = [] # Variavel que indica as encomendas retiradas pelo caminhão

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




pygame.init()

file_path = "output.txt"  # Caminho do arquivo com soluções encontradas pelo algoritmo
smallest_number = float('inf')
smallest_number_list = []

with open(file_path, "r") as file:
    lines = file.readlines()
    for i in range(0, len(lines), 2):
        number = float(lines[i].strip())
        number_list = eval(lines[i + 1])

        if number < smallest_number:
            smallest_number = number
            smallest_number_list = number_list

        
list = []

stores = getStoresFromFile("lojas2.txt")
stores = [store for store in stores]


for i in range (0, len(smallest_number_list)):
    list.append(stores[smallest_number_list[i]])



# Tamanho do Tiles e da tela
tile_size = 40  
map_width = 800
map_height = 600

# Dimensão de cada tile
num_tiles_x = map_width // tile_size
num_tiles_y = map_height // tile_size

# Carregar imagem de fundo
background_image = pygame.image.load("images/background.png") 
background_image = pygame.transform.scale(background_image, (map_width, map_height))

# Define coordenadas de cada loja
object_coordinates = [(obj.x, obj.y) for obj in list]


# Carrega PNG do caminhão
truck_image = pygame.image.load("images/truck.png") 
truck_image = pygame.transform.scale(truck_image, (tile_size // 2, tile_size // 2)) 

# Carrega PNG da loja
store_image = pygame.image.load("images/store.png")  
store_image = pygame.transform.scale(store_image, (tile_size // 2, tile_size // 2)) 


overlay_color = (0, 0, 0, 128) 
number_color = (255, 255, 255)  
number_font = pygame.font.SysFont(None, 26)  
number_variable = -1  # Contador de numero de lojas

truck_speed = 0.1  # Define velocidade do caminhão


stop_duration = 1200  # Intervalo em que caminhão fica parado em cada loja (definido em frames)


screen = pygame.display.set_mode((map_width, map_height))

# Looping principal
running = True
current_store = 0

if number_variable >= ((len(object_coordinates)) / 2) - 1: # Checa se última loja ja foi alcançada
    stop_timer = stop_duration
    pygame.quit()


truck_x, truck_y = object_coordinates[current_store]
stop_timer = 0

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    if stop_timer > 0: #Timer para produzir intervalos no trajeto do caminhão

        stop_timer -= 1
    else:
        # Calcula distância entre caminhão e proxima loja
        dx = object_coordinates[current_store][0] - truck_x
        dy = object_coordinates[current_store][1] - truck_y
        distance = math.sqrt(dx * dx + dy * dy)

        # Normaliza o vetor de movimento
        if distance != 0:
            velocity_x = dx / distance
            velocity_y = dy / distance
        else:
            velocity_x = 0
            velocity_y = 0

        # Atualiza a posição do caminhão a cada frame
        truck_x += velocity_x * truck_speed
        truck_y += velocity_y * truck_speed

     


        if distance <= truck_speed: #Checa se caminhão chegou em uma loja
  
            stop_timer = stop_duration # Timer de intervalo

            number_variable += 1  

            store_number = list[number_variable].id # Atualiza numero de ultima loja que o caminhão passou

            for store in stores:
                if store.id == store_number:
                    for element in store.shipsTo: # Adiciona encomendas ao porta-malas se houverem
                        trunk.append(element)

            if store_number in trunk:
                trunk.remove(store_number) # Tira encomendas do porta-malas se houverem encomendas a serem entregues

                



            # Renderiza contador mostrando número de loja que o caminhão passou por ultimo
            number_surface = number_font.render(str("Loja: " + str(store_number)), True, number_color)
            number_rect = number_surface.get_rect()
            number_rect.topleft = (map_width - 180, 20)

            screen.blit(number_surface, number_rect)


            # Renderiza contador mostrando encomendas retiradas pelo caminhão
            number_surface2 = number_font.render(str("Ecomendas: " + str(trunk)), True, number_color)
            number_rect2 = number_surface2.get_rect()
            number_rect2.topleft = (map_width - 180, 20 + number_rect.height)  

            screen.blit(number_surface2, number_rect2)

            current_store = (current_store + 1) 

    # Posiciona a imagem de fundo
    screen.blit(background_image, (0, 0))

    # Posiciona o PNG das lojas
    for store_x, store_y in object_coordinates:
        screen.blit(store_image, (store_x, store_y))

    # Posiciona o caminhão
    screen.blit(truck_image, (truck_x, truck_y))

    # Desenha o overlay no canto superior direito
    pygame.draw.rect(screen, overlay_color, (map_width - 200, 0, 200, 80))

    # Renderiza contador mostrando número de loja que o caminhão passou por ultimo
    number_surface = number_font.render(str("Loja: " + str(store_number)), True, number_color)
    number_rect = number_surface.get_rect()
    number_rect.topleft = (map_width - 180, 20)
    screen.blit(number_surface, number_rect)

    
    # Renderiza contador mostrando encomendas retiradas pelo caminhão
    number_surface2 = number_font.render(str("Ecomendas: " + str(trunk)), True, number_color)
    number_rect2 = number_surface2.get_rect()
    number_rect2.topleft = (map_width - 180, 20 + number_rect.height)  

    screen.blit(number_surface2, number_rect2)

    # Update do display
    pygame.display.flip()

# Encerra o jogo
pygame.quit()
 