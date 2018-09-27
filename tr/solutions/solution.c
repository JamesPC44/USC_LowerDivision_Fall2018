#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* normalize_pattern(char* pattern) {
  // include null byte
  int len = strlen(pattern) + 1, current = 0;
  char *result = malloc(sizeof(char) * len);

  // since we modify len during loop, we can't use it to compare to
  for (int i = 0; i < strlen(pattern); i++) {
    if (pattern[i] == '[') {
      char start = pattern[i + 1];
      char end = pattern[i + 3];
      // 5 from set, add one for last character
      len += end - start - 4;
      result = realloc(result, sizeof(char) * len);

      while (start <= end) {
        result[current++] = start++;
      }
      i += 4;
    } else {
      result[current++] = pattern[i];
    }
  }

  result[current] = '\0';
  free(pattern);
  return result;
}

void translate(char *string, const char *input_pattern, const char *output_pattern) {
  const int length = strlen(string);
  for (int current = 0; current < length; current++) {
    char* index = strchr(input_pattern, string[current]);
    if (index != NULL) {
      string[current] = output_pattern[index - input_pattern];
    }
  }
}

int main(void) {
  char *input_pattern = NULL, *output_pattern = NULL;
  unsigned long len = 0;

  getline(&input_pattern, &len, stdin);
  len = 0;  // ask getline to allocate a buffer for us
  getline(&output_pattern, &len, stdin);
  int lines;
  scanf("%d\n", &lines);

  input_pattern = normalize_pattern(input_pattern);
  output_pattern = normalize_pattern(output_pattern);

  char *input = NULL;
  // we reuse the input buffer
  len = 0;
  for (int i = 0; i < lines; i++) {
    getline(&input, &len, stdin);
    translate(input, input_pattern, output_pattern);
    fputs(input, stdout);
  }

  free(input);
  free(input_pattern);
  free(output_pattern);
}
