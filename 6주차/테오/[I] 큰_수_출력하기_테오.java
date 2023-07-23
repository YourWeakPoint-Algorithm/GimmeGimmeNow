import java.util.Scanner;

public class Main {

    public String solution(int size, String line) {
        String[] split = line.split(" ");
        StringBuilder result = new StringBuilder();

        int before = -1;
        for (String each : split) {
            if (Integer.parseInt(each) > before) {
                result.append(each).append(" ");
            }
            before = Integer.parseInt(each);
        }
        return result.toString().trim();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        System.out.println(new Main().solution(size, line));
        return ;
    }
}
