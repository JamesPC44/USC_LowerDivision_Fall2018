#!/bin/sh
set -e
NUM_TESTS=$(ls input | sort -V | tail -1 | grep -o '[0-9]\+')
for solution in solutions/solution*; do
	for i in $(seq 0 $NUM_TESTS); do
		[ "$(cat output/output$i.txt)" = "$($solution < input/input$i.txt)" ] || {
			echo failed on test $i, solution $solution
			exit 1
		}
	done
done
echo success
