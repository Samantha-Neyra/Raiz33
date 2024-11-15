/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

/**
 *
 * @author HP
 */

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class CalculatorClient {
    
     public static void main(String[] args) {
        try {
            // Obtener el registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Buscar el objeto remoto en el registro
            CalculatorService calculator = (CalculatorService) registry.lookup("CalculatorService");

            // Interacción con el usuario
            Scanner scanner = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                System.out.println("\nElija una operación:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Mayor de dos números");
                System.out.println("6. Promedio de una lista de números");
                System.out.println("0. Salir");

                int opcion = scanner.nextInt();
                double resultado = 0;

                switch (opcion) {
                    case 1: // Suma
                        System.out.print("Ingrese el primer número: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        double num2 = scanner.nextDouble();
                        resultado = calculator.suma(num1, num2);
                        break;

                    case 2: // Resta
                        System.out.print("Ingrese el primer número: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = scanner.nextDouble();
                        resultado = calculator.resta(num1, num2);
                        break;

                    case 3: // Multiplicación
                        System.out.print("Ingrese el primer número: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = scanner.nextDouble();
                        resultado = calculator.multiplicacion(num1, num2);
                        break;

                    case 4: // División
                        System.out.print("Ingrese el numerador: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Ingrese el denominador: ");
                        num2 = scanner.nextDouble();
                        try {
                            resultado = calculator.division(num1, num2);
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case 5: // Mayor de dos números
                        System.out.print("Ingrese el primer número: ");
                        num1 = scanner.nextDouble();
                        System.out.print("Ingrese el segundo número: ");
                        num2 = scanner.nextDouble();
                        resultado = calculator.mayor(num1, num2);
                        break;

                    case 6: // Promedio de una lista de números
                        System.out.print("Ingrese la cantidad de números para calcular el promedio: ");
                        int n = scanner.nextInt();
                        double[] numeros = new double[n];
                        for (int i = 0; i < n; i++) {
                            System.out.print("Ingrese el número " + (i + 1) + ": ");
                            numeros[i] = scanner.nextDouble();
                        }
                        try {
                            resultado = calculator.promedio(numeros);
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case 0: // Salir
                        salir = true;
                        break;

                    default:
                        System.out.println("Opción inválida. Inténtelo de nuevo.");
                }

                if (!salir) {
                    System.out.println("Resultado: " + resultado);
                }
            }

            System.out.println("Sesión terminada.");

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
