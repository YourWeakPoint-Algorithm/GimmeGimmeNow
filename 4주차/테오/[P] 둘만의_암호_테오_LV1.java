class Solution {
    public String solution(String s, String skip, int index) {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char each = s.charAt(i);

            for (int j = 0; j < index; j++) {
                char temp = getNextChar(each);

                while (skip.contains(String.valueOf(temp))) {
                    each = getNextChar(each);
                    temp = getNextChar(each);
                }
                each = getNextChar(each);
            }
            result.append(each);
        }
        return result.toString();
    }

    private static char getNextChar(char target) {
        char result = (char)((target + 1) % ('z' + 1));
        if (result < 'a') {
            result += 'a';
        }
        return result;
    }
}
