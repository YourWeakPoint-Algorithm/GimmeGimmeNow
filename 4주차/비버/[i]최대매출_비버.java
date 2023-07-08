import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int k = sc.nextInt();
    List<Integer> a = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      a.add(sc.nextInt());
    }
    int sum = 0;
    for (int i = 0; i < k ; i++) {
      sum += a.get(i);
    }
    int max = sum;
    for (int i = k; i < num; i++) {
      sum += (a.get(i) - a.get(i - k));
      if (max<sum) max=sum;
    }
    System.out.println(max);
  }
}
