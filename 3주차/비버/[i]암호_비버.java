package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = sc.next();
        String answer = "";

        for (int i = 0; i < num; i++) {
            String substring = str.substring(i * 7, (i + 1) * 7);
            int asd = Integer.parseInt(substring.replace("#", "1").replace("*", "0"), 2);
            answer += (char) asd;
        }
        System.out.println(answer);
    }
}
