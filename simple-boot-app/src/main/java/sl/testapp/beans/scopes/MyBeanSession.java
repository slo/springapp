package sl.testapp.beans.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyBeanSession {
	
	private static final Logger log = LoggerFactory.getLogger(MyBeanSession.class);

	public MyBeanSession() {
		log.debug("Creating new instance");
	}
	
	
	public String getVal() {
		return String.valueOf(hashCode());
	}
	
	

}
