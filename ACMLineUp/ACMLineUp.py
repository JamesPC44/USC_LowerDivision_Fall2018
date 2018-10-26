from sys import stdin
from math import ceil
from operator import add
from functools import reduce
from itertools import zip_longest

lines = int(input())
people = reduce(add, (list(map(int, line.split())) for line in stdin))
sqrt = ceil(len(people) ** .5)

# https://stackoverflow.com/a/32927045
def grouper(iterable, n, fillvalue=0):
    "Collect data into fixed-length chunks or blocks"
    # grouper('ABCDEFG', 3, 'x') --> ABC DEF Gxx
    args = [iter(iterable)] * n
    return zip_longest(fillvalue=fillvalue, *args)

a = 0
for line in grouper(people, sqrt):
    if a % 2:
        line = reversed(line)
    print(','.join(map(str, line)) + ',')
    a += 1
if a < sqrt:
    print('0,' * sqrt)#!/usr/bin/env python3
