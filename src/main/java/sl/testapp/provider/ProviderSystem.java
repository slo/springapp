package sl.testapp.provider;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class ProviderSystem {

    private final Queue<String> messages = new ArrayBlockingQueue<>(100);

    public void send(String message) {
        messages.add(message);
    }

    public int size() {
        return messages.size();
    }
}
