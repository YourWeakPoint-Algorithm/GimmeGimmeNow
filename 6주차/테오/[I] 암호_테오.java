import java.util.Scanner;

public class Main {

    public String solution(int count, String line) {
        String[] strings = new String[count];

        for (int i = 0; i < count; i++) {
            strings[i] = line.substring(i * 7, (i + 1) * 7)
                    .replace("#", "1")
                    .replace("*", "0");
        }

        StringBuilder answer = new StringBuilder();
        for (String each : strings) {
            answer.append((char)Integer.parseInt(each, 2));
        }
        return answer.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        String line = in.next();
        System.out.println(new Main().solution(count, line));
        return ;
    }
}
