#!/bin/sh

BASE="$(dirname "$0")"

for lang in "$BASE"/* ; do
	if [ ! -d "$lang" ] ; then continue ; fi
	echo "= = = Test For $lang = = ="
	"$lang/do_test.sh"
	echo ""
done
