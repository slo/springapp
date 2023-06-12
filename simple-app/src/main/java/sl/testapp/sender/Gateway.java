package sl.testapp.sender;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import sl.testapp.adapter.ProviderAdapter;
import sl.testapp.session.SessionService;

@AllArgsConstructor
@Component
public class Gateway {

    private static final Logger LOGGER = LogManager.getLogger();

    private final SessionService sessionService;
    private final ProviderAdapter providerAdapter;

    public void send(Message message) {
        LOGGER.debug(message);
        if (!sessionService.checkSession(message.getFrom(), message.getTo())) {
            LOGGER.debug("Message dropped :D");
            return;
        }

        providerAdapter.send(message);
    }
}
