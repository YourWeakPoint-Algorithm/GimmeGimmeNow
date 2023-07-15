import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));
    }

    private static String solution(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        int length = stack.size();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(stack.pollLast());
        }
        return result.toString();
    }
}