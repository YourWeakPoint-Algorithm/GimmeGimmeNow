package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        char [] a = str.toCharArray();
        for(int i=0;i<str.length()/2;i++){
            if (Character.toLowerCase(a[i]) != Character.toLowerCase(a[a.length - (i + 1)])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

