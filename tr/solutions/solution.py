#!/usr/bin/env python3

class defaultdict(dict):
    # if some character c is not present, return that character
    __missing__ = lambda self, c: c

def normalize_sets(pattern):
    # turn all sets of the form [a-d] into the expanded form abcd
    result = ''
    i = 0
    while i < len(pattern):
        if pattern[i] == '[':
            start = pattern[i + 1]
            # assume i + 2 is '-'
            end = pattern[i + 3]
            for c in range(ord(start), ord(end) + 1):
                result += chr(c)
            i += 5
        else:
            result += pattern[i]
            i += 1
    return result

def translate(string, in_pattern, out_pattern):
    # d maps the input to the output, returning the original if not present
    # zip: https://docs.python.org/3/library/stdtypes.html#typesmapping
    d = defaultdict(zip(normalize_sets(in_pattern), normalize_sets(out_pattern)))
    return ''.join(d[character] for character in string)

def main():
    input_pattern = input()
    output_pattern = input()
    lines = int(input())

    for i in range(lines):
        print(translate(input(), input_pattern, output_pattern))

if __name__ == "__main__":
    main()
