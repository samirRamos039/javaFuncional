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


         List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // 🎯 ENFOQUE IMPERATIVO - Especificar CÓMO hacerlo
        List<Integer> cuadradosPares1 = new ArrayList<>();
        int resultado1 = 0;
        
        // Ciclo for tradicional - especificamos cada paso
        for (int i = 0; i < numeros1.size(); i++) {
            int numero = numeros1.get(i);
            
            // Paso 1: Verificar si es par
            if (numero % 2 == 0) {
                // Paso 2: Elevar al cuadrado
                int cuadrado = numero * numero;
                
                // Paso 3: Agregar a la lista
                cuadradosPares1.add(cuadrado);
                
                // Paso 4: Acumular en la suma
                resultado1 += cuadrado;
            }
        }
        
        System.out.println("Resultado imperativo: " + resultado1);
        System.out.println("Cuadrados de pares: " + cuadradosPares1);
    }
    
}
