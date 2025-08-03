package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramEmployee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            System.out.printf("Employee #%d data:%n", i);
            System.out.print("Outsourced (y/n)? ");
            char answer = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            if (answer == 'n') {
                Employee employee = new Employee(name, hours, valuePerHour);
                employees.add(employee);
            } else  {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();;
                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                employees.add(employee);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

        sc.close();
    }
}
