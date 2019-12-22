package com.tdd.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.Console;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class TddApplication implements  {

	private static final Logger logger = LoggerFactory.getLogger(TddApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TddApplication.class, args);
		logger.info("*************Bowl Challenge**********************");
		logger.info("Ruta del archivo", args[0]);
	}


}
