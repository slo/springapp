package sl.testapp.simplebootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import sl.testapp.beans.Factory;
import sl.testapp.beans.My3Factory;
import sl.testapp.beans.Other5Factory;

@SpringBootApplication
@ComponentScan(basePackages = {
		"sl.testapp.beans",
		"sl.testapp.serverapp",
		"sl.testapp.injection"
		})
@Slf4j
public class SimpleBootAppApplication {

	public static void main(String[] args) {
		log.debug("Started");
		SpringApplication.run(SimpleBootAppApplication.class, args);
	}

	
	@Bean
	Factory my3Factory() {
		return new My3Factory();
	}
	
	@Bean("my5Factory")
	Factory other5Factory() {
		return new Other5Factory();
	}
}
