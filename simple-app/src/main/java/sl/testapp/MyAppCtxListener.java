package sl.testapp;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sl.testapp.configuration.FeatureRepository;

@Component
@AllArgsConstructor
public class MyAppCtxListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConfigurableListableBeanFactory beanFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.debug(event);
        final String[] beans = beanFactory.getBeanNamesForType(FeatureRepository.class);
        for (final String bean : beans) {
            final BeanDefinition beanDef = beanFactory.getBeanDefinition(bean);
            LOGGER.debug(bean + " is mapped to" + beanDef.getBeanClassName());
        }
    }
}
