package week1;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String toCompare = "";

            for (int j = i; j < i + p.length(); j++) {
                toCompare += t.charAt(j);
            }

            System.out.println("toCompare: " + toCompare);
            if (toCompare.compareTo(p) <= 0) {
                answer += 1;
            }
        }
        return answer;
    }
}
