import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(String[] babbling) {
        List<String> allAvailable = Arrays.asList("aya","ye", "woo", "ma");
        int result = 0;

        for (String each : babbling) {
            String temp = each;
            for (String available : allAvailable) {
                temp = temp.replace(available, makeMosaic(available.length()));
            }
            if (temp.equals(makeMosaic(temp.length()))) {
                result += 1;
            }
        }
        return result;
    }

    public String makeMosaic(int size) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append("*");
        }
        return result.toString();
    }
}
