package sl.testapp.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sl.testapp.domain.ParameterRepository;

import java.math.BigDecimal;

@Component
public class FeeCalculator {
    @Autowired
    private ParameterRepository parameterRepository;

    public BigDecimal calculate(BigDecimal base, BigDecimal scale){
        if(parameterRepository.isFeatureOn()){
            return base.multiply(scale.multiply(new BigDecimal(3)));
        } else {
            return base.multiply(scale);
        }

    }
}
