import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        char ch=sc.next().charAt(0);
        int []answer=new int[str.length()];
        int count=1000;
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)==ch){
                count=0;
                answer[i]=count;
            }else{
                count++;
                answer[i]=count;
            }
        }
        count=1000;
        for(int i=str.length()-1;i>=0;i--){

            if(str.charAt(i)==ch){
                count=0;
                answer[i]=count;
            }else{
                count++;
                answer[i]=count=Math.min(answer[i],count);
            }
        }

        for (int a : answer) {
            System.out.print(a+" ");
        }
    }
}
