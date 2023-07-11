import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  private static int[] data;
  private static boolean[] visited;
  private static Map<String, Boolean> existed = new LinkedHashMap<>();
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
    visited = new boolean[n];

    final String values = bufferedReader.readLine();
    final List<Integer> sortedValues = Arrays.stream(values.split(" "))
        .map(Integer::new).sorted().collect(Collectors.toList());

    for (int i = 0; i < n; i++) {
      visited[i] = false;
    }

    permutation(0, 0, sortedValues);
    System.out.println(sb.toString());
  }

  private static void permutation(int depth, int cnt, List<Integer> sortedValues) {
    if (cnt == m) {
      StringBuilder check = new StringBuilder();
      for (int i = 0; i < m; i++) {
        check.append(data[i] + " ");
      }
      if (!existed.containsKey(check.toString())) {
        existed.put(check.toString(), true);
        sb.append(check);
        sb.append("\n");
      }
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        data[depth] = sortedValues.get(i);
        permutation(depth + 1, cnt + 1, sortedValues);
        visited[i] = false;
      }
    }
  }
}
