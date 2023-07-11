import java.util.HashSet;
import java.util.Set;

// 시간 복잡도 : O(n2)
// 공간 복잡도 : O(n)
class Solution {

    public int solution(int[] elements) {
        int[] arr = new int[elements.length * 2];
        for (int i = 0; i < elements.length * 2; i++) {
            arr[i] = elements[i % elements.length];
        }

        Set<Integer> answer = new HashSet<>();
        for (int winSize = 0; winSize < elements.length; winSize++) {
            int sum = 0;
            for (int i = 0; i < winSize; i++) { // 초기 윈도우값 생성
                sum += arr[i];
            }
            for (int i = winSize; i < arr.length; i++) { // 슬라이딩
                sum += arr[i];
                answer.add(sum);
                sum -= arr[i - winSize];
            }
        }
        return answer.size();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int answer = T.solution(new int[]{7, 9, 1, 1, 4});
        System.out.println(answer);
    }
}
