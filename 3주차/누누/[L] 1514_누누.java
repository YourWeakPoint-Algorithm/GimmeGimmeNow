package algorithm.leet1514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    Map<Integer, List<Edge>> edgeMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().maxProbability(5, new int[][]{
                {1, 4},
                {2, 4},
                {0, 4},
                {0, 3},
                {0, 2},
                {2, 3}
        }, new double[]{
                0.37, 0.17, 0.93, 0.23, 0.39, 0.04
        }, 3, 4));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dp = new double[n];
        for (int i = 0; i < edges.length; i++) {
            int key = edges[i][0];
            int key2 = edges[i][1];
            List<Edge> orDefault = edgeMap.getOrDefault(key, new ArrayList<>());
            orDefault.add(new Edge(key2, succProb[i]));
            edgeMap.put(key, orDefault);
            List<Edge> orDefault2 = edgeMap.getOrDefault(key2, new ArrayList<>());
            orDefault2.add(new Edge(key, succProb[i]));
            edgeMap.put(key2, orDefault2);
        }

        Queue<Something> queue = new PriorityQueue<>();

        queue.add(new Something(start, 1));

        while (!queue.isEmpty()) {
            Something poll = queue.poll();
            List<Edge> edges1 = edgeMap.get(poll.target);
            if (dp[poll.target] != 0) {
                continue;
            }
            dp[poll.target] = poll.percent;
            for (Edge edge : edges1) {
                queue.add(new Something(edge.to, poll.percent * edge.percent));
            }
        }
        return dp[end];
    }
}

class Something implements Comparable<Something> {

    int target;
    double percent;

    public Something(int target, double percent) {
        this.target = target;
        this.percent = percent;
    }


    @Override
    public int compareTo(Something o) {
        return Double.compare(o.percent, percent);
    }
}

class Edge {

    int to;
    double percent;

    public Edge(int to, double percent) {
        this.to = to;
        this.percent = percent;
    }
}
