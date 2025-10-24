package com.example;

import java.util.List;

import com.example.Area;
import com.example.Empleado;
import com.example.RegistroTurno;
import com.example.TipoTurno;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.Optional;

public class EmpleadoStream {
    
    
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
   new RegistroTurno("E01", java.time.LocalDate.of(2025, 10, 1), TipoTurno.NOCHE, 12),
    new RegistroTurno("E02", java.time.LocalDate.of(2025, 10, 1), TipoTurno.DIA, 8),
    new RegistroTurno("E01", java.time.LocalDate.of(2025, 10, 2), TipoTurno.NOCHE, 12),
    new RegistroTurno("E03", java.time.LocalDate.of(2025, 10, 2), TipoTurno.DIA, 8),
    new RegistroTurno("E01", java.time.LocalDate.of(2025, 10, 3), TipoTurno.NOCHE, 12), // 3 noches seguidas para E01
    new RegistroTurno("E04", java.time.LocalDate.of(2025, 10, 3), TipoTurno.DIA, 8),
    new RegistroTurno("E02", java.time.LocalDate.of(2025, 10, 4), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E05", java.time.LocalDate.of(2025, 10, 4), TipoTurno.NOCHE, 12),
    new RegistroTurno("E06", java.time.LocalDate.of(2025, 10, 5), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E11", java.time.LocalDate.of(2025, 10, 5), TipoTurno.GUARDIA, 12), // Guardia de 12h
    new RegistroTurno("E09", java.time.LocalDate.of(2025, 10, 6), TipoTurno.DIA, 8),
    new RegistroTurno("E10", java.time.LocalDate.of(2025, 10, 6), TipoTurno.DIA, 8),
    new RegistroTurno("E08", java.time.LocalDate.of(2025, 10, 6), TipoTurno.AUSENCIA, 0),
    new RegistroTurno("E02", java.time.LocalDate.of(2025, 10, 7), TipoTurno.DIA, 8), // Después de guardia
    new RegistroTurno("E12", java.time.LocalDate.of(2025, 10, 8), TipoTurno.NOCHE, 12),
    new RegistroTurno("E13", java.time.LocalDate.of(2025, 10, 8), TipoTurno.NOCHE, 12),
    new RegistroTurno("E07", java.time.LocalDate.of(2025, 10, 9), TipoTurno.DIA, 8),
    new RegistroTurno("E14", java.time.LocalDate.of(2025, 10, 10), TipoTurno.DIA, 8),
    new RegistroTurno("E15", java.time.LocalDate.of(2025, 10, 11), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E01", java.time.LocalDate.of(2025, 10, 11), TipoTurno.AUSENCIA, 0),
    new RegistroTurno("E06", java.time.LocalDate.of(2025, 10, 12), TipoTurno.DIA, 8),
    new RegistroTurno("E09", java.time.LocalDate.of(2025, 10, 13), TipoTurno.NOCHE, 12),
    new RegistroTurno("E99", java.time.LocalDate.of(2025, 10, 13), TipoTurno.DIA, 8), // Empleado inexistente
    new RegistroTurno("E03", java.time.LocalDate.of(2025, 10, 14), TipoTurno.GUARDIA, 24),
    new RegistroTurno("E05", java.time.LocalDate.of(2025, 10, 15), TipoTurno.DIA, 8)
);
//==================================Nómina Mensual Detallada==================================
  public static final Map<String, Double> NOMINAMES = personal.stream()
    .collect(Collectors.toMap(
        Empleado::nombre,
        emp -> registrosMes.stream()
            .filter(r -> r.empleadoId().equals(emp.id()))
            //.filter(r -> r.tipo() != TipoTurno.AUSENCIA)
            .mapToDouble(r -> emp.salarioBaseHora() * 
                switch(r.tipo()) {
                    case DIA -> 1.0; 
                    case NOCHE -> 1.5; 
                    case GUARDIA -> 2.0; 
                    default -> 0.0;
                } * r.horas()
            ).sum()
    ));
                          
          
  //==================================  Empleado del Mes por Área: =================================
   public static final Map<Area, Optional<Empleado>> EMPLEADO_DEL_MES = personal.stream()
    .collect(Collectors.groupingBy(
        Empleado::area,
        Collectors.mapping(
            emp -> Map.entry(emp, registrosMes.stream()
                .filter(r -> r.empleadoId().equals(emp.id()))
                .filter(r -> r.tipo() != TipoTurno.AUSENCIA)
                .mapToInt(RegistroTurno::horas)
                .sum()),
            Collectors.maxBy((a, b) -> Integer.compare(a.getValue(), b.getValue()))
        )
    ))
    .entrySet().stream()
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        entry -> entry.getValue().map(Map.Entry::getKey)
    ));
  //================================== HORAS POR AREA Y TIPO DE TURNO====================  
    public static Map<area,Map<turno,hora>> horasArea = personal.stream()
                          .collect(Collectors.groupingBy(
                            Empleado::area,
                                  Collectors.flatMapping(emp -> registrosMes.stream()
                                            .filter(r -> emp.id().equals(r.EmpleadoId()))
                                            .map(r -> Map.entry((r.tipo),(r.hora))),
                                          
                                     Collectors.groupingBy(
                                        RegistroTurno::tipo,
                                           
                                     )     
                          ))
  //================================== TURNOS CONSECUTIVOS ==============================
  //================================== INCONSISTENCIAS ==================================
  //================================== PRODUCTIVIDAD ====================================
  //================================== AUDITORIA ========================================
  //================================== BONUS ============================================
  //================================== COSTO OPERATIVO ==================================
   public static void main(String[] args) {
            /*  NOMINAMES.forEach((nombre,total) -> {
              System.out.println( nombre + "   = " + total );
             });

              System.out.println();
              System.out.println("EMPLEADO DEL MES");
             EMPLEADO_DEL_MES.forEach((area, empleado) -> {
                String resul = empleado
                       .map(e -> area +":"+ e.nombre())
                       .orElse(area +":"+ "NO HAY EMPLEADO");
                System.out.printf("%-15s: %n",resul);
             });
             System.out.println();
             System.out.println();*/
             HORAS_POR_AREA_Y_TURNO.forEach((area,trunoMap)->{
                trunoMap.forEach((turno2,hora) -> {
                     System.out.println(area+"-"+turno2+"-"+hora);
                });
             });

             
   }
}
