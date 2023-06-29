package sl.testapp.injection.constructor;

import org.springframework.stereotype.Component;

import sl.testapp.injection.SomeDependency;

@Component
public class ByConstructor {
	
	private SomeDependency someDependency;

	
	public ByConstructor(SomeDependency someDependency) {
		this.someDependency = someDependency;
	}

}
