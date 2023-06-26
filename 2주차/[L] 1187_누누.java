package algorithm.leet1187;

import java.util.Arrays;

public class Solution {

    int[][] dp;

    public static void main(String[] args) {
        System.out.println(new Solution().makeArrayIncreasing(
                new int[]{1, 5, 3, 6, 7},
                new int[]{1, 6, 3, 3}));
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        initializeDpArray(arr1, arr2);

        doDp(arr1, arr2);

        for (int i = 0; i <= arr1.length; i++) {
            if (dp[arr1.length - 1][i] != -1) {
                return i;
            }
        }
        return -1;
    }

    private void doDp(int[] arr1, int[] arr2) {
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (dp[i - 1][j] == -1) {
                    continue;
                }
                Integer next = findNext(dp[i - 1][j], arr2);
                if (next != null) {
                    dp[i][j + 1] = next;
                }
                if (dp[i - 1][j] < arr1[i]) {
                    if (dp[i][j] == -1) {
                        dp[i][j] = arr1[i];
                    } else {
                        dp[i][j] = Math.min(dp[i][j], arr1[i]);
                    }
                }
            }
        }
    }

    private Integer findNext(int i, int[] arr2) {
        Integer ans = null;
        int left = 0;
        int right = arr2.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr2[mid] > i) {
                ans = arr2[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private void initializeDpArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        dp = new int[arr1.length + 1][arr1.length + 1];
        for (int i = 0; i <= arr1.length; i++) {
            for (int j = 0; j <= arr1.length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = arr1[0];
        if (arr1[0] > arr2[0]) {
            dp[0][1] = arr2[0];
        }
    }
}
