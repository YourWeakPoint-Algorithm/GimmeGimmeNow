public class Solution {

    int n;
    int[][] requests;
    int current = 0;
    int ans = 0;
    int[] netChange;

    public int maximumRequests(int n, int[][] requests) {
        this.n = n;
        this.requests = requests;
        netChange = new int[n];
        helper(0);
        return ans;
    }

    private void helper(int index) {
        if (index == requests.length) {
            if (check()) {
                ans = Math.max(ans, current);
            }
            return;
        }
        int[] request = requests[index];
        netChange[request[0]]++;
        netChange[request[1]]--;
        current++;
        helper(index + 1);
        netChange[request[0]]--;
        netChange[request[1]]++;
        current--;
        helper(index + 1);
    }

    private boolean check() {
        for (int i = 0; i < n; i++) {
            if (netChange[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
