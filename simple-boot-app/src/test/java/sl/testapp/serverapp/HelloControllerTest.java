package sl.testapp.serverapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sl.testapp.serverapp.HelloController;
import sl.testapp.simplebootapp.SimpleBootAppApplication;
import sl.testapp.simplebootapp.TestBase;

@SpringBootTest(classes = SimpleBootAppApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest extends TestBase {

	private HelloController hc;
	
	

	public HelloControllerTest(HelloController hc) {
		this.hc = hc;
	}



	@Test
	void check() {
		assertThat(hc).isNotNull();
	}

}
