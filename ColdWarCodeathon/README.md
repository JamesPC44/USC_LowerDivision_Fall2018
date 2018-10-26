
Ever since you signed up for the October hackathon with ACM, you’ve had a spooky feeling that Halloween wasn’t going to be the same this year. While at last weeks meeting, you stumbled across an old file that had somehow gotten onto your computer. You decide to read the spooky.txt file. <br>

*These files contain the amount of enriched uranium we have been able to produce. I have indicated the amount, followed by the zone number for each factory. I went ahead and encoded them using our cold war system.* <br>

Luckily, ACM has been able to decipher their numbering system. Your job is to transcribe the data, and let us know the amount of enriched uranium the anonynous suspect claims to have between certain zones. <br>

The numbering system works using string of letters, where the sum of the letters values indicates the strings value.

C = 1 <br>
O = 5 <br>
L = 10 <br>
D = 50 <br>
W = 100 <br>
A = 500 <br>
R = 1000 <br>

COLDWAR = 1666 <br> 

Format of input: <br>
t a <br>
t a <br>
t a <br>
x y <br>

Where t is the amount of uranium, and a is the zone
x is the first zone, and y is the last zone for in which need to be summed

Constraints: <br>
0 <= t <= 1,000,000 <br>
0 < a <= 1,000,000 <br>

A sample input: <br>
~~~~
WORRLD LDC
COLDWAR CCL
WARCOLD DO
RRAW OOC
WAOLRD OOO
WRRAAARR LOC
RWAOLDA LLR
L DC
~~~~
A sample output:
~~~~
Total amount of uranium between zones 10 and 51 is 11531
~~~~













