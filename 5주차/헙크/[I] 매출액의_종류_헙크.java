import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int x : solution(arr, k)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // 초기 윈도우 생성
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // 슬라이딩 윈도우
        for (int i = k; i < arr.length; i++, idx++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result[idx] = map.size();
            if (map.get(arr[idx]) == 1) {
                map.remove(arr[idx]);
            } else {
                map.put(arr[idx], map.get(arr[idx]) - 1);
            }
        }
        result[idx] = map.size();

        return result;
    }
}