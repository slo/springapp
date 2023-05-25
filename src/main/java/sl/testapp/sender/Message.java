package sl.testapp.sender;

import lombok.Value;

@Value
public class Message {

    private final Long from;
    private final Long to;
    private final String text;
}
