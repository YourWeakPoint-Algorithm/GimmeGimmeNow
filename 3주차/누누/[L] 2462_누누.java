package algorithm.leet2462;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    Queue<Integer> frontQueue = new PriorityQueue<>();
    Queue<Integer> backQueue = new PriorityQueue<>();

    public static void main(String[] args) {
        System.out.println(new Solution().totalCost(new int[]{2, 1, 2}, 1, 1));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        if (costs.length - k < 2 * candidates) {
            Queue<Integer> queue = new PriorityQueue<>();
            for (int cost : costs) {
                queue.add(cost);
            }
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += queue.poll();
            }
            return sum;
        }

        int frontIndex = 0;
        int lastIndex = costs.length - 1;
        for (int i = 0; i < candidates; i++) {
            frontQueue.add(costs[frontIndex++]);
            backQueue.add(costs[lastIndex--]);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (costs.length - i == 2 * candidates) {
                frontQueue.addAll(backQueue);
            }
            if (costs.length - i <= 2 * candidates) {
                sum += frontQueue.poll();
                continue;
            }
            int first = frontQueue.peek();
            int last = backQueue.peek();
            if (first <= last) {
                sum += frontQueue.poll();
                frontQueue.add(costs[frontIndex++]);
            } else {
                sum += backQueue.poll();
                backQueue.add(costs[lastIndex--]);
            }
        }
        return sum;
    }
}
