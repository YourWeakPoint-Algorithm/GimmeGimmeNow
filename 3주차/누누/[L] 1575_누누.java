package algorithm.leet1575;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    boolean[][][] visited;
    long dp[][];
    Map<Integer, List<Edge>> edges = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().countRoutes(new int[]{1, 2, 3}, 0, 2, 40));
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        visited = new boolean[locations.length][locations.length][fuel + 1];
        dp = new long[locations.length][fuel + 1];

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = Math.abs(locations[i] - locations[j]);
                edges.computeIfAbsent(i, k -> new ArrayList<>())
                        .add(new Edge(j, distance));
            }
        }

        return (int) dfs(start, finish, fuel);
    }

    private long dfs(int start, int finish, int fuel) {
        if (visited[start][finish][fuel]) {
            return dp[start][fuel];
        }
        long ans = 0;
        if (start == finish) {
            ans = 1;
        }
        if (fuel > 0) {
            for (Edge edge : edges.get(start)) {
                if (edge.distance <= fuel) {
                    ans += dfs(edge.to, finish, fuel - edge.distance);
                    ans %= 1000000007;
                }
            }
        }
        visited[start][finish][fuel] = true;
        dp[start][fuel] = ans;
        return ans;
    }
}

class Edge {

    int to;
    int distance;

    public Edge(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}
