class Solution {
    public int[] solution(String[] wallpaper) {
        // 모든 페이지를 포함하는 가장 작은 사각형
        // (가장 작은 x, 가장 작은 y) ~ (가장 큰 x, 가장 큰 y)

        int minRow = wallpaper.length;
        int minCol = wallpaper[0].length();
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < minRow) {
                        minRow = i;
                    }
                    if (i > maxRow) {
                        maxRow = i;
                    }
                    if (j < minCol) {
                        minCol = j;
                    }
                    if (j > maxCol) {
                        maxCol = j;
                    }
                }
            }
        }
        int[] result = {minRow, minCol, maxRow + 1, maxCol + 1};
        return result;
    }
}
