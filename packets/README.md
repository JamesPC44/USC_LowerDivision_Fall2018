# Packet Precipitation

It was cold and raining. Just another evening in the lab. But this night was
different - were were near a breakthrough. Our first networking protocol. No
more writing FORTRAN to crunch equations for the physics boffins. The year:
'74. My name: Cerf. Vint Cerf. You might know me as one of the "fathers of the
internet". That hasn't happened. Not yet, anyway. This was a big night; my
partner in this operation, Bob Kahn, is about to start shooting packets my way
from the lab across the hall.

Here's the trouble: these packets are gonna come whizzing down that wire faster
than a 1.2kilobaud acoustic coupler in a power surge. Problem is, I don't know
what order old Bob is planning to send me those packets in... always the
maverick he is. Worse still, this old copper wire we ran through the ceiling
tiles has seen better days; sometimes it'll echo a packet a few times,
sometimes it just eats 'em.

If we're planning to do this then, we need to whip up some code in a hurry to
grab these packets off the wire and mash 'em back together in the right order.

# Input Format

You will read an unknown number $N$ of lines. Each line will take the following
format:

$$i n m c k_1 k_2 \dots k_c$$

Where:

* $i$ is the message ID, a real positive integer
* $n$ is the packet number, a real positive integer
* $m$ is the number of packets in message $i$, a real positive integer
* $c$ is the number of words in the message, a real positive integer
* $k_1, k_2, \dots k_c$ are each strings which do not contain whitespace
  characters.

  * Every $k$ will match the regular expression `[-a-zA-Z0-9_]+`

Packets will be delivered in an arbitrary order. Some packets for a given
message ID may be missing. Some packets may be delivered more than once.

You may assume the following bounds:

* $0\leq i \leq 2^{16}$
* $0\leq n \leq 2^{16}$
* $0\leq m \leq 2^{16}$
* $0\leq c \leq 2^{8}$
* $0\leq N \leq 2^{16}$
* The total number of words in a single message will not exceed $2^16$

# Output Format

You will provide the re-constituted message for each message ID, one message
per line. Messages will be output in descending alphabetic order.  Any messages
which are incomplete should be dropped.

# Examples

## Example 1

Input:

```
0 0 2 3 this is an
0 1 2 2 example message
```

Output:

```
this is an example message
```

## Example 2

Input:

```
0 0 1 2 duplicated message
1 0 2 2 incomplete message
0 0 1 2 duplicated message
2 2 3 1 order
2 1 3 1 of
2 0 3 1 out
```

Output:

```
duplicated message
out of order
```
