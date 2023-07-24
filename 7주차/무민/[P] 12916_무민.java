class Solution {
  boolean solution(String s) {
    String[] split = s.split("");
    boolean answer;
    int pcnt = 0;
    int ycnt = 0;
    for (int i = 0; i < s.length(); i++) {
      if (split[i].equals("p") || split[i].equals("P")) {
        pcnt++;
      } else if (split[i].equals("y") || split[i].equals("Y")) {
        ycnt++;
      }
    }

    if (pcnt == ycnt) {
      answer = true;
    }else
      answer = false;

    return answer;
  }
}
