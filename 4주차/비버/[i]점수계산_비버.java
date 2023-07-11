import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        int []a = new int[num];
        int anw = 0;
        int count= 1;
        for(int i = 0; i < num; i++){
            a[i]=sc.nextInt();
        }
        for(int i = 0; i<num;i++){
            if(a[i]==1){
                anw+=count;
                count++;
            }else count=1;
        }
        System.out.println(anw);
    }
}
