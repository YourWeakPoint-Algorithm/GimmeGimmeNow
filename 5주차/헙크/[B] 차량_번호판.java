import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int DIGIT_COUNT = 10, CHAR_COUNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) {
                if (input.charAt(i) == 'd') {
                    answer *= DIGIT_COUNT;
                } else {
                    answer *= CHAR_COUNT;
                }
            } else if (input.charAt(i - 1) == input.charAt(i)) {
                if (input.charAt(i) == 'd') {
                    answer *= DIGIT_COUNT - 1;
                } else {
                    answer *= CHAR_COUNT - 1;
                }
            } else {
                if (input.charAt(i) == 'd') {
                    answer *= DIGIT_COUNT;
                } else {
                    answer *= CHAR_COUNT;
                }
            }
        }
        System.out.println(answer);
    }
}