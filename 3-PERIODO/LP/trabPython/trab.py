def triangulo(a, b, e):
    return(a + b > e and a + e > b and b + e > a)

print(triangulo(1, 2, 3))
print(triangulo(3, 5, 4))
print(triangulo(3, 4, 5))
print(triangulo(10, 2, 3))
print(triangulo(1, 2, 5))

def porcentagem(lista):
    positivos = list(filter(lambda x: x > 0, lista))
    negativos = list(filter(lambda x: x < 0, lista))
    zero = list(filter(lambda x: x == 0, lista))
    return (len(positivos)/len(lista), len(negativos)/len(lista), len(zero)/len(lista))



print(porcentagem([1, 2, 3, 4, -1, -2, -3, 0, 0, 0]))
print(porcentagem([1, 2, 3, 4, -1, -2, -3, 0]))

def kStolfi(i, k):
  soma = 0
  for digito in str(i):
      soma += int(digito)

  return(soma % k == int(str(i)[0]))

print(kStolfi(30, 27))
print(kStolfi(321, 4))
