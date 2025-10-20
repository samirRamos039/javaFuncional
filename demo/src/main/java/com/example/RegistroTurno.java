package com.example;

public record RegistroTurno(String empleadoId, LocalDate fecha, TipoTurno tipo, int horas) {}
