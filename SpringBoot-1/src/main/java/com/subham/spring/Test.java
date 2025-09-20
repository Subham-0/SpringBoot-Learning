package com.subham.spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class Test {

	private TestApplicationRunner testApplicationRunner;
	private TestCommandLineRunner testCommandLineRunner;

	public Test(TestApplicationRunner Tr,TestCommandLineRunner Cr) {
		this.testApplicationRunner = Tr;
		this.testCommandLineRunner = Cr;
	}

	public void excute() {
		ApplicationArguments appArgs = new DefaultApplicationArguments("--name=Subham", "test");
		try {
			testApplicationRunner.run(appArgs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			testCommandLineRunner.run("hello","boz");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
