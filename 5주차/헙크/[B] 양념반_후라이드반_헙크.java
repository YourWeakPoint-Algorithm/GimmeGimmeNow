import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도 : O(1)
// 공간 복잡도 : O(1)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        if (nums[0] + nums[1] <= nums[2] * 2) {
            answer = (nums[0] * nums[3]) + (nums[1] * nums[4]);
        } else {
            int min = Math.min(nums[3], nums[4]);
            int max = Math.max(nums[3], nums[4]);
            int tmp = min * 2 * nums[2];
            if (nums[3] < nums[4]) {
                answer = tmp + (max - min) * nums[1];
            } else {
                answer = tmp + (max - min) * nums[0];
            }
            answer = Math.min(answer, nums[2] * 2 * max);
        }
        System.out.println(answer);
    }
}