package sl.testapp.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@MyCustomAnnotation(discriminator = "dwa")
public @interface MySecondSpecificAnnotation {
}