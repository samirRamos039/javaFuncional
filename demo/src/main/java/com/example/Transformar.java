package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transformar {

    public static void main(String[] args) {
         List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 🎯 ENFOQUE DECLARATIVO - QUÉ hacer, no CÓMO
        int resultado = numeros.stream()
                .filter(n -> n % 2 == 0)      // Filtrar pares
                .map(n -> n * n)              // Elevar al cuadrado
                .reduce(0, Integer::sum);     // Sumar todos
                
        System.out.println("Resultado declarativo: " + resultado);
        
        // Versión con recolección en lista intermedia
        List<Integer> cuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
                
        System.out.println("Cuadrados de pares: " + cuadradosPares);

//=========================================================================================================
         List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 
        List<Integer> cuadradosPares1 = new ArrayList<>();
        int resultado1 = 0;
        
        for (int i = 0; i < numeros1.size(); i++) {
            int numero = numeros1.get(i);
            
            if (numero % 2 == 0) {
                int cuadrado = numero * numero;
                cuadradosPares1.add(cuadrado);
                resultado1 += cuadrado;
            }
        }
        
        System.out.println("Resultado imperativo: " + resultado1);
        System.out.println("Cuadrados de pares: " + cuadradosPares1);
    }
    
}
