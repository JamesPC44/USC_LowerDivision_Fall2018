# Harry's Handshake Hoedown

## Background

Harry has decided to go to an event to meet new people. However, this event, as it is quite popular, is very crowded. What's special about this event is that all attendees are required to form up into a grid. After this all of the guests begin to socialize, but are required to stay in place in the grid. Did I mention that Harry has *N* length arms? Also, some people are sick, and so they will not shake hands out of politeness. For the sake of simplicity, let's assume that Harry can stretch his arms out slightly and will thus be able to shake the hands of people in a given block (See Below in Examples). Also, sometimes people will leave spaces between themselves and the person next to them. 

## What you will write

You will write a program to count the number of people's hands (Harry will only be shaking one hand per person) that he will shake and print the number to the standard output, given the length of his hands and a line of people, as well as the grid size.

## Input

*N*
*P*
*Q*
*R*
*{R1, R2, ..., Rn}*

### Where: 

*N* = Length of Harry's Arms.
*P* = Columns of the Grid
*Q* = Rows of the Grid
*R* = The Number of people that are in line
*R1* ... *Rn* = Each person in line. These will be of the following Characters: {"_", "P", "S", "H"}
  Where "_" is an empty spot, "P" is a Person, "S" is a Sick Person, and "H" is Harry (there will only ever be 1 "H").

## Output

You will print the number of hands that Harry will shake. If there are extra spaces in the grid at the end, represent them as "_". They are empty Spaces.

## Examples

### 1
```
3
5
5
12
H_PPPP___PSP
```
This will output `4`.

### 2
```
6
9
6
30
_S_SP__PSS_SPSPPPPS_P_SHSS_P__
```
This will output `9`.
