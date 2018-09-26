#!/bin/sh
# modified from Charles' generate_testcase.sh
# https://github.com/z2oh/usc_lowerdivision_spring2018/blob/master/image_rotate/testcases/generate_testcase.sh

# make sure we are in the test case directory
cd "$(dirname "$0")"

if [ $# -lt 3 ] ; then
	echo "USAGE: $0 <test case number> <input pattern> <output pattern>"
	exit 1
fi

mkdir -p input output
INPUT_FILE="./input/input$1.txt"
OUTPUT_FILE="./output/output$1.txt"

if [ -e "$INPUT_FILE" ] || [ -e "$OUTPUT_FILE" ]; then
	echo "ERROR: '$INPUT_FILE' or "$OUTPUT_FILE" exists"
	printf "Overwrite? y/[n] "
	read force
	[ "$force" = y ] && rm -f "$INPUT_FILE" "$OUTPUT_FILE" || exit 1
fi

RAND_INPUT="$(./gen_input.py)"
LINES="$(($(echo "$RAND_INPUT" | wc -l)))"
(echo "$2"; echo "$3"; echo "$LINES"; echo "$RAND_INPUT") > "$INPUT_FILE"
solutions/solution.sh < "$INPUT_FILE" > "$OUTPUT_FILE"
