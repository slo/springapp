package sl.testapp.configuration;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {

	@Mock
	public static FeatureRepository parameterRepository;

	public TestConfig() {
		MockitoAnnotations.initMocks(this);
	}

	@Bean
	@Primary
	public FeatureRepository getParameterRepository() {
		return parameterRepository;
	}
}
