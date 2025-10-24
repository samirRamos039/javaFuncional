package com.example;

import com.example.Area;
import com.example.Empleado;
import com.example.RegistroTurno;
import com.example.TipoTurno;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Reporte{

    static List<Empleado> personal = List.of(
    new Empleado("E01", "Ana Gómez", Area.CARDIOLOGIA, 25.0),
    new Empleado("E02", "Luis Vera", Area.CIRUGIA, 45.0),
    new Empleado("E03", "Carlos Rivas", Area.PEDIATRIA, 28.0),
    new Empleado("E04", "Juan Mora", Area.CARDIOLOGIA, 22.0),
    new Empleado("E05", "Sofía Castro", Area.ONCOLOGIA, 35.0),
    new Empleado("E06", "Miguel Peña", Area.URGENCIAS, 38.0),
    new Empleado("E07", "Laura Díaz", Area.ADMINISTRACION, 18.0),
    new Empleado("E08", "Fernando Gil", Area.RADIOLOGIA, 33.0),
    new Empleado("E09", "Isabel Luna", Area.CIRUGIA, 48.0),
    new Empleado("E10", "Pedro Navas", Area.PEDIATRIA, 29.0),
    new Empleado("E11", "Valeria Sol", Area.URGENCIAS, 40.0),
    new Empleado("E12", "Ricardo León", Area.CARDIOLOGIA, 26.5),
    new Empleado("E13", "Mónica Marín", Area.ONCOLOGIA, 36.0),
    new Empleado("E14", "Andrés Salas", Area.ADMINISTRACION, 19.5),
    new Empleado("E15", "Gabriela Paz", Area.RADIOLOGIA, 34.5)
);

    static List<RegistroTurno> registrosMes = List.of(
    new RegistroTurno("E01", LocalDate.of(2024, 10, 1), TipoTurno.NOCHE, 12),
    new RegistroTurno("E02", LocalDate.of(2024, 10, 1), TipoTurno.DIA, 8),
    new RegistroTurno("E01", LocalDate.of(2024, 10, 2), TipoTurno.AUSENCIA, 0),
    new RegistroTurno("E04", LocalDate.of(2024, 10, 2), TipoTurno.DIA, 8),
    new RegistroTurno("E02", LocalDate.of(2024, 10, 3), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E01", LocalDate.of(2024, 10, 3), TipoTurno.NOCHE, 12),
    new RegistroTurno("E04", LocalDate.of(2024, 10, 4), TipoTurno.NOCHE, 12),
    new RegistroTurno("E01", LocalDate.of(2024, 10, 5), TipoTurno.DIA, 8),
    new RegistroTurno("E02", LocalDate.of(2024, 10, 5), TipoTurno.DIA, 8),
    new RegistroTurno("E04", LocalDate.of(2024, 10, 6), TipoTurno.AUSENCIA, 0),
    new RegistroTurno("E01", LocalDate.of(2024, 10, 7), TipoTurno.NOCHE, 12),
    new RegistroTurno("E02", LocalDate.of(2024, 10, 8), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E04", LocalDate.of(2024, 10, 8), TipoTurno.DIA, 8),
    new RegistroTurno("E01", LocalDate.of(2024, 10, 9), TipoTurno.DIA, 8),
    new RegistroTurno("E02", LocalDate.of(2024, 10, 10), TipoTurno.DIA, 8)
);
 //================================HORAS TRABAJADAS================================   
    public static  Map<String, Integer> horasTrabajadas = registrosMes.stream()
        .filter(registro -> registro.tipo() != TipoTurno.AUSENCIA)
        .collect(Collectors.groupingBy(
            RegistroTurno::empleadoId,
            Collectors.summingInt(RegistroTurno::horas)
        ));

//===================================TURNOS POR GUARDIA==============================

  public static List<String> TurnoGuardia = registrosMes.stream()
       .filter(emp -> emp.tipo() == TipoTurno.GUARDIA)
       .map(RegistroTurno::empleadoId)
       .distinct()
       .map(Id-> personal.stream()
               .filter(emp -> emp.id().equals(Id)))
               .findFirst()
               .map(Empleado::nombre)
               .orElse()
               .toList();


    public static void main(String[]arg){

        horasTrabajadas.forEach((id, horas) -> 
            System.out.println(id + " = " + horas + " horas"));
        
        System.out.println();

        TurnoGuardia.forEach(nombre -> 
                System.out.println(nombre));

    }
}
