package com.tdd.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class TddApplication  {

	/*public static void main(String[] args) {
		SpringApplication.run(TddApplication.class, args);
	}*/

	private static final Logger logger = LoggerFactory.getLogger(TddApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TddApplication.class, args);

		logger.info("Entra al main"+Arrays.toString(args));
		for(String arg:args) {
			logger.info("el argumento es"+arg);
		}

	}


}
