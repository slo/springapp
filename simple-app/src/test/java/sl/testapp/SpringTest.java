package sl.testapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import sl.testapp.configuration.Config;
import sl.testapp.configuration.TestConfig;
import sl.testapp.session.SessionService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { Config.class, TestConfig.class })
public class SpringTest {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private SessionService sessionService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
    public void checkResultIfFeatureOn(){
        when(TestConfig.parameterRepository.isFeatureOn(anyString())).thenReturn(true);
        var result = sessionService.checkSession(7L, 2L);
        LOGGER.debug("Result1: " + result);
        assertThat(result).isTrue();
    }

	@Test
    public void checkResultIfFeatureOff(){
        when(TestConfig.parameterRepository.isFeatureOn(anyString())).thenReturn(false);
        var result = sessionService.checkSession(7L, 2L);
        LOGGER.debug("Result2: " + result);
        assertThat(result).isTrue();
    }

}