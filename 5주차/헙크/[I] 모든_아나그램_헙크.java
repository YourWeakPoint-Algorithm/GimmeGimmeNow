import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(solution(S, T));
    }

    private static int solution(String s, String t) {
        int result = 0, lt = 0;
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 초기 윈도우 설정
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length() - 1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = t.length() - 1; i < s.length(); i++, lt++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.equals(target)) {
                result++;
            }
            if (map.get(s.charAt(lt)) == 1) {
                map.remove(s.charAt(lt));
            } else {
                map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
            }
        }
        return result;
    }
}