/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author HP
 */
public class CalculatorServiceImpl extends UnicastRemoteObject implements CalculatorService {
       protected CalculatorServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public double suma(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

    @Override
    public double resta(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    @Override
    public double multiplicacion(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    @Override
    public double division(double num1, double num2) throws RemoteException {
        if (num2 == 0) {
            throw new RemoteException("No se puede dividir por cero");
        }
        return num1 / num2;
    }

    @Override
    public double mayor(double num1, double num2) throws RemoteException {
        return Math.max(num1, num2);
    }

    @Override
    public double promedio(double[] numeros) throws RemoteException {
        if (numeros.length == 0) {
            throw new RemoteException("Lista de números vacía");
        }
        double sum = 0;
        for (double num : numeros) {
            sum += num;
        }
        return sum / numeros.length;
    }

    public static void main(String[] args) {
        try {
            // Crear el objeto remoto
            CalculatorServiceImpl server = new CalculatorServiceImpl();

            // Registrar el objeto remoto en el registro RMI
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", server);

            System.out.println("Servidor de Calculadora listo...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
