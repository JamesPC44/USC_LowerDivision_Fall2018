import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Solution {
    final String input_pattern, output_pattern;
    final Map<Character, Character> dict;

    public Solution(String input_pattern, String output_pattern) {
        this.input_pattern = input_pattern;
        this.output_pattern = output_pattern;
        dict = create_dict();
    }

    public static void main(String[] args) {
        final Scanner stdin = new Scanner(System.in);
        final String input_pattern = normalize_pattern(stdin.nextLine());
        final String output_pattern = normalize_pattern(stdin.nextLine());
        final int lines = Integer.parseInt(stdin.nextLine());

        Solution s = new Solution(input_pattern, output_pattern);

        for (int i = 0; i < lines; ++i) {
            System.out.println(s.translate(stdin.nextLine()));
        }
    }

    private static String normalize_pattern(String pattern) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '[') {
                char start = pattern.charAt(i + 1),
                     end = pattern.charAt(i + 3);
                while (start <= end) {
                    result.append(start++);
                }
                i += 4;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private Map<Character, Character> create_dict() {
        Map<Character, Character> result = new HashMap<>();
        if (input_pattern == null || output_pattern == null) {
            throw new IllegalStateException("Must initialize patterns before creating dict");
        }
        for (int i = 0; i < input_pattern.length(); i++) {
            result.put(input_pattern.charAt(i), output_pattern.charAt(i));
        }
        return result;
    }

    public String translate(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (dict.containsKey(c)) {
                result.append(dict.get(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
