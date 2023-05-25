package sl.testapp.adapter;

import lombok.Value;

@Value
public class ProviderMessage {

    private final String business;
    private final String user;
    private final String content;
}
