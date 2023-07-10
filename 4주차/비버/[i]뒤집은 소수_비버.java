import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String []a=sc.nextLine().split(" ");
        for(int i = 0; i<num;i++){
            String anr="";
            for(int j=0;j<a[i].length();j++){
                anr += a[i].charAt(a[i].length() - j - 1);
            }
            if(isTrue(Integer.parseInt(anr))) System.out.print(Integer.parseInt(anr) + " ");
        }
    }
    private static boolean isTrue(int num){
        if(num < 2) return false;

        if(num == 2) return true;

        for(int i = 2; i < num; i++){

            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
