package com.jpa.association;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(root);

        List<Employee> list = em.createQuery(cq).getResultList();

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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();

        Root<Employee> root = cq.from(Employee.class);

        cq.multiselect(
                root.get("department").get("name"),
                cb.count(root)
        );

        cq.groupBy(root.get("department").get("name"));

        List<Tuple> list = em.createQuery(cq).getResultList();

        if (list.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Tuple t : list) {
                System.out.println("Department Name: " + t.get(0));
                System.out.println("Number of Employees: " + t.get(1));
                System.out.println("------------------------------");
            }
        }

        em.close();
    }

    @Override
    public void employeesByDepartmentName(String deptName) {

        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(root).where(cb.equal(root.get("department").get("name"), deptName));

        List<Employee> list = em.createQuery(cq).getResultList();

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
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        Expression<java.util.Collection<String>> mobiles = root.get("mobileNumbers");
        cq.select(root).where(cb.isMember(mobile, mobiles));

        List<Employee> list = em.createQuery(cq).getResultList();

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