import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String x=str.replaceAll("[^0-9]","");
        System.out.println(Integer.parseInt(x));
    }
}
