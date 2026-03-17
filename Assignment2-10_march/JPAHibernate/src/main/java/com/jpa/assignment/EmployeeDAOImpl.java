package com.jpa.assignment;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    @Override
    public void insertEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(emp);

        em.getTransaction().commit();
        em.close();

        System.out.println("Employee inserted successfully.");
    }

    @Override
    public void updateEmployee(int id, String name, double salary, String department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {
            emp.setName(name);
            emp.setSalary(salary);
            emp.setDepartment(department);
            em.getTransaction().commit();
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
            em.getTransaction().rollback();
        }

        em.close();
    }

    @Override
    public void deleteEmployee(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {
            em.remove(emp);
            em.getTransaction().commit();
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
            em.getTransaction().rollback();
        }

        em.close();
    }

    @Override
    public void fetchAllEmployees() {
        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }

        em.close();
    }

    @Override
    public void fetchEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }

        em.close();
    }

    @Override
    public void fetchEmployeeBySalary(double salary) {
        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e where e.salary = :sal";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("sal", salary);

        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No employee found with this salary.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }

        em.close();
    }

    @Override
    public void fetchAllEmployeesSortedBySalary() {
        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e order by e.salary";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }

        em.close();
    }

    @Override
    public void fetchEmployeeByMobileNumber(String mobileNumber) {
        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e join e.mobileNumbers m where m = :mob";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("mob", mobileNumber);

        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No employee found with this mobile number.");
        } else {
            for (Employee e : list) {
                System.out.println(e);
            }
        }

        em.close();
    }
}