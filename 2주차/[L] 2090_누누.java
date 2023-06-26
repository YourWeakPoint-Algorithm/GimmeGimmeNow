package algorithm.leet2090;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getAverages(new int[]{1000}, 0)));
    }

    public int[] getAverages(int[] nums, int k) {
        long[] csum = new long[nums.length + 1];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            csum[i + 1] = sum;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0) {
                result[i] = -1;
                continue;
            }
            if (i + k >= nums.length) {
                result[i] = -1;
                continue;
            }
            result[i] = (int) ((csum[i + k + 1] - csum[i - k]) / (2 * k + 1));
        }
        return result;
    }
}
