import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> frequency = new HashMap<>();
        
        for (String each : participant) {
            frequency.put(each, frequency.getOrDefault(each, 0) + 1);
        }
        
        for (String each : completion) {
            frequency.put(each, frequency.get(each) - 1);
        }
        
        for (String each : frequency.keySet()) {
            if (frequency.get(each) != 0) {
                return each;
            }
        }
        return "Exception";
    }
}
