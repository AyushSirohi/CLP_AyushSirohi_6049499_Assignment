package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Departement;

public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

}