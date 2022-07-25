package sl.testapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sl.testapp.configuration.Config;
import sl.testapp.provider.ProviderSystem;
import sl.testapp.sender.Gateway;
import sl.testapp.sender.Message;

import java.util.*;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(final String[] args) {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        var gateway = ctx.getBean(Gateway.class);

        var provider = ctx.getBean(ProviderSystem.class);

        var randomGen = new Random();

        long delay = 1000L;
        producer(gateway, randomGen, delay);

        reader(provider, delay);

        ctx.close();
    }

    private static void reader(ProviderSystem providerSystem, long delay) {
        TimerTask taskRead = new TimerTask() {
            @Override
            public void run() {
                LOGGER.debug("Sent: " + providerSystem.size());
            }
        };
        Timer tr = new Timer("Reader");
        tr.schedule(taskRead, 0, delay * 2);
    }

    private static long producer(Gateway si, Random randomGen, long delay) {
        TimerTask task = new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                si.send(new Message(randomGen.nextLong(4), randomGen.nextLong(4) + 100,
                                    "Message [" + (++counter) + "]"));
            }
        };

        Timer t = new Timer("Writer");
        t.schedule(task, 0, delay);
        return delay;
    }
}
