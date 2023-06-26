import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> asd = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            asd.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int integer = 0;
            for (String as : photo[i]) {
                if (asd.containsKey(as)) {
                    integer += asd.get(as);
                }
            }
            answer[i] = integer;
        }
        return answer;
    }
}
