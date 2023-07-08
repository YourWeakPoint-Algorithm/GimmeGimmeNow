import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int []a = new int[num+1];
        int count = 0;
        for(int i=2; i<num; i++){
            if(a[i]==0)
                count++;
            for(int j=i;j<num;j+=i){
                a[j]=1;
            }
        }
        System.out.println(count);
    }
}
