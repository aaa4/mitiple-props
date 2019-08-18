package c.e.d;

import c.e.d.p.Message;
import c.e.d.p.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class CheckPropsApplication implements CommandLineRunner {

    @Value("${my.message}")
    private String message;

    @Autowired
    MessageRepository messageRepository;

    public static void main(String[] args) {
        SpringApplication.run(CheckPropsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("message is: {}", message);
        Message msg = new Message();
        msg.setMessage(message);
        messageRepository.save(msg);
    }
}
