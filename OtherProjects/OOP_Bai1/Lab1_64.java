import java.time.YearMonth;
import java.util.Scanner;

public class Lab1_64{
    
    public static int convertMonth(String monthInput) {
        try {
            int month = Integer.parseInt(monthInput);
            if (month >= 1 && month <= 12) {
                return month;
            }
        } catch (NumberFormatException e) {
            String[] months = {
                "January", "February", "March", "April", "May", "June", 
                "July", "August", "September", "October", "November", "December"
            };
            for (int i = 0; i < months.length; i++) {
                if (monthInput.equalsIgnoreCase(months[i]) || 
                    monthInput.equalsIgnoreCase(months[i].substring(0, 3))) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0, month = 0;
        
        do {
            System.out.print("Nhap nam: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year <= 0) {
                    System.out.println("Nam phai la so nguyen duong.");
                }
            } else {
                System.out.println("Vui long nhap so nguyen duong cho nam.");
                scanner.next();
            }
        } while (year <= 0);

        scanner.nextLine();
        
        
        do {
            System.out.print("Nhap thang (so, viet tat hoac ten day du: ");
            String monthInput = scanner.nextLine();
            month = convertMonth(monthInput);
            if (month < 1 || month > 12) {
                System.out.println("Thang khong hop le, vui long nhap lai.");
            }
        } while (month < 1 || month > 12);

        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth(); 


        System.out.println("Thang " + month + " nam " + year + " co " + daysInMonth + " ngay.");
    }
}
