package ex;

import java.util.Scanner;

public class i가위바위보_비버 {
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            sc.nextLine();

            String []num1=sc.nextLine().split(" ");
            String []num2=sc.nextLine().split(" ");
            for(int i=0;i<num;i++){
                if((num1[i].equals("1")&&num2[i].equals("3"))||
                        (num1[i].equals("2")&&num2[i].equals("1"))||
                        (num1[i].equals("3")&&num2[i].equals("2"))
                ){
                    System.out.println("A");
                }else if (num1[i].equals(num2[i])){
                    System.out.println("D");
                }else System.out.println("B");
            }
        }
    }
}
