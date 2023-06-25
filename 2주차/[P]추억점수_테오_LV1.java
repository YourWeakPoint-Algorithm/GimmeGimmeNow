package week1;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> yearningForEach = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            yearningForEach.put(name[i], yearning[i]);
        }

        int iterator = 0;
        for (String[] each : photo) {
            int total = 0;
            for (String eachName : each) {
                total += yearningForEach.getOrDefault(eachName, 0);
            }
            answer[iterator++] = total;
        }
        return answer;
    }
}
