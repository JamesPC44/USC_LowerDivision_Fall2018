
Ever since you signed up for the October hackathon with ACM, you’ve had a spooky feeling that Halloween wasn’t going to be the same this year. While at last weeks meeting, you stumbled across an old file that had somehow gotten onto your computer. You decide to read the spooky.txt file.

Sir, these files contain the number of soldiers who were infected with the B-12 virus in the past 100 years. For each file I have indicated the number of lines contained. On each line I have written the year and the number of infected. I went ahead and encoded them using our cold war system.

Luckily, ACM has been able to decipher their numbering system. Your job is to transcribe the data, and let us know the sum of how many soldiers were infected between (x,y) years. 

C = 1
O = 5
L = 10
D = 50
W = 100
A = 500
R = 1000

Format of input:
n
t a
t a
t a
x y

Where n is the number of inputs, t is the number infected, and a is the year
x is the first year, and y is the last year for in which need to be summed

Constraints: 
0 <= n <= 100
0 <= t <= 1,000,000
0 < a <= 1,000,000

A sample input:
OC
OCD DOC
RAW DCA
ORC LDW
OCA CRL

Input: 
N sets (year,deaths)
Sum (YearOne, YearTwo)

Output:
Converted N sets (Year,deaths)
Total deaths between (yearOne,yearTwo)













