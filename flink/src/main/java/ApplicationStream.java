
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer082;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import scala.App;


import java.util.Properties;

public class ApplicationStream extends StreamingProperties{

    public static void main(String[] args) throws Exception {
        // create execution environment
        ApplicationStream main = new ApplicationStream();
        main.run();
    }
    private void run() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> stream = env
                .addSource(new FlinkKafkaConsumer082<>("foobar", new SimpleStringSchema(), config));

        stream.print();
        env.execute();
    }
}
