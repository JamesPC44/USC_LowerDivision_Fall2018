#!/bin/bash

#N=3
#P=5
#Q=5
#R=12
#RL="H_PPPP___PSP"

if [ $# -ne 5 ]; then
  echo "Incorrect Parameters: {LEN, WID, BS, BD, PH}"
  exit
fi

echo "Testing Solutions..."

N=$1
P=$2
Q=$3
R=$4
RL=$5

echo "Arguments: $N $P $Q $R $RL"

cd java
java Main <<< "$N $P $Q $R $RL" > test.txt
cd ..

cd python
python3 Main.py > test.txt << EOF
$N
$P
$Q
$R
$RL
EOF
 
cd ..

diff java/test.txt python/test.txt


