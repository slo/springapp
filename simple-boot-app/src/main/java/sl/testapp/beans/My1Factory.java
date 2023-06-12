package sl.testapp.beans;

import org.springframework.stereotype.Component;

@Component
public class My1Factory implements Factory {

	@Override
	public String create() {
		return "My1Factory";
	}

}
