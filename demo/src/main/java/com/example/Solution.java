package com.example;

import java.util.Scanner;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Si tienen diferente longitud, no pueden ser anagramas
        if (a.length() != b.length()) {
            return false;
        }
        
        // Convertir a minúsculas, dividir en caracteres, ordenar y unir
        String sortedA = Arrays.stream(a.toLowerCase().split(""))
                              .sorted()
                              .collect(Collectors.joining());
        
        String sortedB = Arrays.stream(b.toLowerCase().split(""))
                              .sorted()
                              .collect(Collectors.joining());
        
        // Comparar los strings ordenados
        return sortedA.equals(sortedB);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        
        boolean ret = isAnagram(a, b);
        System.out.println(ret ? "Anagrams" : "Not Anagrams");
    }
}