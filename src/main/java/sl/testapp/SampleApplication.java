package sl.testapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import sl.testapp.feature.FeeCalculator;

@AllArgsConstructor
public class SampleApplication {

    private final FeeCalculator aa;

    public void doSth(){
        LOGGER.debug(aa.calculate(new BigDecimal(5), new BigDecimal(7)));
    }

}
