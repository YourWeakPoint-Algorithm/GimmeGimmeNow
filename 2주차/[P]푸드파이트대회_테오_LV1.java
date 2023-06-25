package week1;

class Solution {
    public String solution(int[] food) {
        String answer = "";

        for (int i = 1; i < food.length; i++) {
            int repeat = food[i] / 2;

            for (int j = 0; j < repeat; j++) {
                answer += i;
            }
        }
        StringBuffer sb = new StringBuffer(answer);
        String reversedAnswer = sb.reverse().toString();

        answer = answer + "0" + reversedAnswer;

        return answer;
    }
}
