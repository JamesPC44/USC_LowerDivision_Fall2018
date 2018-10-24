#!/usr/bin/env python

from random import random

morse = {
 '/': '-..-.',
 '0': '-----',
 '1': '.----',
 '2': '..---',
 '3': '...--',
 '4': '....-',
 '5': '.....',
 '6': '-....',
 '7': '--...',
 '8': '---..',
 '9': '----.',
 ':': '---...',

 '?': '..--..',
 '@': '.--.-.',
 'A': '.-',
 'B': '-...',
 'C': '-.-.',
 'D': '-..',
 'E': '.',
 'F': '..-.',
 'G': '--.',
 'H': '....',
 'I': '..',
 'J': '.---',
 'K': '-.-',
 'L': '.-..',
 'M': '--',
 'N': '-.',
 'O': '---',
 'P': '.--.',
 'Q': '--.-',
 'R': '.-.',
 'S': '...',
 'T': '-',
 'U': '..-',
 'V': '...-',
 'W': '.--',
 'X': '-..-',
 'Y': '-.--',
 'Z': '--..',
}

def randrange(low, high):
    # the default implementation is horribly slow
    return low + int(random() * (high - low))

def gen_character():
    gen_character.a += 1
    if gen_character.a % 2:
        return chr(randrange(ord('?'), ord('Z')))
    else:
        return chr(randrange(ord('/'), ord(':')))

gen_character.a = 0

def gen_line():
    return ' '.join(morse[gen_character()] for _ in range(randrange(1, 2**8)))

def main():
    return '\n'.join(gen_line() for _ in range(randrange(1, 2**12)))

if __name__ == '__main__':
    print(main())
