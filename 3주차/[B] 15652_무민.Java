import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static int[] data;
  private static int n;
  private static int m;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    final String input = bufferedReader.readLine();

    final String[] splitInput = input.split(" ");
    n = Integer.parseInt(splitInput[0]);
    m = Integer.parseInt(splitInput[1]);

    data = new int[n];

    for (int i = 0; i < n; i++) {
      data[i] = i + 1;
    }
    combination(0, 0, 1);
    System.out.println(sb.toString());
  }

  private static void combination(int depth, int cnt, int start) {
    if (cnt == m) {
      for (int i = 0; i < m; i++) {
        sb.append(data[i] + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i <= n; i++) {
      data[depth] = i;
      combination(depth + 1, cnt + 1, i);
    }
  }
}
