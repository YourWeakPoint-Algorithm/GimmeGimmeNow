import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num1 = sc.nextInt();
    int[] a = new int[num1];
    for (int i = 0; i < num1; i++) {
      a[i] = sc.nextInt();
    }

    int num2 = sc.nextInt();
    int[] b = new int[num2];
    for (int i = 0; i < num2; i++) {
      b[i] = sc.nextInt();
    }

    List<Integer> anw = new ArrayList<>();
    int p1 = 0;
    int p2 = 0;

    while (p1 < num1 && p2 < num2) {
      if (a[p1] < b[p2]) {
        anw.add(a[p1++]);
      } else {
        anw.add(b[p2++]);
      }
    }
    while (p1 < num1) {
      anw.add(a[p1++]);
    }
    while (p2 < num2) {
      anw.add(b[p2++]);
    }
    for (int i : anw) {
      System.out.print(i + " ");
    }
  }

}
