class Solution {
    public int solution(int a, int b) {
        String stringa = Integer.toString(a);
        String stringb = Integer.toString(b);

        if (Integer.parseInt(stringa + stringb) > Integer.parseInt(stringb + stringa)) {
            return Integer.parseInt(stringa + stringb);
        }
        return Integer.parseInt(stringb + stringa);
    }
}
