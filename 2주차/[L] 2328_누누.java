package algorithm.leet2328;

public class Solution {

    private static final long MOD = 1000000007;

    long[][] dp;

    public static void main(String[] args) {
        System.out.println(new Solution().countPaths(new int[][]{
                {1, 1}, {3, 4}
        }));
    }

    public int countPaths(int[][] grid) {
        dp = new long[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 0) {
                    calculate(grid, i, j);
                }
            }
        }

        long ans = 0;
        for (long[] longs : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                ans = (ans + longs[j]) % MOD;
            }
        }
        return (int) ans;
    }

    private void calculate(int[][] grid, int i, int j) {
        dp[i][j] = calculateNext(grid, i, j);
    }

    private int calculateNext(int[][] grid, int i, int j) {
        long current = grid[i][j];
        if (dp[i][j] != 0) {
            return (int) dp[i][j];
        }
        long ans = 0;
        if (i > 0 && (grid[i - 1][j] < current)) {
            ans += calculateNext(grid, i - 1, j);

        }
        if (i < grid.length - 1) {
            if (grid[i + 1][j] < current) {
                ans += calculateNext(grid, i + 1, j);
            }
        }
        if (j > 0) {
            if (grid[i][j - 1] < current) {
                ans += calculateNext(grid, i, j - 1);
            }
        }
        if (j < grid[0].length - 1) {
            if (grid[i][j + 1] < current) {
                ans += calculateNext(grid, i, j + 1);
            }
        }
        ans %= MOD;
        ans += 1;
        dp[i][j] = ans;
        return (int) ans;
    }
}
