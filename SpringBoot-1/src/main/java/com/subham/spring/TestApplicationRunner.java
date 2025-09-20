package com.subham.spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ApplicationRunner running...");
//		System.out.println("Option names: " + args.getOptionNames());
		if (args.containsOption("name")) {
			System.out.println("Name: " + args.getOptionValues("name"));
		} else {
			System.out.println("Non-option args: " + args.getNonOptionArgs());
		}
	}

}
