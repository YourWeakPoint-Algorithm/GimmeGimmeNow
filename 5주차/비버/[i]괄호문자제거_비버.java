import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] a = sc.nextLine().split("");
    Stack<String> asd = new Stack<>();
    String anw ="";
    for (String s : a) {
      if (s.equals(")")) {
        while (!asd.pop().equals("("));
      } else {
        asd.push(s);
      }
    }
    for (String s : asd) {
      anw += s;
    }
    System.out.println(anw);
  }
}
