package sl.testapp.session.provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FileSession implements SessionProvider{
	
	private static final Logger LOGGER = LogManager.getLogger();

	@Override
	public boolean checkSessionExists(Long sessionId) {
		LOGGER.debug("Checking session from File");
		return true;
		
	}

}
