/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Scanner;

public class Lab1_226 {
    static void first_degree() {
        Scanner scanner = new Scanner(System.in);
        double a , b , x ;
        System.out.println(" a = ");
        a = scanner.nextDouble();
        System.out.println(" b =");
        b= scanner.nextDouble() ;
        if(a==0) {
            System.out.println(" Wrong input! Please re-enter! ");
            first_degree();
        }
        x=-b/a ;
        System.out.println("The value of x"+"="+x);
        System.exit(0);
    }
    static void system_first_degree() {
        Scanner scanner = new Scanner(System.in);
        double a11,a12,b1 ,a21, a22, b2 , x1,x2 ;
        System.out.println(" a11 = ");
        a11 = scanner.nextDouble();
        System.out.println(" a12 = ");
        a12 = scanner.nextDouble();
        System.out.println(" b1 =");
        b1= scanner.nextDouble() ;
        System.out.println(" a21 = ");
        a21 = scanner.nextDouble();
        System.out.println(" a22 = ");
        a22 = scanner.nextDouble();
        System.out.println(" b2 =");
        b2= scanner.nextDouble() ;
        double D, D1,D2 ;
        D = a11*a22 - a21*a12 ;
        D1 = b1*a22-b2*a12 ;
        D2 = a11*b2 - a21*b1;
        if (D!=0) {
            x1=D1/D;
            x2=D2/D;
            System.out.println("x1"+"="+ x1 +"\n");
            System.out.println("x2"+"="+ x2 +"\n");
        }
        else if(D==0 && (D1!= 0 || D2!= 0)) {
            System.out.println("Can't solution");
        }
        else if(D==0 && D1==0 && D2==0) {
            System.out.println("Infinite Solution: "+ a11+"x1"+"+"+a12+"x2"+"="+b1);

        }
    }
    static void second_degree() {
        Scanner scanner = new Scanner(System.in);
        double a , b,c , x ,x1,x2 ;
        System.out.println(" a = ");
        a = scanner.nextDouble();
        System.out.println(" b =");
        b= scanner.nextDouble() ;
        System.out.println(" c =");
        c = scanner.nextDouble() ;
        if(a==0) {
            System.out.println("This is first_degree equation");
            first_degree();
        }
        double delta ;
        delta = b*b-4*a*c ;
        if(delta>0) {
            x1 = (-b + Math.sqrt(delta))/ (2*a) ;
            x2 = (-b - Math.sqrt(delta))/ (2*a) ;
            System.out.println("The equation has two distinct roots: \n");
            System.out.println("x1 =" + x1 +"\n");
            System.out.println("x2 =" + x2 +"\n");
        }
        else if(delta == 0) {
            x = -b/(2*a) ;
            System.out.println("The equation has a unique root: "+ x);
        }
        else if(delta < 0) {
            System.out.println("No solution ");
        }
        System.exit(0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1.First-degree equation (linear equation) with one variable \n");
            System.out.println("2. System of first-degree equations (linear system) with two variables \n");
            System.out.println("3. Second-degree equation with one variable \n");
            System.out.println("4. Exit \n");

            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Option 1");
                    first_degree();
                    break;
                case 2:
                    System.out.println("Option 2");
                    system_first_degree();
                    break;
                case 3:
                    System.out.println("Option 3");
                    second_degree();
                    break;
                case 4:
                    System.out.println("Exit program");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please re-enter");
            }
        }


    }
}
