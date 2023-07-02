import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] sstr = str.split(" ");
        String answer = "";
        int maxLength = Arrays.stream(sstr)
                .mapToInt(String::length)
                .max()
                .getAsInt();
        for (String a : sstr) {
            if (a.length() == maxLength) {
                answer = a;
                break;
            }
        }
        System.out.println(answer);
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        String []answer="";
        for(int i=0;i<num;i++){
            String a=sc.next();
            StringBilder sb=new StringBilder();

            for(int j=a.length();j>0;j--){
                sb.appand(a.charAt(j));
            }
            System.out.println(sb);
        }
    }
}
