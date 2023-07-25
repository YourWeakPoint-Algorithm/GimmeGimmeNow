class Solution {
  public int[] solution(int[] arr) {
    if(arr.length == 1)
      return new int[]{-1};

    int i, j, index = 0;
    int[] answer = new int[arr.length-1];

    for (i = 1; i < arr.length; i++) {
      if (arr[index] > arr[i]) {
        index = i ;
      }
    }

    for (i = 0, j = 0; j < answer.length; i++, j++) {
      if(i == index)
        i++;
      answer[j] = arr[i];
    }

    return answer;
  }
}
