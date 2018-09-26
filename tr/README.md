# String Manipulator

You have a lot of data on the grades for Fall 2017!
Unfortunately, the grades are very messy. Some of them
are lowercase, some uppercase. Some are mistyped. Others
have been ROT13 encoded for security.

Your job is to clean up the data so it can be analyzed.

## Input Format

The first line will contain an input pattern as specified below.
The second line will contain an output pattern in the same format.
The third line will contain a number $n$ between 1 and 2^16 - 1.
There will be $n$ following lines, each of which may contain arbitrary
ASCII text in the 32-127 range (no control characters).

Patterns takes the following form:

```
pattern: { characters | set } pattern | '';
characters: character characters | '';
character: '!' | '"' | '#' | '$' | '%' | '&' | ''' | '(' | ')' | '*' | '+' | ',' | '-' | '.' | '/' | '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' | ':' | ';' | '<' | '=' | '>' | '?' | '@' | 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' | '[' | '\' | ']' | '^' | '_' | '`' | 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' | '{' | '|' | '}' | '~';
set: '[' character '-' character ']';
```

## Constraints

Both patterns will have the same length (once sets are expanded).
The first character in a set will always come before the second in ASCII order.
You do not have to do error checking.

Patterns will have length <= 2^16 - 1.
Each following line will have length <= 2^16 - 1.

## Output Format

For each character in the first pattern, change it to the corresponding
character in the second pattern. Treat sets as shorthand for typing that
ASCII range.

## Examples

To translate upper-case to lower-case:
Input:
5
[A-Z]
[a-z]
HELLO
THIS
IS
AN
EXAMPLE

Output:
hello
this
is
an
example

To make no change to a string:
Input:
5


HELLO
THIS
IS
AN
EXAMPLE

Output:
HELLO
THIS
IS
AN
EXAMPLE

To change all occurrences of 'z' to 'a':
Input:
3
z
a
bzz bzz blzck sheep
hzd z bzd dzy
bzllroom

Output:
baa baa black sheep
had a bad day
ballroom

Combine sets and characters:
Input:
[a-c]
def
3
cab
combine
cattle

Output:
fae
fomdine
fdttle
