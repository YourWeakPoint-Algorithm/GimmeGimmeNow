import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간 복잡도 : O(2^n)
// 공간 복잡도 : O(n)
public class Main {
    private static int n;
    private static boolean[] check;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1]; // tracking

        T.dfs(1); // start level
    }

    private void dfs(int level) {
        if (level == n + 1) { // end level
            StringBuilder result = new StringBuilder();
            for (int i = 1; i < check.length; i++) {
                if (check[i]) {
                    result.append(i).append(" ");
                }
            }
            if (result.length() > 0) {
                System.out.println(result);
            }
        } else { // 해당 level의 check 경우의 수에 따라 deep dive (back tracking)
            check[level] = true;
            dfs(level + 1);
            check[level] = false;
            dfs(level + 1);
        }
    }
}
