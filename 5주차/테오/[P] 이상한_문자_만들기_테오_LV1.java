import java.util.*;

class Solution {
    public String solution(String s) {

        String result = "";
        boolean isWord = true;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                isWord = false;
                temp = 0;
                result += " ";
            } else {
                isWord = true;
            }

            if (isWord) {
                if (temp++ % 2 == 0) {
                    result += Character.toUpperCase(s.charAt(i));
                } else {
                    result += Character.toLowerCase(s.charAt(i));
                }
            }
        }
        return result;
    }
}
