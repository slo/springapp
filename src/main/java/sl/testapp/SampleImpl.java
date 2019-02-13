package sl.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import sl.testapp.configuration.Config;
import sl.testapp.feature.FeeCalculator;

import java.math.BigDecimal;

@Component
public class SampleImpl {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private FeeCalculator aa;

    public void doSth(){
        LOGGER.debug(aa.calculate(new BigDecimal(5), new BigDecimal(7)));
    }

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        SampleImpl si = ctx.getBean(SampleImpl.class);
        si.doSth();
        ctx.close();
    }

}
