import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    char[] str1 = sc.nextLine().toUpperCase().toCharArray();
    char[] str2 = sc.nextLine().toUpperCase().toCharArray();

    Map<Character, Integer> asd = new HashMap<>();

    for (char x : str1) {
      asd.put(x, asd.getOrDefault(x, 0) + 1);
    }

    for (char x : str2) {
      if (!asd.containsKey(x) || asd.get(x) == 0) {
        System.out.println("NO");
        return;
      }
      asd.put(x, asd.get(x) - 1);
    }

    System.out.println("YES");
  }
}
