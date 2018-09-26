IFS='' read -r input;
IFS='' read -r output;
read lines;

remove_brackets () {
	printf '%s' "$1" | sed 's/\[\(.-.\)\]/\1/g'
}

input="$(remove_brackets "$input")"
output="$(remove_brackets "$output")"
tr -- "$input" "$output"
