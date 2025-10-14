package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collector;


public class Primos {
    public static void main(String[] args) {
        List<Integer> num = IntStream.rangeClosed(1,100 )
                                     .filter(n -> n% 2 == 0)
                                     .boxed()
                                     .collect(Collectors.toList());
       num.forEach(System.out::println);                              
    }
}
