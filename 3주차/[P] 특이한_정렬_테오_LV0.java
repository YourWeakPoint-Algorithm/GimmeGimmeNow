import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> myList = Arrays.stream(numlist)
                .boxed()
                .collect(Collectors.toList());

        myList.sort((x, y) -> {
            int diff1 = Math.abs(n - x);
            int diff2 = Math.abs(n - y);

            if (diff1 == diff2) {
                if (x > y) {
                    return -1;
                }
                return 1;
            }
            else if (diff1 > diff2) {
                return 1;
            }
            return -1;
        });

        return myList.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
