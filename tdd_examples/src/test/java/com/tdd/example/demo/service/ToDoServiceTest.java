package com.tdd.example.demo.service;

import com.tdd.example.demo.model.ToDo;
import com.tdd.example.demo.repository.ToDoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * To add extension for testing use @ExtendWith(xxExtensionYouWant to add), pero la
 * anotación @SpringBootTest ya la contiene
 */
@SpringBootTest // anotación para probar los componentes como en este caso un service,
//pero aplica para otros componenetes por debajo del controlador
public class ToDoServiceTest {

    /**
     * A continuación se haría mock de todas las dependencias de la
     * clase service
     */
    @Autowired
    private ToDoRepository toDoRepository;

    @AfterEach
    void tearDown(){
        toDoRepository.deleteAll();
    }

    @Test
    void getAll(){
        ToDo todoSample = new ToDo("Todo Sample 1",true);
        toDoRepository.save(todoSample);
        ToDoService toDoService = new ToDoService(toDoRepository);

        List<ToDo> toDoList = toDoService.findAll();
        ToDo lastToDo = toDoList.get(toDoList.size()-1);

        assertEquals(todoSample.getText(), lastToDo.getText());
        assertEquals(todoSample.isCompleted(), lastToDo.isCompleted());
        assertEquals(todoSample.getId(), lastToDo.getId());
    }

}
