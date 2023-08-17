package com.github.atomfrede.applicationinsightsdemo;

import com.microsoft.applicationinsights.attach.ApplicationInsights;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationInsightsDemoApplication {

	public static void main(String[] args) {
		ApplicationInsights.attach();
		SpringApplication.run(ApplicationInsightsDemoApplication.class, args);
	}

}
