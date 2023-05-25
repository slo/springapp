package sl.testapp.configuration;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class FeatureRepository {

    private final Map<String, Boolean> features = new HashMap<>();

    @PostConstruct
    public void fill() {
        features.put("F1", false);
        features.put("F2", false);
    }

    public boolean isFeatureOn(String feature)
    {
        return features.get(feature);
    }
}
