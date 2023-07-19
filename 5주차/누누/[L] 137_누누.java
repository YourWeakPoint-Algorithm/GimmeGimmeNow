public class Solution {

    public int singleNumber(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count.entrySet()
                .stream()
                .filter(it -> it.getValue() == 1)
                .findAny()
                .orElseThrow()
                .getKey();
    }
}
