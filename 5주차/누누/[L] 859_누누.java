public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int diffCount = 0;
        int[] diffIndex = new int[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
                diffIndex[diffCount - 1] = i;
            }
        }
        if (diffCount == 2) {
            if (s.charAt(diffIndex[0]) != goal.charAt(diffIndex[1])) {
                return false;
            }
            return goal.charAt(diffIndex[0]) == s.charAt(diffIndex[1]);
        }

        if (diffCount == 1) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int i1 = count.getOrDefault(c, 0) + 1;
            count.put(c, i1);
            if (i1 == 2) {
                return true;
            }
        }
        return false;
    }
}
