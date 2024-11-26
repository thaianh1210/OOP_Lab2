/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Lab1_225 {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please enter the first number: ", "Enter the first number: ", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please enter the second number: ", "Enter the second number: ", JOptionPane.INFORMATION_MESSAGE);
        double Num1 = Double.parseDouble(strNum1);
        double Num2 = Double.parseDouble(strNum2);
        double sum = Num1 + Num2;
        double difference = Math.abs(Num1 - Num2);
        double product = Num1 * Num2;
        double quotient = Num1 / Num2;
        JOptionPane.showMessageDialog(null, Num1 + "+" + Num2 + "=" + sum + "\n"+
                Num1 + " diff " + Num2 + "=" + difference + "\n" + 
                Num1 + "*" + Num2 + "=" + product + "\n" +
                Num1 + "/" + Num2 + "=" + quotient + "\n");
        System.exit(0);
    }
}
