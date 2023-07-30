class Solution {
  public String solution(String phone_number) {
    String answer = "";
    int len = phone_number.length();
    String num = phone_number.substring(len-4);

    for(int i =0; i< len-4; i++)
      answer += "*";

    return answer+num;
  }
}
