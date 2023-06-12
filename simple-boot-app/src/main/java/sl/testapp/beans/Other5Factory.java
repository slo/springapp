package sl.testapp.beans;

import org.springframework.stereotype.Component;

public class Other5Factory implements Factory {

	@Override
	public String create() {
		return "My5Factory";
	}

}
