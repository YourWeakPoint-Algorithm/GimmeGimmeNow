package week1;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] charArray = s.toCharArray();

        int answerIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            int diff = -1;

            for (int j = 0; j < i; j++) {
                if (charArray[j] == charArray[i]) {
                    diff = i - j;
                }
            }
            answer[answerIndex++] = diff;
        }
        return answer;
    }
}
