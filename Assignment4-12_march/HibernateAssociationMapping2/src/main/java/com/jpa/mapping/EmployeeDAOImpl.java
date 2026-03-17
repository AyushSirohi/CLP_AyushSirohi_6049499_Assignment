package com.jpa.mapping;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");

    @Override
    public void insertEmployee(Employee emp, Department dept) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department existingDept = em.find(Department.class, dept.getId());

        if (existingDept == null) {
            dept.getEmployees().add(emp);
            emp.setDepartment(dept);
            em.persist(dept);
        } else {
            emp.setDepartment(existingDept);
            existingDept.getEmployees().add(emp);
            em.persist(emp);
        }

        em.getTransaction().commit();
        em.close();

        System.out.println("Employee inserted successfully.");
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
                System.out.println("Employee Id: " + e.getId());
                System.out.println("Employee Name: " + e.getName());
                System.out.println("Salary: " + e.getSalary());
                System.out.println("Mobile Numbers: " + e.getMobileNumbers());
                System.out.println("Department Name: " + e.getDepartment().getName());
                System.out.println("Manager Name: " + e.getDepartment().getManagerName());
                System.out.println("------------------------------");
            }
        }

        em.close();
    }

    @Override
    public void countEmployeesByDepartment() {

        EntityManager em = emf.createEntityManager();

        String jpql = "select e.department.name, count(e) from Employee e group by e.department.name";
        Query query = em.createQuery(jpql);
        List<Object[]> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Object[] obj : list) {
                System.out.println("Department Name: " + obj[0]);
                System.out.println("Number of Employees: " + obj[1]);
                System.out.println("------------------------------");
            }
        }

        em.close();
    }

    @Override
    public void employeesByDepartmentName(String deptName) {

        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e where e.department.name = :dname";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("dname", deptName);

        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No employees found in this department.");
        } else {
            for (Employee e : list) {
                System.out.println("Employee Id: " + e.getId());
                System.out.println("Employee Name: " + e.getName());
                System.out.println("Salary: " + e.getSalary());
                System.out.println("Mobile Numbers: " + e.getMobileNumbers());
                System.out.println("------------------------------");
            }
        }

        em.close();
    }

    @Override
    public void departmentDetailsByMobile(String mobile) {

        EntityManager em = emf.createEntityManager();

        String jpql = "select e from Employee e join e.mobileNumbers m where m = :mob";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("mob", mobile);

        List<Employee> list = query.getResultList();

        if (list.isEmpty()) {
            System.out.println("No employee found with this mobile number.");
        } else {
            for (Employee e : list) {
                System.out.println("Employee Id: " + e.getId());
                System.out.println("Employee Name: " + e.getName());
                System.out.println("Department Id: " + e.getDepartment().getId());
                System.out.println("Department Name: " + e.getDepartment().getName());
                System.out.println("Manager Name: " + e.getDepartment().getManagerName());
                System.out.println("------------------------------");
            }
        }

        em.close();
    }
}