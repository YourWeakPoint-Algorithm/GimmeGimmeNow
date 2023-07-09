class Solution {
    public int solution(int number, int limit, int power) {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            int divisorCount = calculateDivisor(i);
            if (divisorCount > limit) {
                result += power;
            } else {
                result += divisorCount;
            }
        }
        return result;
    }

    private static int calculateDivisor(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count += 1;
            } else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }
}
