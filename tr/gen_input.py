#!/usr/bin/env python

from random import randrange

def gen_character():
    return chr(randrange(32, 128))

def gen_line():
    return ''.join(gen_character() for _ in range(randrange(1, 2**8 - 1)))

def main():
    return '\n'.join(gen_line() for _ in range(randrange(1, 2**8 - 1)))

if __name__ == '__main__':
    print(main())
