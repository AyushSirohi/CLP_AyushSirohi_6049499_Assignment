package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.controller.dto.DepartmentEmployeeCountDTO;
import com.example.demo.controller.dto.EmployeeDepartmentDTO;
import com.example.demo.controller.dto.EmployeeMobileSearchDTO;
import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select new com.example.demo.dto.EmployeeDepartmentDTO(e.id, e.name, e.salary, d.name, d.managerName) from Employee e join e.department d")
    List<EmployeeDepartmentDTO> getAllEmployeeDepartmentDetails();

    @Query("select new com.example.demo.dto.DepartmentEmployeeCountDTO(d.name, count(e)) from Employee e join e.department d group by d.name")
    List<DepartmentEmployeeCountDTO> getEmployeeCountByDepartment();

    @Query("select e from Employee e join fetch e.department d where d.name = :deptName")
    List<Employee> findEmployeesByDepartmentName(String deptName);

    @Query("select new com.example.demo.dto.EmployeeMobileSearchDTO(e.id, e.name, d.id, d.name, d.managerName) from Employee e join e.department d join e.mobileNumbers m where m = :mobile")
    Optional<EmployeeMobileSearchDTO> findByMobileNumber(String mobile);
}