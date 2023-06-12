package sl.testapp.beans;

import org.springframework.stereotype.Component;

public class My3Factory implements Factory {

	@Override
	public String create() {
		return "My3Factory";
	}

}
