package com.tdd.example.demo.controller;

import com.tdd.example.demo.model.ToDo;
import com.tdd.example.demo.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * To test whether Spring MVC controllers are working as expected, use the @WebMvcTest annotation
 * To add extension for testing use @ExtendWith(xxExtensionYouWant to add)
 */
@ExtendWith(SpringExtension.class)// ojo esta solo es para probar controladores
@WebMvcTest
public class ToDoControllerTest {

    @Autowired
    MockMvc mockMvc; //Aplica solo para probar controladores

    @MockBean
    private ToDoService toDoService;

    @Test
    void getAll() throws Exception{
        List<ToDo> listado = new ArrayList<ToDo>();
        listado.add(new ToDo(1L,"compra de pañales",true));
        listado.add(new ToDo(2L,"compra de leche",true));
        when(toDoService.findAll()).thenReturn(listado);
        mockMvc.perform(MockMvcRequestBuilders.get("/all")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }
}
