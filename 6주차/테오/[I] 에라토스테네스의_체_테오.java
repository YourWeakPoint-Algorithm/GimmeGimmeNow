import java.util.Scanner;

public class Main {

    public int solution(int n) {
        int[] arr = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;

                for (int j = i; j <= n; j+= i) {
                    arr[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        System.out.println(new Main().solution(input1));
        return ;
    }
}
