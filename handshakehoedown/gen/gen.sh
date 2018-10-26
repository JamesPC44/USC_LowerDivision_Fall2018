#!/bin/bash

# Generates Test Cases Randomly, starting at specified number
# Args: ./gen.sh <#Cases> <#Start=0> <Max Width and Length>
# Note that LEN and WID may be up to 2 higher than the MAX Number

if [ $# -eq 0 ]; then
  echo "Usage: <# Cases> <# Start> <Max Dimenstion>"
  exit
fi

CASES=$1
START=$2
MAX=$3

if [ "$MAX" -lt 5 ]; then
  echo "Warning: MAX Value Should probably be higher"
fi

for i in $(seq $START $CASES); do
  # <MAX> <CASE>
  . genInput.sh "$MAX" $i
done
