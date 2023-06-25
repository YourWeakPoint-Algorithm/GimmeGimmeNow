package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = new ArrayList<>(Arrays.asList(players));
        Map<String, Integer> playerIndexMap = new HashMap<>();

        for (int i = 0; i < playerList.size(); i++) {
            playerIndexMap.put(playerList.get(i), i);
        }

        for (String call : callings) {
            int index = playerIndexMap.get(call);

            playerIndexMap.put(playerList.get(index - 1), index);
            playerIndexMap.put(call, index - 1);

            playerList.set(index, playerList.get(index - 1));
            playerList.set(index - 1, call);
        }

        String[] result = new String[players.length];
        return playerList.toArray(result);
    }
}
