package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);

        List<Integer>filtro = list.stream()
            .filter(p->p<=4)
            .collect(Collectors.toList());

            filtro.forEach(System.out::println);
                                   
    }
}