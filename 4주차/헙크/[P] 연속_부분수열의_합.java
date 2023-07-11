class Solution {

    public int[] solution(int[] sequence, int k) {
        int left = 0, right = -1, sum = 0;
        int length = 1000001, sLeft = 0, sRight = 0;

        while (right < sequence.length) {
            if (sum < k) {
                if (++right < sequence.length)
                    sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left++];
            } else {
                if (right - left < length) {
                    length = right - left;
                    sLeft = left;
                    sRight = right;
                }
                sum -= sequence[left++];
            }
        }
        return new int[]{sLeft, sRight};
    }
}
