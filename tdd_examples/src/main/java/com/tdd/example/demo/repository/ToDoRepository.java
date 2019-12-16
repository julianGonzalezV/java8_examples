package com.tdd.example.demo.repository;

import com.tdd.example.demo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Logicamente este tipo de interfaces no tiene si SUIT de pruebas porque
 * no tenemos implementaciones concretas
 */
@Repository("toDoRepository")
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
