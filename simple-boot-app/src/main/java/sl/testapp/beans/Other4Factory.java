package sl.testapp.beans;

import org.springframework.stereotype.Component;

@Component("my4Factory")
public class Other4Factory implements Factory {

	@Override
	public String create() {
		return "My4Factory";
	}

}
