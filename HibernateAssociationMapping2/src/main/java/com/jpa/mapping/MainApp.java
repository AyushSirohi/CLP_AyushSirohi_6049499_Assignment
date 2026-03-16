package com.jpa.mapping;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();

        while (true) {
            System.out.println("\n===== EMPLOYEE DEPARTMENT MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Fetch all employees with department and manager");
            System.out.println("3. Fetch number of employees in each department");
            System.out.println("4. Fetch employees by department name");
            System.out.println("5. Fetch department details by mobile number");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    Employee emp = new Employee();
                    Department dept = new Department();

                    System.out.print("Enter Employee Id: ");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    emp.setName(sc.nextLine());

                    System.out.print("Enter Employee Salary: ");
                    emp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    Set<String> mobiles = new HashSet<>();
                    System.out.print("How many mobile numbers do you want to enter? ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 1; i <= n; i++) {
                        System.out.print("Enter mobile number " + i + ": ");
                        mobiles.add(sc.nextLine());
                    }

                    emp.setMobileNumbers(mobiles);

                    System.out.print("Enter Department Id: ");
                    dept.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Department Name: ");
                    dept.setName(sc.nextLine());

                    System.out.print("Enter Manager Name: ");
                    dept.setManagerName(sc.nextLine());

                    dao.insertEmployee(emp, dept);
                    break;

                case 2:
                    dao.fetchAllEmployees();
                    break;

                case 3:
                    dao.countEmployeesByDepartment();
                    break;

                case 4:
                    System.out.print("Enter Department Name: ");
                    String deptName = sc.nextLine();
                    dao.employeesByDepartmentName(deptName);
                    break;

                case 5:
                    System.out.print("Enter Mobile Number: ");
                    String mobile = sc.nextLine();
                    dao.departmentDetailsByMobile(mobile);
                    break;

                case 6:
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