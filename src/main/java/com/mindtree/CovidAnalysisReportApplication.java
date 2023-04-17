package com.mindtree;

import com.mindtree.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidAnalysisReportApplication implements CommandLineRunner {

	@Autowired
	private MainController mainController;

	public static void main(String[] args) {
		SpringApplication.run(CovidAnalysisReportApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.mainController.Introduction();

	}
}
