import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int m, int[] section) {
        List<Integer> sections = Arrays.stream(section)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> flags = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            flags.add(0);
        }

        int result = 0;

        for (int targetIndex : sections) {
            targetIndex -= 1;
            if (flags.get(targetIndex) == 0) {
                for (int j = 0; j < m; j++) {
                    if (j + targetIndex >= n) {
                        break;
                    }
                    flags.set(j + targetIndex, 1);
                }
                result += 1;
            }
        }
        return result;
    }
}
