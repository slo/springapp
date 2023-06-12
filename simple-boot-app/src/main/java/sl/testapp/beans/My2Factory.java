package sl.testapp.beans;

import org.springframework.stereotype.Component;

@Component
public class My2Factory implements Factory {

	@Override
	public String create() {
		return "My2Factory";
	}

}
