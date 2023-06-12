package sl.testapp.injection.constructor;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import sl.testapp.injection.SomeDependency;

@Component
@AllArgsConstructor
public class ByConstructor {
	
	private SomeDependency someDependency;

	/*
	public ByConstructor(SomeDependency someDependency) {
		this.someDependency = someDependency;
	}
	*/
	

	
}
