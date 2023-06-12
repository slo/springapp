package sl.testapp.beans.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class MyBeanSession {

	public MyBeanSession() {
		log.debug("Creating new instance");
	}
	
	
	public String getVal() {
		return String.valueOf(hashCode());
	}
	
	

}
