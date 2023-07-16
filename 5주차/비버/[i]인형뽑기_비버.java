import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[][] board = new int[num][num];
    Stack<Integer> moves = new Stack<>();

    int anw =0;

    for (int i = 0; i < num; i++) {
      for (int j = 0; j < num; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    int ms = sc.nextInt();
    for (int i = 0; i < ms; i++) {
      int num2 = sc.nextInt();
      for (int j = 0; j< board.length; j++) {
        if (board[j][num2 -1] != 0) {
          int a = board[j][num2 -1];
          board[j][num2 - 1] = 0;
          if (moves.isEmpty() || moves.peek() != a) {
            moves.add(a);
          } else {
            anw++;
            moves.pop();
          }
          break;
        }

      }
    }
    System.out.println(2*anw);
  }
}
