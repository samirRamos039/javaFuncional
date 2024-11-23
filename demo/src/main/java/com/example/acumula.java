package com.example;

import java.util.stream.IntStream;

public class acumula {

     public static void main(String[] args) {
        
 // El arreglo de enteros
 int[] arreglo = {1, 2, 3, 4, 5, 6};

 // Variable para almacenar la suma acumulada
 final int[] suma = {0};  // Usamos un array para modificar el valor dentro del lambda

 // Procesamos cada valor y acumulamos la suma
 IntStream.of(arreglo)
          .forEach(valor -> {
              // Imprimimos los valores anteriores antes de la suma
              if (suma[0] > 0) {
                  System.out.print("Valores anteriores: ");
                  for (int i = 0; i < suma[0]; i++) {
                      System.out.print(arreglo[i] + " ");
                  }
                  System.out.println();
              }

              suma[0] += valor;  
              System.out.println("Suma acumulada: " + suma[0]);
    

    });
}
}
