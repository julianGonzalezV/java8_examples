package com.tdd.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EjemploComp {
    private static final Logger logger = LoggerFactory.getLogger(EjemploComp.class);
    @Autowired
    public EjemploComp(ApplicationArguments args)
    {
        logger.info("111111111111111", Arrays.toString(args.getSourceArgs()));
        logger.info("222222222222", args.getNonOptionArgs());
        logger.info("33333333333", args.getOptionNames());

        logger.info("HOLAAAAAAAAAAA");
        for (String name : args.getOptionNames()){
            logger.info("4444444444" + name + "=" + args.getOptionValues(name));
        }

        args.getOptionNames().forEach(optionName -> {
            System.out.println(optionName + "=" + args.getOptionValues(optionName));
            logger.info("4444444444" + optionName + "=" + args.getOptionValues(optionName));
        });
    }
}
