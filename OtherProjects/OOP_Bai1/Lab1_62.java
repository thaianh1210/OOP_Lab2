/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Lab1_62 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your name ?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you ?");
        int Age = keyboard.nextInt();
        System.out.println("How tall are you ?");
        double Height = keyboard.nextDouble();
        System.out.println("Mr." + strName + "," + Age + " years old. " + "Your height is "+ Height + ".");
    }
}
