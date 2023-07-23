import java.util.Scanner;

public class Main {

    public String[] solution(String s, String t) {

        String[] left = new String[s.length()];
        int temp = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                temp = 0;
            } else {
                temp++;
            }
            left[i] = String.valueOf(temp);
        }

        temp = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(0)) {
                temp = 0;
            } else {
                temp++;
            }
            left[i] = String.valueOf(Math.min(Integer.parseInt(left[i]), temp));
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        String[] result = new Main().solution(s, t);
        System.out.println(String.join(" ", result));
    }
}
