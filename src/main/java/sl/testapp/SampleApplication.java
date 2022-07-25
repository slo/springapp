package sl.testapp;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import sl.testapp.feature.FeeCalculator;

@AllArgsConstructor
@Component
public class SampleApplication {
	
    private static final Logger LOGGER = LogManager.getLogger();

    private final FeeCalculator aa;

    public void doSth(){
        LOGGER.debug(aa.calculate(new BigDecimal(5), new BigDecimal(7)));
    }

}
