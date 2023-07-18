import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        List<Integer> list = Arrays.stream(d)
                .boxed()
                .sorted((x, y) -> x - y)
                .collect(Collectors.toList());

        for (int each : list) {
            if (budget - each >= 0) {
                answer += 1;
            }
            budget -= each;

        }

        return answer;
    }
}
