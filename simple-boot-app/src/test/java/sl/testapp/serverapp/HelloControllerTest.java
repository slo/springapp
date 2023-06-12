package sl.testapp.serverapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.AllArgsConstructor;

@ExtendWith(SpringExtension.class)
@AllArgsConstructor
public class HelloControllerTest extends TestBase {

	private HelloController hc;

	@Test
	void check() {
		assertThat(hc).isNotNull();
	}

}
