import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

class solution {
    public static final Map<String, Character> morse;

    static {
        Map<String, Character> tmp = new HashMap<>();
        tmp.put(".-", 'A');
        tmp.put("-...", 'B');
        tmp.put("-.-.", 'C');
        tmp.put("-..", 'D');
        tmp.put(".", 'E');
        tmp.put("..-.", 'F');
        tmp.put("--.", 'G');
        tmp.put("....", 'H');
        tmp.put("..", 'I');
        tmp.put(".---", 'J');
        tmp.put("-.-", 'K');
        tmp.put(".-..", 'L');
        tmp.put("--", 'M');
        tmp.put("-.", 'N');
        tmp.put("---", 'O');
        tmp.put(".--.", 'P');
        tmp.put("--.-", 'Q');
        tmp.put(".-.", 'R');
        tmp.put("...", 'S');
        tmp.put("-", 'T');
        tmp.put("..-", 'U');
        tmp.put("...-", 'V');
        tmp.put(".--", 'W');
        tmp.put("-..-", 'X');
        tmp.put("-.--", 'Y');
        tmp.put("--..", 'Z');
        tmp.put("-----", '0');
        tmp.put(".----", '1');
        tmp.put("..---", '2');
        tmp.put("...--", '3');
        tmp.put("....-", '4');
        tmp.put(".....", '5');
        tmp.put("-....", '6');
        tmp.put("--...", '7');
        tmp.put("---..", '8');
        tmp.put("----.", '9');
        tmp.put(".-...", '&');
        tmp.put(".----.", '\'');
        tmp.put(".--.-.", '@');
        tmp.put("-.--.-", ')');
        tmp.put("-.--.", '(');
        tmp.put("---...", ':');
        tmp.put("--..--", ',');
        tmp.put("-...-", '=');
        tmp.put("-.-.--", '!');
        tmp.put(".-.-.-", '.');
        tmp.put("-....-", '-');
        tmp.put(".-.-.", '+');
        tmp.put(".-..-.", '"');
        tmp.put("..--..", '?');
        tmp.put("-..-.", '/');

        morse = tmp;
    }

    public static String decode(String input) {
        StringBuilder result = new StringBuilder();
        for (String s : input.split(" ")) {
            result.append(morse.get(s));
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(in.readLine());
        for (int i = 0; i < lines; ++i) {
            System.out.println(decode(in.readLine()));
        }
    }
}
