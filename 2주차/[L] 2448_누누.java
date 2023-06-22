package algorithm.leet2448;

import java.util.Arrays;

public class Solution {

    int[] nums;
    int[] cost;

    public static void main(String[] args) {
        int[] nums = new int[100000];
        for (int i = 1; i <= 100000; i++) {
            nums[i] = i;
        }
        int[] costs = new int[100000];
        Arrays.fill(costs, 100000);
        System.out.println(new Solution().minCost(nums, costs));
    }

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long leftCost = calculateCost(mid - 1);
            long currentCost = calculateCost(mid);
            long rightCost = calculateCost(mid + 1);
            if (currentCost < leftCost && currentCost < rightCost) {
                return currentCost;
            }
            if (currentCost > leftCost) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    private long calculateCost(int target) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) Math.abs(nums[i] - target) * (long) cost[i];
        }
        return sum;
    }
}
