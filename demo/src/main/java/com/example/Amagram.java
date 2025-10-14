package com.example;

import java.util.Scanner;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Amagram {

    static boolean isAnagram(String a, String b){

        return Arrays.stream(a.toLowerCase().split(""))
                     .sorted()
                     .collect(Collectors.joining())
                     .equals(
                        Arrays.stream(b.toLowerCase().split(""))
                        .sorted()
                        .collect(Collectors.joining())
                     );

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String Frasea = scn.next();
        String Fraseb = scn.next();
        
        scn.close();
         boolean res = isAnagram(Frasea, Fraseb);
        System.out.println(res);
        
    }
    
}
