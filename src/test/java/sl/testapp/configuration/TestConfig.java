package sl.testapp.configuration;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import sl.testapp.domain.ParameterRepository;

@Configuration
public class TestConfig {

    @Mock
    public static ParameterRepository parameterRepository;

    public TestConfig(){
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    @Primary
    public ParameterRepository getParameterRepository(){
        return parameterRepository;
    }
}
