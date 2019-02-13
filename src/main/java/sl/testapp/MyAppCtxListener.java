package sl.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import sl.testapp.anotherfeature.Implementers;

@Component
public class MyAppCtxListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final String[] beans = beanFactory.getBeanNamesForType(Implementers.class);
        for(final String bean : beans){
            LOGGER.debug(bean);
            final BeanDefinition beanDef = beanFactory.getBeanDefinition(bean);
            LOGGER.debug(beanDef.getBeanClassName());
        }
    }
}
