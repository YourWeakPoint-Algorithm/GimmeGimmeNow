import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {

        int cnt = 0;
        HashSet<Integer> curr = new HashSet<>(), next = null;
        curr.add(x);

        while (!curr.isEmpty()) {
            if (curr.contains(y))
                return cnt;
            next = new HashSet<>();
            for (int val : curr) {
                int res1 = val + n;
                int res2 = val * 2;
                int res3 = val * 3;
                if (res1 <= y) next.add(res1);
                if (res2 <= y) next.add(res2);
                if (res3 <= y) next.add(res3);
            }
            curr = next;
            cnt++;
        }
        return -1;
    }
}
