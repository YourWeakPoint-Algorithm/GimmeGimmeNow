package ex;

import java.util.Arrays;
import java.util.Scanner;

public class i피보나치수열_비버 {
    import java.util.*;

    public class Main {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int[] a = new int[num];
            for (int i = 0; i < num; i++) {
                if (i == 0 || i == 1) {
                    a[i] = 1;
                } else a[i] = a[i - 1] + a[i - 2];
            }
            Arrays.stream(a).forEach(it -> System.out.print(it+" "));
        }
    }
}
