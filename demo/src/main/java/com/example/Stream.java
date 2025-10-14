package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {

    public static void main(String[]arg){

       List<String> name= Arrays.asList("claudia","pilar","carlos","miguel","diego");
                 List<String>result = name.stream()
                                          .map(n -> n.toUpperCase())
                                          .sorted()
                                          .collect(Collectors.toList());
                System.out.println(result);   
                
                
       List<Integer> number  = Arrays.asList(1,2,3,4,5,6,7,8,9);
                          int num = IntStream.rangeClosed(1,9)
                                          .map(n -> n * n)
                                          .sum();
                                          //.collect(Collectors.toList());
                                System.out.println(num);          

     //invertir string 
      String invertido = new StringBuilder("samir").reverse().toString(); 
            System.out.println(invertido);                          
    //contaar vocales 
    String vocal =  "samirRamosArboleda";
      long va = vocal.toLowerCase()
                     .chars()
                     .filter(v -> "a".indexOf(v) >=0)
                     .count();
         System.out.println("EL NUMERO DE VOCALES ES  "+ va);  
         
         
         

    }
    
}
