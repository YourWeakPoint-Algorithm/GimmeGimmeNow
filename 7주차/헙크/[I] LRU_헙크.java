import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 시간 복잡도: O(n)
// 공간 복잡도: O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for (int x : T.solution(arr, s)) {
            System.out.print(x + " ");
        }
    }

    private int[] solution(int[] arr, int s) {
        Deque<Integer> deque = new ArrayDeque<>(s);
        for (int x : arr) {
            if (deque.contains(x)) {
                deque.remove(x);
            } else if (deque.size() == s) {
                deque.pollLast();
            }
            deque.addFirst(x);
        }
        int[] result = new int[s];
        int length = deque.size();
        for (int i = 0; i < length; i++) {
            result[i] = deque.pollFirst();
        }

        return result;
    }
}
