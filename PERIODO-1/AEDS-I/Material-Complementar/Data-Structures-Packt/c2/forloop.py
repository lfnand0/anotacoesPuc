import time
time.time()
timestampAmount = 0
timestampAvg = 0

n = 1000000
for value in range(1, n + 1):
  timestamp1 = time.time()
  ### Python Program to find Sum of N Natural Numbers ###
  number = 100
  total = 0
  for value in range(1, number + 1):
    total = total + value
  ### Program Completed ###
  timestamp2 = time.time()
  timestampAmount += 1
  timestampAvg = timestampAvg + (timestamp2 - timestamp1)

timestampAvg = timestampAvg/timestampAmount
print("The average is", timestampAvg)