#!/bin/sh
set -e
NUM_TESTS=$(ls input | sort -V | tail -1 | grep -o '[0-9]\+')

ensure_solution () {
	case $1 in
		*.java) printf "cd solutions; java $(javac -verbose $1 2>&1| tail -2 | head -1 | sed 's#.*solutions/\(.*\)\.class.*#\1#')";;
		*.c) gcc $solution -o solutions/solution; printf "solutions/solution";;
		*) printf "%s" "$1";;
	esac
}

for solution in solutions/solution.*; do
	solution="$(ensure_solution $solution)"
	echo "trying solution $solution"
	for i in $(seq 0 $NUM_TESTS); do
		[ "$(cat output/output$i.txt)" = "$(eval "$solution" < input/input$i.txt)" ] || {
			echo failed on test $i
			exit 1
		}
	done
done
echo success
