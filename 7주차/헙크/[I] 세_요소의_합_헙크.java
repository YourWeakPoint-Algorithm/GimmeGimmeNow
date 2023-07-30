import java.util.HashMap;
import java.util.Map;

// 시간 복잡도 : O(n2)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        // arr에서 2개를 더해서 합이 target이 되는 인덱스의 배열을 반환하라.
        int[] arr = new int[]{1, 2, 3, 4, 6};
        int target = 6;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int[] answer = T.solution(arr, map, target);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    private int[] solution(int[] arr, Map<Integer, Integer> map, int target) {
        for (int i = 0; i < arr.length; i++) {
            int remain1 = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int remain2 = remain1 - arr[j];
                if (remain1 != arr[i] && remain2 != arr[j] && map.containsKey(remain2)) {
                    return new int[]{i, j, map.get(remain2)};
                }
            }
        }
        return null;
    }
}
