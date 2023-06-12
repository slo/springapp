package sl.testapp.injection.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sl.testapp.injection.SomeDependency;

@Component
public class ByField {

	@Autowired
	private SomeDependency someDependency;
}
