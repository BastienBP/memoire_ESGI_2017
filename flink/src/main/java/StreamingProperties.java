import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Properties;

/**
 * Created by bbr on 06/11/2017.
 */
public abstract class StreamingProperties {
    protected Properties config;
    protected  StreamingProperties() {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("zookeeper.connect", "localhost:2181");
        properties.setProperty("group.id", "flink_consumer");

        config = new Properties(properties);

    }

}
