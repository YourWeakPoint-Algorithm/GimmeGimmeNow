class Solution {
    public int[] solution(String[] park, String[] routes) {
        int row = -1;
        int col = -1;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        for (String route : routes) {
            char direction = route.charAt(0);
            int value = route.charAt(2) - '0';

            if (direction == 'W') {
                boolean isNormal = true;
                if (col - value < 0) {
                    continue;
                }
                for (int i = 1; i <= value; i++) {
                    if (park[row].charAt(col - i) == 'X') {
                        isNormal = false;
                        break;
                    }
                }
                if (isNormal) {
                    col = col - value;
                }
            }

            if (direction == 'E') {
                boolean isNormal = true;
                if (col + value >= park[0].length()) {
                    continue;
                }
                for (int i = 1; i <= value; i++) {
                    if (park[row].charAt(col + i) == 'X') {
                        isNormal = false;
                        break;
                    }
                }
                if (isNormal) {
                    col = col + value;
                }
            }

            if (direction == 'S') {
                boolean isNormal = true;
                if (row + value >= park.length) {
                    continue;
                }
                for (int i = 1; i <= value; i++) {
                    if (park[row + i].charAt(col) == 'X') {
                        isNormal = false;
                        break;
                    }
                }
                if (isNormal) {
                    row = row + value;
                }
            }

            if (direction == 'N') {
                boolean isNormal = true;
                if (row - value < 0) {
                    continue;
                }
                for (int i = 1; i <= value; i++) {
                    if (park[row - i].charAt(col) == 'X') {
                        isNormal = false;
                        break;
                    }
                }
                if (isNormal) {
                    row = row - value;
                }
            }
        }
        int[] answer = {row, col};
        return answer;
    }
}
