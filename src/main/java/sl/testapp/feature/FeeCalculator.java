package sl.testapp.feature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import sl.testapp.domain.ParameterRepository;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class FeeCalculator {
    
    private final ParameterRepository parameterRepository;

    public BigDecimal calculate(BigDecimal base, BigDecimal scale){
        if(parameterRepository.isFeatureOn()){
            return base.multiply(scale.multiply(new BigDecimal(3)));
        } else {
            return base.multiply(scale);
        }

    }
}
