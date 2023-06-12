package sl.testapp.adapter;

import org.springframework.stereotype.Component;
import sl.testapp.sender.Message;

@Component
class ConverterToProvider {

    public ProviderMessage convert(Message message) {
        return new ProviderMessage("biz:" + message.getFrom(), "usr:" + message.getTo(), message.getText());
    }
}
