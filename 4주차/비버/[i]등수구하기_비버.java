package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] a = new int[num];


        for (int i = 0; i < num; i++) {
            a[i] = sc.nextInt();
        }
        int[] anw = Arrays.copyOf(a, num);
        Arrays.sort(anw);
        System.out.println(Arrays.toString(anw));
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (a[i] == anw[j]) System.out.print(num - j + " ");
            }
        }
    }
}
