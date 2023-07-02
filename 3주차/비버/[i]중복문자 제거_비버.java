import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        StringBuilder str = new StringBuilder(in.next());
        char[] a = str.toString().toCharArray();
        StringBuilder awr = new StringBuilder();

        for (char x : a) {
            if (!awr.toString().contains(String.valueOf(x))) {
                awr.append(x);
            }
        }
        System.out.println(awr.toString());
    }
}
