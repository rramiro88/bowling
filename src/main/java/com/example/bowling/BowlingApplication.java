package com.example.bowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
                        SpringApplication.run(BowlingApplication.class, args);
                
                MainBean mainBean = context.getBean(MainBean.class);
                
                mainBean.execute();
                
	}

}
