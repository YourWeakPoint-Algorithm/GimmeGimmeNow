import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);

        for (int i = 0; i < score.length / 2; i++) {
            int temp = score[i];
            score[i] = score[score.length - i - 1];
            score[score.length - i - 1] = temp;
        }

        int result = 0;
        List<Integer> bucket = new ArrayList<>();
        for (int each : score) {
            bucket.add(each);
            if (bucket.size() == m) {
                int min = bucket.stream().mapToInt(i -> i).min().getAsInt();
                result += bucket.size() * min;
                bucket.clear();
            }
        }
        return result;
    }
}
