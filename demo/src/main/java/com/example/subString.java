package com.example;

public class subString {

    public static void main(String[] args) {
        
        String input = "bienvenido a java";
        String palabra = input.replaceAll("\\s+", "");;

       while (!palabra.equals("")) {
          String frase = palabra.substring(0,3);
         // palabra = frase;
         palabra = palabra.replace(frase,"");
        
            System.out.print(frase+" ");
          }
       }
}
