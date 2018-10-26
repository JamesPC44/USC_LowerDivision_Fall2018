from sys import stdin
from collections import defaultdict

def roman_to_int(s):
    roman = {
        'C': 1,
        'O': 5,
        'L': 10,
        'D': 50,
        'W': 100,
        'A': 500,
        'R': 1000
    }
    return sum(roman[c] for c in s)

zones = defaultdict(lambda: 0)

lines = [[roman_to_int(s) for s in line.split()] for line in stdin]
for line in lines[:-1]:
    zones[line[1]] += line[0]

min, max = lines[-1]
print("Total amount of uranium between zones", min, "and", max, "is",
      sum(value for key, value in zones.items() if min <= key <= max))
