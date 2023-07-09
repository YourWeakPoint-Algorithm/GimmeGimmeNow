import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> result = new ArrayList<>();
        List<Integer> honor = new ArrayList<>();

        int bound = k > score.length ? score.length : k;

        for (int i = 0; i < bound; i++) {
            honor.add(score[i]);
            result.add(honor.stream().min(Integer::compareTo).get());
        }
        honor.sort(Integer::compareTo);

        for (int i = k; i < score.length; i++) {
            int each = score[i];
            if (each > honor.get(0)) {
                honor.remove(0);
                honor.add(each);
                honor.sort(Integer::compareTo);
            }
            result.add(honor.stream().min(Integer::compareTo).get());
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
