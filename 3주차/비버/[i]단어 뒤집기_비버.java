import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String a = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int j = a.length() - 1; j >= 0; j--) {
                sb.append(a.charAt(j));
            }
            System.out.println(sb);
        }
    }
}
