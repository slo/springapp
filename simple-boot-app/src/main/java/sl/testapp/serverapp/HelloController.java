package sl.testapp.serverapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);

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

	// mind the name
	private MyOtherComponent myOtherComponent1;

	private MyOtherComponent myOtherComponent2;

	@GetMapping("/hello")
	String getHello(String name) throws InterruptedException {
		log.debug("HELLOOOOO!!!!!");
		log.debug(req1.getVal());
		log.debug(sess1.getVal());
		return "Hello: " + name + "_" + my5Factory.create();
	}

	public HelloController(Factory my1Factory, Factory my2Factory, Factory my3Factory, Factory my4Factory,
			Factory my5Factory, List<Factory> factories, ByConstructor byConstructor, ByField byfield,
			BySetter bySetter, MyBeanPrototype proto1, MyBeanPrototype proto2, MyBeanRequest req1, MyBeanSession sess1,
			MyService myService, MyComponent myComponent, MyOtherComponent myOtherComponent1,
			MyOtherComponent myOtherComponent2) {
		this.my1Factory = my1Factory;
		this.my2Factory = my2Factory;
		this.my3Factory = my3Factory;
		this.my4Factory = my4Factory;
		this.my5Factory = my5Factory;
		this.factories = factories;
		this.byConstructor = byConstructor;
		this.byfield = byfield;
		this.bySetter = bySetter;
		this.proto1 = proto1;
		this.proto2 = proto2;
		this.req1 = req1;
		this.sess1 = sess1;
		this.myService = myService;
		this.myComponent = myComponent;
		this.myOtherComponent1 = myOtherComponent1;
		this.myOtherComponent2 = myOtherComponent2;
	}
}
