package sl.testapp.spam.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@MyCustomAnnotation(discriminator = "jeden")
public @interface MyFirstSpecificAnnotation {
}