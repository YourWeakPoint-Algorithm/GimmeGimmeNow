import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static boolean[] visited;
  private static int[] data;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    final String input = bufferedReader.readLine();

    final String[] splitInput = input.split(" ");
    n = Integer.parseInt(splitInput[0]);
    m = Integer.parseInt(splitInput[1]);

    visited = new boolean[n];
    data = new int[n];

    for (int i = 0; i < n; i++) {
      visited[i] = false;
      data[i] = i + 1;
    }

    permutation(0, 0);
  }

  private static void permutation(int depth, int cnt) {
    if (cnt == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(data[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= n; i++) {
      if (!visited[i - 1]) {
        visited[i - 1] = true;
        data[depth] = i;
        permutation(depth + 1, cnt + 1);
        visited[i - 1] = false;
      }
    }
  }
}
