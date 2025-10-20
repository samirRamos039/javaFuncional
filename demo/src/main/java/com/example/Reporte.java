package com.example;

import java.com.example.model.Area;
import java.com.example.model.Empleado;
import java.com.example.model.RegistroTurno;
import java.com.example.model.TipoTurno;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;
public class Reporte{

    public static void main(String[]arg){

        List<Empleado> personal = List.of(
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

List<RegistroTurno> registrosMes = List.of(
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


public static Map<String, Integer> horasTrabajadasPorEmpleado = registrosMes.stream()
        .filter(registro -> registro.tipo() != TipoTurno.AUSENCIA)
        .collect(Collectors.groupingBy(
            RegistroTurno::empleadoId,
            Collectors.summingInt(RegistroTurno::horas)
        ));
        
         System.out.println("=== MAPA DE HORAS TRABAJADAS POR EMPLEADO ===");
        System.out.println("Tipo: " + horasTrabajadasPorEmpleado.getClass().getSimpleName());
        System.out.println("Contenido: " + horasTrabajadasPorEmpleado);


    }
}
