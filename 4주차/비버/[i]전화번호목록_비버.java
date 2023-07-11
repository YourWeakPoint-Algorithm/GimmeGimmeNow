package ex;

import java.util.Arrays;

public class i전화번호목록_비버 {
    import java.util.*;
    class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;
        }
    }
}
