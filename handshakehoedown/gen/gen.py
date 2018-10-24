#!/usr/bin/python3
# This is the Generator to the Harry's Handshake Hoedown Fall 2018 Code-a-thon Problem.

import random as rand
import math
import sys

MIN = 5
MAX = int(math.sqrt(2147483647)) #Max Int :)
POSSIBLE = ["_", "P", "S"]

# Generate the List
def genList(size):
  #print("Size: " + str(size))
  toRet = ""
  h = rand.randint(0, size)
  for i in range(0, size):
    if i == h:
      toRet += "H"
    else:
      sel = rand.randint(0, len(POSSIBLE) - 1)
      #print("Chose: " + str(sel))
      toRet += POSSIBLE[sel]
  return toRet
  
# Parse Arguments
def parseArgs():
  min = MIN
  max = MAX
  if len(sys.argv) < 2: return (MIN, MAX)
  getVal = False
  valAssign = 0 # Min = 0, Max = 1
  for arg in sys.argv:
    if arg == "-min":
      # Specify Min
      getVal = True
      valAssign = 0
    if arg == "-max":
      # Specify Max
      getVal = True
      valAssign = 1
    if getVal and arg.isdigit():
      # Set the Value
      getVal = False
      if valAssign == 0:
        min = int(arg)
      elif valAssign == 1:
        max = int(arg)
  return (min, max)

def main():
  (local_min, local_max) = parseArgs()
  rand.seed()
  p = rand.randint(local_min, local_max)
  q = rand.randint(local_min, local_max)
  n = rand.randint((p//2) if p < q else (q//2), p if p > q else q) # Pick a number between
  r = genList(rand.randint(p if p > q else q, p * q))
  
  print(n)
  print(p)
  print(q)
  print(len(r))
  print(r)
  
main()
