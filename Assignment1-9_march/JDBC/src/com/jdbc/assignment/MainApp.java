package com.jdbc.assignment;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAOImpl();

        while (true) {
            System.out.println("\n===== JDBC MENU =====");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Update Data based on Employee Id");
            System.out.println("4. Delete Record based on Employee Id");
            System.out.println("5. Fetch All Records");
            System.out.println("6. Fetch Record based on Employee Id");
            System.out.println("7. Drop Table");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.createTable();
                    break;

                case 2:
                    Employee emp = new Employee();

                    System.out.print("Enter Employee Id: ");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    emp.setName(sc.nextLine());

                    System.out.print("Enter Salary: ");
                    emp.setSalary(sc.nextDouble());
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    emp.setDepartment(sc.nextLine());

                    dao.insertEmployee(emp);
                    break;

                case 3:
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

                case 4:
                    System.out.print("Enter Employee Id to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteEmployee(deleteId);
                    break;

                case 5:
                    dao.fetchAllEmployees();
                    break;

                case 6:
                    System.out.print("Enter Employee Id to fetch: ");
                    int fetchId = sc.nextInt();
                    dao.fetchEmployeeById(fetchId);
                    break;

                case 7:
                    dao.dropTable();
                    break;

                case 8:
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