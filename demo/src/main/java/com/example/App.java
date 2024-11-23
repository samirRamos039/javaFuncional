package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

     static List<Object> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
    
       List<Integer> i = IntStream.rangeClosed(3, 9)
                                  .filter(p -> p %2 == 1)         
                                  .boxed()
                                  .collect(Collectors.toList());
                             
          System.out.println("====================");                        

          i.forEach(System.out::print);                         
             
          System.out.println("");
          System.out.println("====================");  

        list.add("hello world");
        list.add(2020);
        list.add(20.3);
        list.add(true);
        list.add(30);
        Supplier<LocalDate> date = LocalDate::now;
        list.forEach(System.out::println);
        System.out.println(date.get());
        System.out.println("=========================");
        List<Object>filtro = list.stream().filter(p -> p.equals(true))
                     .collect(Collectors.toList());

        filtro.forEach(System.out::println);   
               
}
}
