package sl.testapp;

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

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Config.class, TestConfig.class})
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
        when(TestConfig.featureRepository.isFeatureOn(anyString())).thenReturn(true);
        final BigDecimal result = sessionService.calculate(new BigDecimal(7), new BigDecimal(2));
        LOGGER.debug("Result1: " + result.toPlainString());
        assertThat(result).isCloseTo(new BigDecimal(42), Offset.offset(new BigDecimal(0.01)));
    }

    @Test
    public void checkResultIfFeatureOff(){
        when(TestConfig.featureRepository.isFeatureOn(anyString())).thenReturn(false);
        final BigDecimal result = sessionService.calculate(new BigDecimal(7), new BigDecimal(2));
        LOGGER.debug("Result2: " + result.toPlainString());
        assertThat(result).isCloseTo(new BigDecimal(14), Offset.offset(new BigDecimal(0.01)));
    }

}
