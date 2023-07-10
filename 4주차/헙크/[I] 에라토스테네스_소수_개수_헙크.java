import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!arr[i]) {
                count++;
                for (int j = i; j < n; j += i) {
                    arr[j] = true;
                }
            }
        }
        System.out.println(count);
    }
}
