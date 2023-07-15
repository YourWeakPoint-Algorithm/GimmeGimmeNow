import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 복잡도 : O(nlogn)
// 공간 복잡도 : O(n)
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        PriorityQueue<Patient> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            queue.add(new Patient(i, Integer.parseInt(st2.nextToken())));
        }
        System.out.println(solution(queue, m));
    }

    private static int solution(PriorityQueue<Patient> queue, int m) {
        int answer = 1;
        while (!queue.isEmpty() && queue.peek().index != m) {
            queue.poll();
            answer++;
        }
        return answer;
    }

    static class Patient implements Comparable<Patient>{
        public int index;
        public int value;

        public Patient(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Patient o) {
            return Objects.compare(this.value, o.value, Integer::compare);
        }
    }
}