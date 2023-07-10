import java.util.*;

public class Main {
  public static void main(String[] args){
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

    Arrays.sort(a);
    Arrays.sort(b);
    List<Integer> anw = new ArrayList<>();
    int p1 = 0;
    int p2 = 0;

    while (p1 < num1 && p2 < num2) {
      if (a[p1] == b[p2]) {
        anw.add(a[p1++]);
        p2++;
      } else if (a[p1] < b[p2]) {
        p1++;
      } else {
        p2++;
      }
    }

    for (int i : anw) {
      System.out.print(i + " ");
    }
  }
}
