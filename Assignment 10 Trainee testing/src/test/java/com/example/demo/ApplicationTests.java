package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Trainee;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

    @Autowired
    private TraineeServices traineeServices;

    @Test
    @Order(1)
    void contextLoads() {
        assertNotNull(traineeServices);
    }

    @Test
    @Order(2)
    void testAddTrainee() {
        Trainee trainee = new Trainee("Ayush", "Java", "Ghaziabad");
        traineeServices.addTrainee(trainee);

        List<Trainee> list = traineeServices.fetchByName("Ayush");
        assertFalse(list.isEmpty());
    }

    @Test
    @Order(3)
    void testFetchAll() {
        List<Trainee> list = traineeServices.fetchAll();
        assertNotNull(list);
    }

    @Test
    @Order(4)
    void testFetchById() {
        Trainee trainee = new Trainee("Rahul", "Spring", "Noida");
        traineeServices.addTrainee(trainee);

        List<Trainee> list = traineeServices.fetchByName("Rahul");
        int id = list.get(0).gettId();

        Optional<Trainee> found = traineeServices.fetchById(id);
        assertTrue(found.isPresent());
        assertEquals("Rahul", found.get().gettNAme());
    }

    @Test
    @Order(5)
    void testUpdateTrainee() {
        Trainee trainee = new Trainee("Karan", "Python", "Delhi");
        traineeServices.addTrainee(trainee);

        List<Trainee> list = traineeServices.fetchByName("Karan");
        Trainee existing = list.get(0);

        existing.settNAme("KaranUpdated");
        existing.settDomain("FullStack");
        existing.settLoaction("Gurgaon");

        traineeServices.updateTrainee(existing);

        Optional<Trainee> updated = traineeServices.fetchById(existing.gettId());
        assertTrue(updated.isPresent());
        assertEquals("KaranUpdated", updated.get().gettNAme());
        assertEquals("FullStack", updated.get().gettDomain());
        assertEquals("Gurgaon", updated.get().gettLoaction());
    }

    @Test
    @Order(6)
    void testDeleteById() {
        Trainee trainee = new Trainee("DeleteMe", "Testing", "Meerut");
        traineeServices.addTrainee(trainee);

        List<Trainee> list = traineeServices.fetchByName("DeleteMe");
        int id = list.get(0).gettId();

        traineeServices.deleteById(id);

        Optional<Trainee> deleted = traineeServices.fetchById(id);
        assertFalse(deleted.isPresent());
    }

    @Test
    @Order(7)
    void testFetchByName() {
        Trainee trainee = new Trainee("SameName", "React", "Lucknow");
        traineeServices.addTrainee(trainee);

        List<Trainee> list = traineeServices.fetchByName("SameName");
        assertFalse(list.isEmpty());
        assertEquals("SameName", list.get(0).gettNAme());
    }
}