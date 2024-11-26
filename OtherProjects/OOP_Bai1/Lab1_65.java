import java.util.Scanner;

public class Lab1_65 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int a, b, x, y;

        System.out.println("Number of rows: ");
        a = scanner.nextInt();
        System.out.println("Number of columns: ");
        b  = scanner.nextInt();

        int arr1[][] = new int[a][b];
        int arr2[][] = new int[a][b];
        int sum[][] = new int[a][b];

        System.out.println("Input of first matrix");

        for (x = 0 ; x < a ; x++){
            for (y = 0 ; y < b ; y++ ){
                arr1[x][y] = scanner.nextInt();
            }
        }
        System.out.println("Input of second matrix");
        for (x = 0 ; x < a ; x++ ){
            for ( y = 0 ; y < b ; y++ ){
                arr2[x][y] = scanner.nextInt();
            }
        }
        for (x = 0 ; x < a ; x++ ){
            for (y = 0 ; y < b ; y++ ){
                sum[x][y] = arr1[x][y] + arr2[x][y];
            }
        }
        System.out.println("Sum of the matrices: ");
        for ( x = 0 ; x < a ; x++ ){
            for ( y = 0 ; y < b ; y++ ){
                System.out.print(sum[x][y]+"\t");
            }
        }
            System.out.println();
        }
    }
