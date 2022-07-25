package sl.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import sl.testapp.configuration.Config;
import sl.testapp.feature.FeeCalculator;

import java.math.BigDecimal;


public class Runner {

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        var si = ctx.getBean(SampleApplication.class);
        si.doSth();
        ctx.close();
    }

}
