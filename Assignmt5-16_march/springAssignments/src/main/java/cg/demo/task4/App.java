package cg.demo.task4;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-task4.xml");

        EmployeeService service = (EmployeeService) context.getBean("employeeService");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = service.getEmployeeDetails(id);

        if (emp != null) {
            System.out.println("Employee Info:");
            System.out.println(emp);
        } else {
            System.out.println("Employee not found");
        }

        sc.close();
        ((ClassPathXmlApplicationContext) context).close();
    }
}