import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 시간 복잡도 : O(n2)
// 공간 복잡도 : O(n2)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = Integer.parseInt(br.readLine());
        int[] moves = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < count; i++) {
            moves[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        System.out.println(solution(board, n, moves));
    }

    private static int solution(int[][] board, int n, int[] moves) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int move : moves) {
            for (int i = n - 1; i >= 0; i--) {
                if (board[move][i] != 0) {
                    if (!stack.isEmpty() && stack.peekLast() == board[move][i]) {
                        result += 2;
                        stack.pop();
                    } else {
                        stack.push(board[move][i]);
                        board[move][i] = 0;
                    }
                    break;
                }
            }
        }
        return result;
    }
}