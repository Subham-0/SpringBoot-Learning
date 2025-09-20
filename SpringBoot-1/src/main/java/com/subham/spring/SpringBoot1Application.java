package com.subham.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBoot1Application.class, args);
		Test t = context.getBean(Test.class);
		t.excute();
		
//		System.out.println(context.getApplicationName());
//		System.out.println(context.getDisplayName());
//		System.out.println(context.getStartupDate());

//		ConfigurableApplicationContext context2 = SpringApplication.run(SpringBoot1Application.class, args);
//		System.out.println(context2.getBeanDefinitionCount());
//		System.out.println(context2.getBeanDefinitionNames());
//		context2.close();
//		context2.registerShutdownHook();

	}

}
