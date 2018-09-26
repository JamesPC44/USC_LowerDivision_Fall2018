#!/bin/sh
rm -rf input output
./gen_testcase.sh 0 '[A-Z]' '[a-z]'
./gen_testcase.sh 1 'abcd' '[e-h]'
./gen_testcase.sh 2 '[A-Z][a-z]' '[N-Z][A-M][n-z][a-m]'
./gen_testcase.sh 3 '' ''
./gen_testcase.sh 4 '1234' '%^*&'
./gen_testcase.sh 5 '1234' '5678'
./gen_testcase.sh 6 'ABcdEFg' 'abCDefG'
./gen_testcase.sh 7 '1234!@#$' '5678%^&*'
./gen_testcase.sh 8 '[Z-a]' '[a-h]'
./gen_testcase.sh 9 ' ' '\'
./gen_testcase.sh 10 a z
