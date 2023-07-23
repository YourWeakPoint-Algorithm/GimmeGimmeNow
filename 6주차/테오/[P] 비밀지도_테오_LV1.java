class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] map1 = new String[n];
        String[] map2 = new String[n];

        for (int i = 0; i < n; i++) {
            String decoded1 = decodeToBinary(arr1[i], n);
            String decoded2 = decodeToBinary(arr2[i], n);

            map1[i] = decoded1;
            map2[i] = decoded2;
        }

        String[] mergedMap = new String[n];

        for (int i = 0; i < n; i++) {
            String temp = "";

            for (int j = 0; j < n; j++) {
                if (map1[i].charAt(j) == '#' || map2[i].charAt(j) == '#') {
                    temp += '#';
                } else {
                    temp += ' ';
                }
            }
            mergedMap[i] = temp;
        }

        return mergedMap;
    }

    public String decodeToBinary(int target, int n) {
        StringBuilder result = new StringBuilder();

        while (target > 0) {
            if (target % 2 == 1) {
                result.append("#");
            } else {
                result.append(" ");
            }
            target /= 2;
        }

        while (result.length() < n) {
            result.append(" ");
        }
        return result.reverse().toString();
    }
}
