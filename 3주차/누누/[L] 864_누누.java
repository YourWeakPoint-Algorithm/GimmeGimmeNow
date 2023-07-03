package algorithm.leet864;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Solution {

    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};
    char[][] map;
    boolean visited[][][];
    List<Character> characters;

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPathAllKeys(new String[]{
                "@..aA", "..B#.", "....b"
        }));
    }

    public int shortestPathAllKeys(String[] grid) {
        map = new char[grid.length][grid[0].length()];
        visited = new boolean[grid.length][grid[0].length()][65];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
        }
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '@') {
                    startX = j;
                    startY = i;
                }
            }
        }
        TreeSet<Character> treeSet = new TreeSet<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if ('a' <= map[i][j] && map[i][j] <= 'z') {
                    treeSet.add(map[i][j]);
                }
            }
        }
        characters = treeSet.stream()
                .toList();

        int bfs = bfs(startY, startX);
        return bfs;
    }

    private int bfs(int startY, int startX) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(startX, startY, 0, 0));
        int end = (1 << characters.size()) - 1;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            if (position.keys == end) {
                return position.count;
            }
            if (visited[position.y][position.x][position.keys]) {
                continue;
            }
            visited[position.y][position.x][position.keys] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = position.x + dx[i];
                int nextY = position.y + dy[i];
                if (nextX < 0 || nextX >= map[0].length || nextY < 0 || nextY >= map.length) {
                    continue;
                }
                if (map[nextY][nextX] == '#') {
                    continue;
                }
                if ('A' <= map[nextY][nextX] && map[nextY][nextX] <= 'Z') {
                    int key = 1 << (map[nextY][nextX] - 'A');
                    if ((position.keys & key) == 0) {
                        continue;
                    }
                }
                int nextKeys = position.keys;
                if ('a' <= map[nextY][nextX] && map[nextY][nextX] <= 'z') {
                    nextKeys |= 1 << (map[nextY][nextX] - 'a');
                }
                queue.add(new Position(nextX, nextY, position.count + 1, nextKeys));
            }

        }
        return -1;
    }
}

class Position {

    int x;
    int y;
    int count;
    int keys;

    public Position(int x, int y, int count, int keys) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.keys = keys;
    }
}
