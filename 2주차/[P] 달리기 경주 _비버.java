import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> a = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            a.put(players[i], i);
        }

        for (String calling : callings) {
            Integer integer = a.get(calling);
            String player = players[integer - 1];
            players[integer - 1] = calling;
            players[integer] = player;

            a.put(calling, integer - 1);
            a.put(player, integer);

        }
        return players;
    }
}
