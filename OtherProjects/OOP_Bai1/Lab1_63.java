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
public class Lab1_63 {
    public static void main(String[] args){
        System.out.println("Please enter n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++){
            for(int j = (n-1); j >= i; j--){
                System.out.print(" ");
            }
            for (int k = 1; k <= (2*i -1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
