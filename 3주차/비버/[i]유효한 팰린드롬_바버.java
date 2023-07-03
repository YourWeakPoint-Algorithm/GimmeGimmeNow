import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String a = str.toUpperCase().replaceAll("[^A-Z]","");

        for (int i = 0; i < str.length()/2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - (i + 1))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
