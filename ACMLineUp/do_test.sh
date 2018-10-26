#!/bin/sh

BASE="$(dirname "$0")"
cd "$BASE"
TESTCASES="input"

rm *.class
javac ACMLineUp.java

do_test() {
	echo running test language "$1"
	for testcase in "$TESTCASES"/input*.txt ; do
			printf "Running test $(basename "$testcase")... "
			RESULT_FILE="/tmp/$(uuidgen)"
			ERR="$($1 < "$testcase" 1> "$RESULT_FILE") 2>&1"
			DIFF="$(diff "output/$(basename "$testcase" | sed 's/input/output/')" "$RESULT_FILE")"
			if [ "$(echo "$DIFF" | wc -l)" != "1" ] ; then
					echo "FAIL"
					echo "Difference between output and expected: "
					echo "$DIFF" | while read -r ln ; do
							printf "\t$ln"
					done
					echo ""
			else
					echo "PASSED"
			fi
			rm -f "$RESULT_FILE"
	done
}

do_test 'java ACMLineUp'
do_test 'python ACMLineUp.py'
