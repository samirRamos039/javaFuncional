package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class subSt {
    public static void main(String[] args){
        int k = 3;
        String p = "welcometojava";
         List<String> substrings = IntStream.range(0, p.length()-k+1)
                .mapToObj(i -> p.substring(i, i + k))                   
                .collect(Collectors.toList());
         substrings.forEach(System.out::println);       

         String min = IntStream.range(0, p.length()-k+1)
                               .mapToObj(i -> p.substring(i,i+k))
                               .min(String::compareToIgnoreCase)
                               .orElse("");
        String max = IntStream.range(0, p.length()-k+1)
                               .mapToObj(i -> p.substring(i,i+k))
                               .max(String::compareToIgnoreCase)
                               .orElse(""); 
         System.out.println();                       
         System.out.println(min); 
         System.out.println(max);                                           
                               
    }
}
