package sl.testapp.session;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import sl.testapp.session.provider.SessionProvider;

@Component
@AllArgsConstructor
public class SessionService {
	
	private final SessionProvider fileSession;

    public boolean checkSession(Long from, Long to) {
        return fileSession.checkSessionExists(from);
    }
}
