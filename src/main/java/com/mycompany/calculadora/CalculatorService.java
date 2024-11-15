/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.calculadora;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author HP
 */
public interface CalculatorService {
      // Métodos remotos que pueden ser invocados por los clientes
    double suma(double num1, double num2) throws RemoteException;
    double resta(double num1, double num2) throws RemoteException;
    double multiplicacion(double num1, double num2) throws RemoteException;
    double division(double num1, double num2) throws RemoteException;
    double mayor(double num1, double num2) throws RemoteException;
    double promedio(double[] numeros) throws RemoteException;
}
