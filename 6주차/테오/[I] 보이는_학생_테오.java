import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public int solution(int size, String line) {
        String[] splitString = line.split(" ");
        List<Integer> list = Arrays.stream(splitString)
                .map(each -> Integer.parseInt(each))
                .collect(Collectors.toList());

        int result = 0;
        int beforeMax = -1;
        for (int each : list) {
            if (each > beforeMax) {
                result++;
                beforeMax = each;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String line = in.nextLine();
        System.out.println(new Main().solution(size, line));
        return ;
    }
}
