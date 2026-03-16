package com.jpa.assignment;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();

        while (true) {
            System.out.println("\n===== JPA HIBERNATE MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee based on Id");
            System.out.println("3. Delete Employee based on Id");
            System.out.println("4. Fetch All Records");
            System.out.println("5. Fetch Record based on Id");
            System.out.println("6. Fetch Records based on Salary");
            System.out.println("7. Fetch All Records in Sorted Order of Salary");
            System.out.println("8. Fetch Complete Record based on Mobile Number");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Employee emp = new Employee();

                    System.out.print("Enter Employee Id: ");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    emp.setName(sc.nextLine());

                    System.out.print("Enter Employee Salary: ");
                    emp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Employee Department: ");
                    emp.setDepartment(sc.nextLine());

                    Set<String> mobiles = new HashSet<>();
                    System.out.print("How many mobile numbers do you want to add? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 1; i <= n; i++) {
                        System.out.print("Enter mobile number " + i + ": ");
                        mobiles.add(sc.nextLine());
                    }

                    emp.setMobileNumbers(mobiles);
                    dao.insertEmployee(emp);
                    break;

                case 2:
                    System.out.print("Enter Employee Id to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    dao.updateEmployee(updateId, newName, newSalary, newDept);
                    break;

                case 3:
                    System.out.print("Enter Employee Id to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 4:
                    dao.fetchAllEmployees();
                    break;

                case 5:
                    System.out.print("Enter Employee Id to fetch: ");
                    int fetchId = sc.nextInt();
                    dao.fetchEmployeeById(fetchId);
                    break;

                case 6:
                    System.out.print("Enter Salary to search: ");
                    double sal = sc.nextDouble();
                    dao.fetchEmployeeBySalary(sal);
                    break;

                case 7:
                    dao.fetchAllEmployeesSortedBySalary();
                    break;

                case 8:
                    sc.nextLine();
                    System.out.print("Enter Mobile Number to search: ");
                    String mobile = sc.nextLine();
                    dao.fetchEmployeeByMobileNumber(mobile);
                    break;

                case 9:
                    System.out.println("Program ended.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}