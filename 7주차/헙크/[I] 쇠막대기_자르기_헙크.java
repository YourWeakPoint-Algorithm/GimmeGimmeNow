import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(T.solution(input));
    }

    private int solution(String input) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == ')') {
                stack.pop();
                answer += stack.size();
            } else {
                stack.push(target);
            }
        }
        return answer;
    }
}
