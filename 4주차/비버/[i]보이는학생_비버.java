package ex;

import java.util.Scanner;

public class i보이는학생_비버 {
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int a = 0;
            int count =0;
            for(int i=0;i<num;i++){
                int num1 = sc.nextInt();
                if(num1>a){
                    a=num1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
