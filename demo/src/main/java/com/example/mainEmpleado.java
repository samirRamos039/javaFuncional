package com.example;

import java.util.List;

public class mainEmpleado {
    
    public record Empleado(String nombre, String area, double salario, int aniosDeServicio){}

    public static void main(String[] args) {
        List<Empleado> empleados = List.of(
            new Empleado("Ana", "TI", 75000, 5),
            new Empleado("Beto", "Marketing", 60000, 3),
            new Empleado("Carlos", "TI", 90000, 8),
            new Empleado("Diana", "Ventas", 55000, 2),
            new Empleado("Elena", "Marketing", 80000, 7),
            new Empleado("Fernando", "Ventas", 58000, 4),
            new Empleado("Gaby", "TI", 120000, 10)
        );
    };
}
