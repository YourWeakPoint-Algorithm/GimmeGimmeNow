package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int value = sc.nextInt();
            if (i == 0 || value > a.get(a.size() - 1)) {
                a.add(value);
            } else {
                a.set(a.size() - 1, value);
            }
        }

        a.forEach(ab -> System.out.print(ab + " "));
    }
}
