import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] dots) {
        double inc1 = getAbsInclination(dots[0], dots[1]);
        double inc2 = getAbsInclination(dots[2], dots[3]);
        double inc3 = getAbsInclination(dots[0], dots[2]);
        double inc4 = getAbsInclination(dots[1], dots[3]);

        if (Double.compare(inc1, inc2) == 0 || Double.compare(inc3, inc4) == 0) {
            return 1;
        }
        return 0;
    }

    public double getAbsInclination(int[] dot1, int[] dot2) {
        return (double) Math.abs(dot1[0] - dot2[0]) / Math.abs((dot1[1] - dot2[1]));
    }
}
