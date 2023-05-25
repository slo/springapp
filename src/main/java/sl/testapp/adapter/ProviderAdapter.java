package sl.testapp.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sl.testapp.provider.ProviderSystem;
import sl.testapp.sender.Message;

@Component
@AllArgsConstructor
public class ProviderAdapter {

    private final ConverterToProvider converter;
    private final ProviderSystem providerSystem;

    public void send(Message message) {
        var providerMessage = converter.convert(message);
        providerSystem.send(providerMessage.toString());
    }
}
