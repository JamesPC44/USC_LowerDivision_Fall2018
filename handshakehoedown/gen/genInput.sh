#!/bin/bash

# Generates a Single Test Case
if [ $# -lt 2 ]; then
  echo "Usage: <MAX#> <CASE #>"
  exit
fi

MAX=$1
CASE=$2

ARGS=$(./gen.py -max "$MAX")

echo "Case $CASE: $ARGS"

FILE_NUMB="$CASE"
STRLEN=$(echo -n $CASE | wc -m)
if [ $STRLEN -lt 2 ]; then
  FILE_NUMB="0$CASE"
fi

INPUT_FILE="$(pwd)/../testcases/input/input$FILE_NUMB.txt"
OUTPUT_FILE="$(pwd)/../testcases/output/output$FILE_NUMB.txt"

echo "$ARGS" > "$INPUT_FILE"

# Output File
cd ../solution/python/
#./Main.py < $ARGS > "$OUTPUT_FILE"
(echo "$ARGS" | ./Main.py) >"$OUTPUT_FILE"
cd ../../gen

#echo "Current Directory: $(pwd)"

