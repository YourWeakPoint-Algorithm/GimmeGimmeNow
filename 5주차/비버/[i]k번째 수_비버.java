import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

    int a[] = new int[num1];

    Set<Integer> result = new TreeSet<>(Collections.reverseOrder());
    for (int i = 0; i < num1; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < num1; i++) {
      for (int j = i + 1; j < num1; j++) {
        for (int k = j + 1; k < num1; k++) {
          result.add(a[i] + a[j] + a[k]);
        }
      }
    }

    int count = 0;
    for (Integer integer : result) {
      count++;
      if (num2 == count) {
        System.out.println(integer);
        return;
      }

    }
    System.out.println(-1);
  }
}
