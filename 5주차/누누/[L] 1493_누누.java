class Solution {

    public int longestSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return (nums[0] == 1 || nums[1] == 1) ? 1 : 0;
        }
        int[] dpLeft = new int[nums.length];
        if (nums[0] == 1) {
            dpLeft[0] = 1;
        }
        int[] dpRight = new int[nums.length];
        if (nums[nums.length - 1] == 1) {
            dpRight[nums.length - 1] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                dpLeft[i] = dpLeft[i - 1] + 1;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 1) {
                dpRight[i] = dpRight[i + 1] + 1;
            }
        }
        int ans = Math.max(dpRight[1], dpLeft[nums.length - 2]);
        for (int i = 1; i < nums.length - 1; i++) {
            ans = Math.max(ans, dpLeft[i - 1] + dpRight[i + 1]);
        }
        return ans;
    }
}
