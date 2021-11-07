package cc.paul.demo.paulxukafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@SpringBootApplication
public class PaulxuKafkaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(paulxuKafkaApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Override
    public void run(String... args) throws Exception {
        log.info("Message Send：");
        this.template.send("test-paulxu", "paulxu-test-msg");
    }

    @KafkaListener(id = "webGroup", topics = "test-paulxu")
    public void listen(String input) {
        log.info("Message Receive: {}", input);
    }
}
