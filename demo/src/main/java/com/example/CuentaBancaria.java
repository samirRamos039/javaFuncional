package com.example;

abstract class Cuenta {

   private String numeroCuenta;
   private Double saldo;

   public Cuenta(String numeroCuenta, double saldo){

       this.numeroCuenta = numeroCuenta;
       this.saldo = saldo;
   }

   public double getSaldo(){
    return saldo;
   }

   public void setSaldo(double saldo){
     this.saldo = saldo;
   }

   public String getCuenta(){
    return numeroCuenta;
   }

   public void setCuenta(String numeroCuenta){
     this.numeroCuenta = numeroCuenta;

   }
    
}

class CuentaAhorro extends Cuenta{

   private double interes;

   public CuentaAhorro(String numeroCuenta, double interes, double saldoInicial){
          super(numeroCuenta,saldoInicial );
          this.interes = interes;

   }

}
