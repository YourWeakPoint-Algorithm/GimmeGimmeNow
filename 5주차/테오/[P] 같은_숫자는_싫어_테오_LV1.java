import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int iter = 0;

        int before = -1;
        for (int i = 0; i < arr.length; i++) {
            if (before != arr[i]) {
                before = arr[i];
                answer[iter++] = before;
            }
        }

        int[] result = new int[iter];

        for (int i = 0; i < iter; i++) {
            result[i] = answer[i];
        }
        return result;
    }
}
