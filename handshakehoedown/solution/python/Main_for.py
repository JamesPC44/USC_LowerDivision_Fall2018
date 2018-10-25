#!/usr/bin/python3

def printGrid(g):
  for i in r:
    print(i)


n = int(input())
p = int(input())
q = int(input())
r_size = int(input())
r_in = str(input())
# Break the string up into segments for the grid. 
r = [r_in[i * p:(i + 1) * p if (i + 1) * p < len(r_in) else len(r_in)] for i in range(0, q)]

#print(n)
#printGrid(r)

hR = 0
hC = 0

found = False
# There is always an H
# Also, python doesn't break out of all loops on "break", which is stupid.
for i in range(0, q):
  hR = i
  tmp = r[i]
  for j in range(0, p):
    hC = j
    if j >= len(tmp):
      print("BAD VAL:" + str(j) + " MAX:" + str(len(tmp)) + " STR:" + tmp)
      break
    if tmp[j] == "H":
      found = True
      break
  if found:
    break

r_min = hR - n
r_max = hR + n
c_min = hC - n
c_max = hC + n

if r_min < 0:
  r_min = 0
if c_min < 0:
  c_min = 0
if r_max >= q:
  r_max = q - 1
if c_max >= p:
  c_max = p - 1
  
people = 0

for i in range(r_min, r_max + 1):
  people += r[i][c_min:c_max + 1].count("P")
  
print(people)
