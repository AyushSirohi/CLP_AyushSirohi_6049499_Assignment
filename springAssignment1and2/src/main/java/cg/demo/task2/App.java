package cg.demo.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-task2.xml");

        Employee emp = (Employee) context.getBean("emp");

        System.out.println("Employee details");
        System.out.println("---------------------");
        System.out.println(emp);
        System.out.println("sbu details=" + emp.getSbuDetails());

        ((ClassPathXmlApplicationContext) context).close();
    }
}