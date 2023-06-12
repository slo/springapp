package sl.testapp.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import sl.testapp.otherstarter.MyOtherComponent;

@Configuration
@ComponentScan(basePackages = {
		"sl.testapp.starter"
		})
public class StarterAutoConfiguration {
	
	@Bean
	MyOtherComponent myOtherComponent1() {
		return new MyOtherComponent();
	}
	
	@Bean
	MyOtherComponent myOtherComponent2() {
		return new MyOtherComponent();
	}

}
