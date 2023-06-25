import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public static int solution(int[] priorities, int location) {
    final Queue<process> processes = new LinkedList<>();

    for (int index = 0; index < priorities.length; index++) {
      processes.add(new process(index, priorities[index]));
    }

    int answer = 1;
    while (!processes.isEmpty()) {
      final process poll = processes.poll();
      final int priority = poll.priority;

      if (isExecutable(processes, priority)) {
        if (poll.location == location) {
          break;
        }
        answer++;
      } else {
        processes.add(poll);
      }
    }

    return answer;
  }

  private static boolean isExecutable(Queue<process> processes, int priority) {
    return processes.stream().noneMatch(process -> priority < process.priority);
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
  }
}

class process {
  int location;
  int priority;

  public process(int location, int priority) {
    this.location = location;
    this.priority = priority;
  }
}
