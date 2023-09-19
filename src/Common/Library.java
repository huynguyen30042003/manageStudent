package Common;

import java.util.ArrayList;
import java.util.Scanner;

import Model.StudentInfomation;

public class Library {
    public static int getInt(String promt, int m, int n) {
        int a = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }  
        }
        return a;
    }

    public static String validStudentID(String promt,ArrayList<StudentInfomation> dataStudent) {
        Scanner scanner = new Scanner(System.in);
        String id;
        System.out.println(promt);
        id = scanner.nextLine();
        while (!id.matches("[A-Z]{2}\\d{5}")) {
            System.out.println("Invalid student id. please enter a valid id student");
            id = scanner.nextLine();
        }
        return id;
    }

    public static String validString(String promt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(promt + ":");
        String Str = sc.nextLine();
        return Str;
    }

    public static String validSourse(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Sourse: Java, .Net, C/C++");
        String rankOfGraduation = sc.nextLine();
        while (!rankOfGraduation.matches("Java||.Net||C/C++")) {
            System.out.print(
                    "Invalid sourse. Please enter one of the following values: Java, .Net, C/C++: ");
            rankOfGraduation = sc.nextLine();
        }
        return rankOfGraduation;
    }
}
