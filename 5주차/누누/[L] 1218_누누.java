class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[40001];
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[arr[i] + 20000] = dp[arr[i] - difference + 20000] + 1;
            answer = Math.max(answer, dp[arr[i] + 20000]);
        }
        return answer;

    }
}
