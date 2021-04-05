num_list = [1, 2, 3, 4, 5, 6, 7] #O(1)

def randomFunction(num_list):
  total = 0 #O(1)

  for num1 in num_list:   #O(n)
    for num2 in num_list: #O(n)
      print(num1 + num2) #O(1)
      total += 1 #O(1)
  
  return total #O(1)

print(randomFunction(num_list))

### O(n * n)
### The loop is nested into another one, which means it'll execute itself n times for each iteration of the parent loop => which is why it's n squared