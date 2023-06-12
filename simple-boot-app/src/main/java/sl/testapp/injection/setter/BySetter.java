package sl.testapp.injection.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sl.testapp.injection.SomeDependency;

@Component
public class BySetter {

	private SomeDependency someDependency;
	
	@Autowired
	public void setSomeDependency(SomeDependency someDependency) {
		this.someDependency = someDependency;
	}
}
