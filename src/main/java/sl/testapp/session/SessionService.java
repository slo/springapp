package sl.testapp.session;

import org.springframework.stereotype.Component;

@Component
public class SessionService {

    public boolean checkSession(Long from, Long to) {
        return from != 3;
    }
}
