import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] a = new int[num];

    for (int i = 0; i < num; i++) {
      a[i] = sc.nextInt();
    }
    Arrays.sort(a);

    for (int x : a) {
      System.out.print(x + " ");
    }
  }
}
