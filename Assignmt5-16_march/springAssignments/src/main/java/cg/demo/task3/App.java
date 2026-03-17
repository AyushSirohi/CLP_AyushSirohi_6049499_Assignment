package cg.demo.task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-task3.xml");

        SBU sbu = (SBU) context.getBean("sbu");
        sbu.showSbuDetails();

        ((ClassPathXmlApplicationContext) context).close();
    }
}