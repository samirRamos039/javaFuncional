package com.example;

import java.util.*;
import java.util.stream.*;

public class Tokeriza {
    public static void main (String[]arg){

      Scanner scn = new Scanner(System.in);
        String s = scn.nextLine().trim();

        if(s.isEmpty()){
            System.out.println(0);
        }

        List<String> tokens = Arrays.stream(s.split("[^A-Za-z]+"))
                             .filter(token -> !token.isEmpty())
                             .collect(Collectors.toList());

        System.out.println(tokens.size());
        tokens.forEach(System.out::println);                
        }
        
    }

