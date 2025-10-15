package com.example;

import java.util.stream.IntStream;

public class Multy {

    public static void main(String[] args) {
        
    
    
   /*  for(int i =0;i<=10;i++){
        System.out.println();
        System.out.println("TABLA DEL"+i);
        System.out.println();
        for(int j =0;j<=10;j++){
            int result = i*j;
            System.out.println(i+"x"+j+"="+result);
            System.out.print("");
        }
    }*/
   IntStream.rangeClosed(0, 10)
    .forEach(i -> {
        System.out.printf("%nTABLA DEL %d%n%n", i);
        IntStream.rangeClosed(0, 10)
            .mapToObj(j -> String.format("%dx%d=%d", i, j, i * j))
            .forEach(System.out::println);
    });


}

}
