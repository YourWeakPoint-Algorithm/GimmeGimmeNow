import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int sum = 0;
    int anw =0;
    int lf=1;
    int[] a = new int[num];
    for(int i=1; i<num ;i++){
      a[i]=i;
    }
    for(int i=1;i<num;i++){

      sum+=a[i];

      if(sum==num){
        anw++;
      }

      while(sum>=num){
        sum-=a[lf];
        lf++;
        if(sum==num){
          anw++;
        }

      }
    }
    System.out.println(anw);
  }
}
