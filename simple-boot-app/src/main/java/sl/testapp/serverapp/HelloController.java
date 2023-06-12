package sl.testapp.serverapp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sl.testapp.beans.Factory;
import sl.testapp.beans.scopes.MyBeanPrototype;
import sl.testapp.beans.scopes.MyBeanRequest;
import sl.testapp.beans.scopes.MyBeanSession;
import sl.testapp.injection.constructor.ByConstructor;
import sl.testapp.injection.field.ByField;
import sl.testapp.injection.setter.BySetter;
import sl.testapp.otherstarter.MyOtherComponent;
import sl.testapp.starter.MyComponent;

@RestController
@Slf4j
@AllArgsConstructor
class HelloController {
	
	private Factory my1Factory;
	private Factory my2Factory;
	private Factory my3Factory;
	private Factory my4Factory;
	private Factory my5Factory;
	
	private List<Factory> factories;
	private ByConstructor byConstructor;
	private ByField byfield;
	private BySetter bySetter;
	private MyBeanPrototype proto1;
	private MyBeanPrototype proto2;
	
	private MyBeanRequest req1;
	private MyBeanSession sess1;
	
	private MyService myService;
	private MyComponent myComponent;
	
	//mind the name
	private MyOtherComponent myOtherComponent1;
	
	private MyOtherComponent myOtherComponent2;

	@GetMapping("/hello")
	String getHello(String name) throws InterruptedException {
		log.debug("HELLOOOOO!!!!!");
		log.debug(req1.getVal());
		log.debug(sess1.getVal());
		return "Hello: " + name + "_" + my5Factory.create();
	}
}
