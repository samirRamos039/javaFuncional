package com.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class time {

     public static void main(String[] args) {

        /*Scanner scn = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        System.out.println("inserte un numero");
        int num1 = num.nextInt();
        System.out.println("inserte una palabra");*/
        String word = "Bienvenido a java";
        int num1 = 3;
        
        List <String> frase = IntStream.range(0,word.length())
                              .filter(n -> n% num1 == 0)
                              .mapToObj(i -> word.substring(i, Math.min(i + num1, word.length())))
                              .collect(Collectors.toList());
                              

        String mayor = frase.stream()
                            .max(String::compareTo)
                            .orElseThrow(); 
                                
        String menor = frase.stream()
                            .min(String::compareTo)
                            .orElseThrow(); 
                                     
        System.out.println(mayor);
        System.out.println(menor);                             
       
                             
                          
    }
}
