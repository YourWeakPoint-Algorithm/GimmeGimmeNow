class Solution {
    public int solution(String s) {
        int result = 0;

        char criteria = s.charAt(0);
        int criteriaCount = 0;
        int anotherCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == criteria) {
                criteriaCount += 1;
            } else {
                anotherCount += 1;
            }

            if (criteriaCount == anotherCount) {
                result += 1;
                if (i + 1 == s.length()) {
                    break;
                }
                criteria = s.charAt(i + 1);
                criteriaCount = 0;
                anotherCount = 0;
            } else {
                if (i == s.length() - 1) {
                    result += 1;
                }
            }
        }
        return result;
    }
}
